package app.silniczek.mapa;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 07.01.15.
 */
public class PustaMapa extends GlownaMapa {

    private String ZNACZNIK = "TloMapy : ";
    private GL10 gl10;

    public PustaMapa(GL10 gl10, int nrKolumny, int nrWiersza) {
        this.gl10 = gl10;

        brick.posX = nrKolumny * 0.1f;
        brick.posY = nrWiersza * 0.1f;

    }

    public void tworzenieMapy(){

        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        gl10.glTranslatef(brick.posX, brick.posY, 0);
        gl10.glMatrixMode(GL10.GL_TEXTURE);
        gl10.glLoadIdentity();
        //brick.rysuj(gl10, tekstury[0]);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();

    }
}

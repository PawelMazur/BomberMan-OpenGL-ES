package app.silniczek.mapa;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 11.01.15.
 */
public class DymMapa extends GlownaMapa {

    private String ZNACZNIK = "DymMapa : ";
    private GL10 gl10;

    private int[] tekstura1;
    private int[] tekstura2;

    public DymMapa(GL10 gl10, int nrKolumny, int nrWiersza, int[] tekstura1, int[] tekstura2) {
        this.gl10 = gl10;

        brick.posX = nrKolumny * 0.1f;
        brick.posY = nrWiersza * 0.1f;

        this.tekstura1 = tekstura1;
        this.tekstura2 = tekstura2;
    }

    public void tworzenieMapy(){

        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        gl10.glTranslatef(brick.posX, brick.posY, 0);
        //Log.d(ZNACZNIK, "posX: " + brick.posX + " posY: " + brick.posY);
        gl10.glMatrixMode(GL10.GL_TEXTURE);
        gl10.glLoadIdentity();
        if (!brick.isDestroy){
            //brick.rysuj(gl10, tekstura[0]);
            brick.rysuj(gl10, tekstura1);
        } else {
            //brick.rysuj(gl10, tekstura[1]);
            brick.rysuj(gl10, tekstura2);
        }
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }
}

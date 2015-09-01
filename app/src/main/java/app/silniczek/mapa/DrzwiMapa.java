package app.silniczek.mapa;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 09.02.15.
 */
public class DrzwiMapa extends GlownaMapa {

    private String ZNACZNIK = "TloMapy : ";
    private GL10 gl10;

    private int nrKolumny;
    private int nrWiersza;

    private int[] tekstura1;
    private int[] tekstura2;

    public DrzwiMapa(GL10 gl10, int nrKolumny, int nrWiersza, int[] tekstura1, int[] tekstura2) {
        this.gl10 = gl10;
        this.nrKolumny = nrKolumny;
        this.nrWiersza = nrWiersza;
        //brick.posX = nrKolumny * 0.1f;
        //brick.posY = nrWiersza * 0.1f;

        this.tekstura1 = tekstura1;
        this.tekstura2 = tekstura2;
        tworzenieMapy();

    }

    public void tworzenieMapy(){

        if (!brick.isDestroy){
            brick.posX = nrKolumny * 0.1f;
            brick.posY = nrWiersza * 0.1f;
            gl10.glPushMatrix();
            gl10.glMatrixMode(GL10.GL_MODELVIEW);
            gl10.glLoadIdentity();

            /*if (przesuniecie){
                przesuniecie_X += 0.01f;
            }*/

            gl10.glTranslatef(brick.posX, brick.posY , 0);
            gl10.glMatrixMode(GL10.GL_TEXTURE);
            gl10.glLoadIdentity();
            if (brick.typCegly == 2){
                //brick.rysuj(gl10, tekstury[0]);
                brick.rysuj(gl10, tekstura1);
            }if (brick.typCegly == 1){
                brick.rysuj(gl10, tekstura2);
            }
            gl10.glPopMatrix();
            gl10.glLoadIdentity();
        }

    }
}

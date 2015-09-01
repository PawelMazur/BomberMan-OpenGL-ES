package app.silniczek.mapa;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 07.02.15.
 */
public class KolceMapa extends GlownaMapa {

    private String ZNACZNIK = "KolceMap : ";
    private GL10 gl10;

    private int nrKolumny;
    private int nrWiersza;

    private int[] tekstura1;
    private int[] tekstura2;

    //private float pozycja_X = 0;
    //private float pozycja_Y = 0;

    private float zakres_lewy_X = 20;
    private float zakres_prawy_X = 20;

    private float przes = -0.1f;
    private float przesuniecie_X = 0.01f;

    //private float poruszanie = 0.01f;
    private float czas = 20;


    public KolceMapa(GL10 gl10, int nrKolumny, int nrWiersza, int[] tekstura1, int[] tekstura2) {
        this.gl10 = gl10;
        this.nrKolumny = nrKolumny;
        this.nrWiersza = nrWiersza;

        this.tekstura1 = tekstura1;
        this.tekstura2 = tekstura2;



        //brick.posX = nrKolumny * 0.1f;
        //brick.posY = nrWiersza * 0.1f;
        //brick.typCegly = 3;
    }

    @Override
    public void tworzenieMapy() {
        if (!brick.isDestroy){
            brick.posX = nrKolumny * 0.1f;
            brick.posY = nrWiersza * 0.1f;

            gl10.glPushMatrix();
            gl10.glMatrixMode(GL10.GL_MODELVIEW);
            gl10.glLoadIdentity();

            if (zakres_prawy_X > 0){
                move_right();
                zakres_prawy_X--;
            }else if (zakres_lewy_X == 0){
                //pozycja_X = pozycja_X + poruszanie1;
                zakres_prawy_X = 20;
                zakres_lewy_X = 20;
            }else if (zakres_prawy_X <= 0){
                move_left();
                zakres_lewy_X--;
            }

            //Log.d(ZNACZNIK, "Pozycja : " + pozycja_X );
            brick.posX = brick.posX + pozycja_X;

            //Log.d(ZNACZNIK , "Brick X : " + brick.posX);
            gl10.glTranslatef(brick.posX , brick.posY  , 0);
            //Log.d(ZNACZNIK, "posX: " + brick.posX + " posY: " + brick.posY);
            gl10.glMatrixMode(GL10.GL_TEXTURE);
            gl10.glLoadIdentity();
            brick.rysuj(gl10, tekstura1);
            gl10.glPopMatrix();
            gl10.glLoadIdentity();
        }
    }

}

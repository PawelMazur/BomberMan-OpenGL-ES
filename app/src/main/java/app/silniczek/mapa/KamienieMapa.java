package app.silniczek.mapa;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 31.01.15.
 */
public class KamienieMapa extends GlownaMapa {

    private String ZNACZNIK = "Kamienie : ";
    private GL10 gl10;

    private int nrKolumny;
    private int nrWiersza;

    private int[] tekstura1;
    private int[] tekstura2;

    private float pozycja_X = 0;
    private float pozycja_Y = 0;

    private float poruszanie = 0.01f;

    public KamienieMapa(GL10 gl10, int nrKolumny, int nrWiersza, int[] tekstura1, int[] tekstura2) {
        this.gl10 = gl10;
        this.nrKolumny = nrKolumny;
        this.nrWiersza = nrWiersza;

        this.tekstura1 = tekstura1;
        this.tekstura2 = tekstura2;

        //brick.posX = nrKolumny * 0.1f;
        //brick.posY = nrWiersza * 0.1f;
        //brick.typCegly = 3;
    }

    public void tworzenieMapy(){
        if (!brick.isDestroy){
            brick.posX = nrKolumny * 0.1f;
            brick.posY = nrWiersza * 0.1f;

            gl10.glPushMatrix();
            gl10.glMatrixMode(GL10.GL_MODELVIEW);
            gl10.glLoadIdentity();
            /*(if (przesuniecie){
                przesuniecie_X += 0.01f;
            }*/
            //Log.d(ZNACZNIK, " pozycia : " + brick.posX );
            /*if (brick.posX > zakres_lewy_X ){
                brick.posX = brick.posX + przes;
            } else if (brick.posX == zakres_lewy_X){
                przes = przes * -1f;
            }else if (brick.posX < zakres_prawy_X ){
                brick.posX = brick.posX + przes;
            }else if (brick.posX == zakres_prawy_X ){
                przes = przes * -1f;
            }*/
            pozycja_Y = pozycja_Y - poruszanie;
            brick.posY = brick.posY - pozycja_Y;
            if (brick.posY >= 0.90){
                pozycja_Y = pozycja_Y * -1f;
            } if (brick.posY <= 0.1){
                //pozycja_Y = pozycja_Y + poruszenie;
            }
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

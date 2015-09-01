package app.silniczek.mapa;


import javax.microedition.khronos.opengles.GL10;

import app.silniczek.pociski.Bron;
import app.silniczek.pociski.Granatnik;
import app.silniczek.pociski.Kula;
import app.silniczek.pociski.Mina;
import app.silniczek.pociski.Miotacz;
import app.silniczek.pociski.Pociski;

/**
 * Created by Pawel on 08.02.15.
 */
public class Enemy extends GlownaMapa implements Bron {

    private String ZNACZNIK = "EnemyMap : ";
    private GL10 gl10;

    private int nrKolumny;
    private int nrWiersza;

    private int[] tekstura1;
    private int[] tekstura2;

    private float pozycja_X = 0;
    private float pozycja_Y = 0;

    private float zakres_lewy_X = 20;
    private float zakres_prawy_X = 20;

    private float poruszanie = 0.01f;

    private boolean strzal = true;
    private boolean cos = true;
    private Pociski pociski;

    private float pocisk_posX;
    private float pocisk_posY;


    public Enemy(GL10 gl10, int nrKolumny, int nrWiersza, int[] tekstura1, int[] tekstura2) {
        this.gl10 = gl10;
        this.nrKolumny = nrKolumny;
        this.nrWiersza = nrWiersza;

        this.tekstura1 = tekstura1;
        this.tekstura2 = tekstura2;

        //tworzenieMapy(0);



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
                pozycja_X = pozycja_X + poruszanie;
                zakres_prawy_X--;
                strzal = true;
            }else if (zakres_lewy_X == 0){
                zakres_prawy_X = 20;
                zakres_lewy_X = 20;
            }else if (zakres_prawy_X <= 0){
                pozycja_X = pozycja_X - poruszanie;
                zakres_lewy_X--;
            }


            //Log.d(ZNACZNIK, "Pozycja : " + pozycja_X);
            brick.posX = brick.posX + pozycja_X;

            //Log.d(ZNACZNIK , "Brick X : " + brick.posX);
            gl10.glTranslatef(brick.posX , brick.posY  , 0);
            //Log.d(ZNACZNIK, "posX: " + brick.posX + " posY: " + brick.posY);
            gl10.glMatrixMode(GL10.GL_TEXTURE);
            gl10.glLoadIdentity();
            brick.rysuj(gl10, tekstura1);
            gl10.glPopMatrix();
            gl10.glLoadIdentity();

            /*
            if (isShot()){
                pocisk_posX = brick.posX + 0.2f;
                pocisk_posY = brick.posY;
                strzal = false;
                cos = true;
            }
            pociski.wystrzel(gl10, pocisk_posY, pocisk_posX, cos);
            */
            if (isShot()){
                pociski.wystrzel(gl10, brick.posY, brick.posX + 0.15f , isShot());
            }

        }

    }

    @Override
    public Pociski miotacz(float x, float y, int[] tekstura) {
        return new Miotacz(x, y, tekstura);
    }

    @Override
    public Pociski mina(float x, float y, int[] tekstura) {
        return new Mina(x, y, tekstura);
    }

    @Override
    public Pociski kula(float x, float y, int[] tekstura) {
        return new Kula(x, y, tekstura);
    }

    @Override
    public Pociski granatnik(float x, float y, int[] tekstura) {
        return new Granatnik(x, y, tekstura);
    }

    @Override
    public Pociski bomba(float x, float y, int[] ...tekstura) {
        return null;
    }

    public boolean isShot() {
        return strzal;
    }

    public void setPociski(Pociski pociski) {
        this.pociski = pociski;
    }
}

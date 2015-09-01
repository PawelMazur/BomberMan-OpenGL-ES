package app.silniczek.mapa;


import android.util.Log;

import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import app.silniczek.geometria.Box;
import app.silniczek.pociski.Bomba;
import app.silniczek.pociski.Granatnik;
import app.silniczek.pociski.Kula;
import app.silniczek.pociski.Mina;
import app.silniczek.pociski.Miotacz;
import app.silniczek.pociski.Pociski;

/**
 * Created by Pawel on 2015-03-16.
 */
public class EnemyM extends EnemyMapa {

    private String ZNACZNIK = "EnemyM : ";
    private GL10 gl10;
    private int nrKolumny;
    private int nrWiersza;
    private int[] tekstura1;
    private int[] tekstura2;
    private Random random = new Random();
    private int czas = 30;
    private boolean ruch = true;
    private int zakres = 10;
    private int zakres_bomby = 20;
    private boolean strzal = false;
    int r = -1;

    private Pociski pociski;

    public EnemyM(GL10 gl10, int nrKolumny, int nrWiersza, int[] tekstura1, int[] tekstura2) {

        this.gl10 = gl10;
        this.nrKolumny = nrKolumny;
        this.nrWiersza = nrWiersza;

        this.tekstura1 = tekstura1;
        this.tekstura2 = tekstura2;

        box = new Box(0.09f, 0.09f);

    }

    @Override
    public void tworzenieMapy() {

        if (!box.isDestroy) {

            box.posX = nrKolumny * 0.1f;
            box.posY = nrWiersza * 0.1f;

            if (box.posY - 0.01f < 0.8) {
                box.posY = nrWiersza * 0.1f + positionY;
            }

            box.posX = box.posX + positionX;

            gl10.glPushMatrix();
            gl10.glMatrixMode(GL10.GL_MODELVIEW);
            gl10.glLoadIdentity();

            if (zakres > 0){
                zakres--;
            } if (zakres == 0){
                r = random.nextInt(4);
                Log.d(ZNACZNIK, " Rurch r : " +  r);
                zakres = 10;
            }

            if (r == 0) {
                move_up();
            } else if (r == 1) {
                move_down();
            } else if (r == 2) {
                move_left();
            } else if (r == 3){
                move_right();
            }

            if (zakres_bomby > 0){
                zakres_bomby--;
            } if (zakres_bomby == 0){
                strzal = true;
                zakres_bomby = 20;
            }


            //move_right();
           //move_left();
            //move_up();
            //move_down();

            gl10.glTranslatef(box.posX , box.posY  , 0);
            gl10.glMatrixMode(GL10.GL_TEXTURE);
            gl10.glLoadIdentity();
            box.rysujBox(gl10, tekstura1);
            gl10.glPopMatrix();
            gl10.glLoadIdentity();

            if (isShot()){
                pociski.wystrzel(gl10, box.posY, box.posX, isShot());
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
        return new Bomba(x, y, tekstura[0], tekstura[1]);
    }


    public boolean isShot() {
        return strzal;
    }


    public void setPociski(Pociski pociski) {
        this.pociski = pociski;
    }

}

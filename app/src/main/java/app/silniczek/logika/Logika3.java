package app.silniczek.logika;

import android.util.Log;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.BeczkaMapa;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-06-02.
 */
public class Logika3 <G extends BazaMapa, E extends EnemyMapa, P extends Postac,A extends Animacja> {

    private String ZNACZNIK = "LOGIKA3 : ";

    G mapa;
    E wrog;
    P postac;
    A animacja;

    public Logika3(G mapa, E wrog,P postac, A animacja) {
        this.mapa = mapa;
        this.wrog = wrog;
        this.postac = postac;
        this.animacja = animacja;

        kolizja();
    }

    private void kolizja(){
        if (!mapa.brick.isDestroy){

            /*
            if (((wrog.box.posX < mapa.brick.posX + 0.20)
                    && (mapa.brick.posX < wrog.box.posX + 0.20))
                    && ((wrog.box.posY < mapa.brick.posY + 0.20)
                    && (mapa.brick.posY < wrog.box.posY + 0.20))){
                    wrog.shot = true;
                    wrog.shot();
            }


            if (mapa instanceof BeczkaMapa) {
                if (((wrog.box.posX < mapa.brick.posX + 0.20)
                        && (mapa.brick.posX < wrog.box.posX + 0.20))
                        && ((wrog.box.posY < mapa.brick.posY + 0.20)
                        && (mapa.brick.posY < wrog.box.posY + 0.20))){
                    if (mapa.kill == true){
                        //wrog.shot(true);

                    }
                }
            }

            if (((wrog.box.posX < postac.posX + 0.3)
                    && (postac.posX < wrog.box.posX + 0.3))
                    && ((wrog.box.posY < postac.posY + 0.3)
                    && (postac.posY < wrog.box.posY + 0.3))) {
                if (postac.PLAYER_ACTION == postac.PLAYER_MOVE_LEFT) {
                    wrog.move_left();
                }
            }
            */
            if ((wrog.PLAYER_ACTION_X == wrog.PLAYER_MOVE_RIGHT)) {
                if (((mapa.brick.posX + 0.01 <= wrog.box.posX + 0.11)// zwiekszone odbicie od sciany z prawej strony
                        && (wrog.box.posX + 0.01 <= mapa.brick.posX + 0.09))
                        && ((mapa.brick.posY + 0.01 <= wrog.box.posY + 0.09)
                        && (wrog.box.posY <= mapa.brick.posY + 0.09))) {
                    Log.d(ZNACZNIK, "Zakres prawy");
                    wrog.positionX = wrog.positionX - wrog.speed_X;
                }
            }


            if ((wrog.PLAYER_ACTION_X == postac.PLAYER_MOVE_RIGHT) && (wrog.box.posY > 0.06)) {//postac.brick.posY wrog porusza sie sam
                if (((mapa.brick.posX + 0.01 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX + 0.01 <= mapa.brick.posX + 0.1))
                        && ((mapa.brick.posY + 0.01 <= wrog.box.posY + 0.09) //?
                        && (wrog.box.posY <= mapa.brick.posY + 0.09))) {

                    Log.d(ZNACZNIK, "Zakres prawy dolny");

                    if (!(((mapa.brick.posX + 0.01 <= wrog.box.posX + 0.11)// zwiekszone odbicie od sciany z prawej strony
                            && (wrog.box.posX + 0.01 <= mapa.brick.posX + 0.09))
                            && ((mapa.brick.posY + 0.01 <= wrog.box.posY + 0.09)
                            && (wrog.box.posY <= mapa.brick.posY + 0.09)))) {

                        //wrog.move_down();
                        //wrog.move_right();
                        //wrog.positionY = wrog.positionY - wrog.speed_Y;
                        //wrog.positionX = wrog.positionX + wrog.speed_X;
                    }


                }
            }

            if ((wrog.PLAYER_ACTION_Y == wrog.PLAYER_MOVE_DOWN)) {
                if (((mapa.brick.posX <= wrog.box.posX + 0.09) //0.1 <-- poprawione
                        && (wrog.box.posX <= mapa.brick.posX + 0.09))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.09)
                        && (wrog.box.posY <= mapa.brick.posY))) { //nie dodajac 0.1 mam odbicie od gornej sciany
                    Log.d(ZNACZNIK, "zakres dolny");
                    wrog.positionY = wrog.positionY - wrog.speed_Y;
                }
            }
            if (mapa instanceof BeczkaMapa) {
                if (wrog.PLAYER_ACTION_X == wrog.PLAYER_MOVE_RIGHT) {
                    if (((mapa.brick.posX + 0.01 <= wrog.box.posX + 0.11)// zwiekszone odbicie od sciany z prawej strony
                            && (wrog.box.posX + 0.01 <= mapa.brick.posX + 0.09))
                            && ((mapa.brick.posY + 0.01 <= wrog.box.posY + 0.09)
                            && (wrog.box.posY <= mapa.brick.posY + 0.09))) {
                        //Log.d(ZNACZNIK, "Zakres prawy");
                        wrog.positionY = wrog.positionY + wrog.speed_Y;
                    }
                }
            }

            if ((wrog.PLAYER_ACTION_Y == wrog.PLAYER_MOVE_DOWN) ) {
                if (((mapa.brick.posX + 0.01 < postac.box.posX + 0.09) //0.1
                        && (postac.box.posX < mapa.brick.posX + 0.09))
                        && ((mapa.brick.posY + 0.01 <= postac.box.posY + 0.11)
                        && (postac.box.posY + 0.01 <= mapa.brick.posY + 0.11))) { //nie dodajac 0.1 mam odbicie od gornej sciany
                    //Log.d(ZNACZNIK, "zakres dolny");
                    //postac.positionY = postac.positionY - postac.speed_Y;
                }
            }


        }
    }
}

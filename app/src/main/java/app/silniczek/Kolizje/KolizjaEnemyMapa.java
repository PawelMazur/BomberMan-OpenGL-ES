package app.silniczek.Kolizje;

import android.util.Log;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.mapa.GlownaMapa;

/**
 * Created by Pawel on 2015-03-16.
 */
public class KolizjaEnemyMapa <G extends BazaMapa, E extends EnemyMapa, A extends Animacja> {

    private String ZNACZNIK = "KolizjaEnemyMapa : ";
    G mapa;
    E postac;
    A animacja;

    public KolizjaEnemyMapa(G mapa, E postac, A animacja) {
        this.mapa = mapa;
        this.postac = postac;
        this.animacja = animacja;
        kolizja();
    }

    private void kolizja(){


        if (mapa instanceof GlownaMapa) {
            if (!postac.brick.isDestroy) {
                if (!mapa.brick.isDestroy) {


                    // --------------------- zakes lewy --------------
                    //chodzi dobrze nie poprawiac
                /*
                if (wrog.PLAYER_ACTION == wrog.PLAYER_MOVE_RIGHT){
                    if (((wrog.brick.posX <= mapa.brick.posX)
                    && (mapa.brick.posX <= wrog.brick.posX))
                    && ((wrog.brick.posY <= mapa.brick.posY)
                    && (mapa.brick.posY <= wrog.brick.posY))){

                    }
                }*/

                /*
                if (wrog instanceof GlownaMapa){
                    //Log.d(ZNACZNIK, "true");
                } else {
                    //Log.d(ZNACZNIK, "false");
                }*/


                    if (postac.PLAYER_ACTION_X == postac.PLAYER_MOVE_LEFT) {
                        if (((mapa.brick.posX - 0.1 <= postac.brick.posX) //-0.09
                                && (postac.brick.posX + 0.01 <= mapa.brick.posX + 0.11))
                                && ((mapa.brick.posY + 0.01 <= postac.brick.posY + 0.09)
                                && (postac.brick.posY <= mapa.brick.posY + 0.09))) {
                            //Log.d(ZNACZNIK, "przekroczyl granice ");
                            //Log.d(ZNACZNIK, "Zakres lewy");
                            //wrog.brick.posX =  wrog.brick.posX + wrog.positionX;
                            postac.positionX = postac.positionX + postac.speed_X;
                        }
                    }


                    if ((postac.PLAYER_ACTION_X == postac.PLAYER_MOVE_LEFT) && (postac.speed_Y > 0.05)) {
                        if (((mapa.brick.posX - 0.1 <= postac.brick.posX) // - 0.1 oznacz lewa przeszkode
                                && (postac.brick.posX + 0.01 <= mapa.brick.posX + 0.9)) //0.01 - oznacza ze wrog jest mniej szersza
                                && ((mapa.brick.posY + 0.01 < postac.brick.posY + 0.1) //0.01 odstep od gory
                                && (postac.brick.posY < mapa.brick.posY + 0.1))) {
                            //Log.d(ZNACZNIK, "Zakres lewy dolny");
                            //wrog.brick.posY = wrog.brick.posY - wrog.positionY;
                            postac.positionY = postac.positionY - postac.speed_Y;
                        }
                    }
                    //----------------
                    //---------------zakres prawy ----------------------
                    //chodzi dobrze nie poprawiac

                    if (postac.PLAYER_ACTION_X == postac.PLAYER_MOVE_RIGHT) {
                        if (((mapa.brick.posX + 0.01 <= postac.brick.posX + 0.11)// zwiekszone odbicie od sciany z prawej strony
                                && (postac.brick.posX + 0.01 <= mapa.brick.posX + 0.09))
                                && ((mapa.brick.posY + 0.01 <= postac.brick.posY + 0.09)
                                && (postac.brick.posY <= mapa.brick.posY + 0.09))) {
                            //Log.d(ZNACZNIK, "Zakres prawy");
                            postac.positionX = postac.positionX - postac.speed_X;
                        }
                    }


                    if ((postac.PLAYER_ACTION_X == postac.PLAYER_MOVE_RIGHT) && (postac.brick.posY > 0.05)) {//wrog.brick.posY wrog porusza sie sam
                        if (((mapa.brick.posX + 0.01 <= postac.brick.posX + 0.11)
                                && (postac.brick.posX + 0.01 <= mapa.brick.posX + 0.1))
                                && ((mapa.brick.posY + 0.01 <= postac.brick.posY + 0.09) //?
                                && (postac.brick.posY <= mapa.brick.posY + 0.09))) {

                            //Log.d(ZNACZNIK, "Zakres prawy dolny");
                            postac.positionY = postac.positionY - postac.speed_Y;
                        }
                    }

                    //-------------zakres skoku ----------------------
                    //chodzi dobrze nie poprawiac

                    if ((postac.PLAYER_ACTION_Y == postac.PLAYER_MOVE_UP)) {
                        if (((mapa.brick.posX <= postac.brick.posX + 0.1) //0.1
                            && (postac.brick.posX <= mapa.brick.posX + 0.1))
                            && ((mapa.brick.posY - 0.1 <= postac.brick.posY )
                            && (postac.brick.posY - 0.1 <= mapa.brick.posY))) {

                            postac.positionY = postac.positionY + postac.speed_Y;
                            Log.d(ZNACZNIK, "jest kolizja");

                        }
                    }

                    //mozna poprawic
                    if ((postac.PLAYER_ACTION_Y == postac.PLAYER_MOVE_DOWN)) {
                        if (((mapa.brick.posX <= postac.brick.posX + 0.09) //0.1 <-- poprawione
                                && (postac.brick.posX <= mapa.brick.posX + 0.09))
                                && ((mapa.brick.posY <= postac.brick.posY + 0.09)
                                && (postac.brick.posY <= mapa.brick.posY))) { //nie dodajac 0.1 mam odbicie od gornej sciany
                            //Log.d(ZNACZNIK, "zakres dolny");
                            postac.positionY = postac.positionY - postac.speed_Y;
                        }
                    }
                    //wszystko chodzi dobrz nie poprawiac


                }
            }
        }
    }
}

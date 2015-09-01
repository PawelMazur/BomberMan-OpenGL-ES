package app.silniczek.logika;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-06-05.
 */
public class Logika4 <G extends BazaMapa, E extends EnemyMapa, P extends Postac,A extends Animacja> {

    private String ZNACZNIK = "LOGIKA4 : ";

    G mapa;
    E wrog;
    P postac;
    A animacja;


    static boolean zakres_prawy = false;
    static boolean zakres_lewy = false;
    static boolean zakres_dolny = false;
    static boolean zakres_gorny = false;

    /*
    private static String zakres_prawy = "false";
    private static String zakres_lewy = "false";
    private static String zakres_dolny = "false";
    private static String zakres_gorny = "false";
    */

    List<Boolean> lista_zdarzen = new ArrayList<>();
    int czas_blokady = 3;

    public Logika4(G mapa, E wrog,P postac, A animacja) {
        this.mapa = mapa;
        this.wrog = wrog;
        this.postac = postac;
        this.animacja = animacja;

        kolizja();


    }

    private void kolizja() {


        if (!wrog.box.isDestroy) {
            if (!mapa.brick.isDestroy) {


                // --------------------- zakes prawy --------------
                //if (wrog.PLAYER_ACTION_X == wrog.PLAYER_MOVE_RIGHT) {
                    if (((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)// zwiekszone odbicie od sciany z prawej strony
                            && (wrog.box.posX <= mapa.brick.posX ))
                            && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                            && (wrog.box.posY <= mapa.brick.posY + 0.02))) {
                        zakres_prawy = true;

                        //zakres_prawy = "true";
                        Log.d(ZNACZNIK, "Zakres prawy");



                    }
                //}

                // --------------------- zakes lewy --------------
                //if (wrog.PLAYER_ACTION_X == wrog.PLAYER_MOVE_LEFT) {
                    if (((mapa.brick.posX  <= wrog.box.posX)
                            && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                            && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                            && (wrog.box.posY <= mapa.brick.posY + 0.02))) {
                        //Log.d(ZNACZNIK, "Zakres lewy");
                        zakres_lewy = true;

                        //zakres_lewy = "true";

                    }
                //}

                // --------------------- zakes gorny --------------
                //if ((wrog.PLAYER_ACTION_Y == wrog.PLAYER_MOVE_UP)) {
                    if (((mapa.brick.posX  <= wrog.box.posX + 0.08 )
                            && (wrog.box.posX <= mapa.brick.posX + 0.02 ))
                            && ((mapa.brick.posY <= wrog.box.posY ) //0.1 nie skacze (0.09) skacze
                            && (wrog.box.posY - 0.08 <= mapa.brick.posY + 0.11))) {
                        //Log.d(ZNACZNIK, "zakres gorny");
                        zakres_gorny = true;
                        //zakres_gorny = "true";


                    }
                //}

                //---------------zakres dolny -----------------------------
                //if ((wrog.PLAYER_ACTION_Y == wrog.PLAYER_MOVE_DOWN) ) {

                    if (((mapa.brick.posX <= wrog.box.posX + 0.08) //0.1
                            && (wrog.box.posX <= mapa.brick.posX + 0.02))
                            && ((mapa.brick.posY - 0.08 <= wrog.box.posY + 0.11 )
                            && (wrog.box.posY <= mapa.brick.posY ))) { //nie dodajac 0.1 mam odbicie od gornej sciany
                        //Log.d(ZNACZNIK, "zakres dolny");
                        zakres_dolny = true;
                        //zakres_dolny = "true";


                    }
                //--------------------zakres lewy - gorny
                if (((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12))) {
                    zakres_lewy = true;
                    //mapa.brick.isDestroy = true;
                    //zakres_lewy = "true";

                }
                //--------------------zakres prawy - gorny ---------
                if (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12))) {
                    zakres_lewy = true;
                    //mapa.brick.isDestroy = true;

                }

                //--------------------zakres lewy - dolny ---------
                if (((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02))) {
                    zakres_lewy = true;
                    //mapa.brick.isDestroy = true;

                }

                //-------------------zakres prawy - dolny ----------------
                if (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02))) {
                    zakres_lewy = true;
                    //mapa.brick.isDestroy = true;

                }




                //}
                /*
                if (zakres_gorny == true){
                    Log.d(ZNACZNIK, "zakres gorny");
                    wrog.PLAYER_ACTION_Y = wrog.PLAYER_MOVE_DOWN;
                    wrog.move_down();
                }
                */

                /*
                Log.d(ZNACZNIK, "Zakresy : " + " P : " + zakres_prawy
                                             + " L : " + zakres_lewy
                                             + " D : " + zakres_dolny
                                             + " G : " + zakres_gorny);
                    */
                /*
                if (zakres_gorny == true){
                    wrog.move_down();
                }else if (zakres_lewy == true){
                    wrog.move_right();
                }*/
                /*
                if ( zakres_gorny == true || zakres_prawy == true || zakres_lewy == true){
                    wrog.move_down();
                }




                /*
                if (zakres_prawy == true && zakres_gorny == true
                && zakres_lewy == true && zakres_dolny == false){
                    wrog.move_up();
                }*/

                /*
                if (zakres_prawy == true && zakres_gorny == true
                && zakres_lewy == false && zakres_dolny == true){
                    wrog.move_up();
                }*/

                /*
                if (zakres_prawy == true){
                    wrog.move_left();
                }

                if (zakres_lewy == true ){
                    wrog.move_right();
                }

                if (zakres_dolny == true){
                    wrog.move_up();
                }

                if (zakres_gorny == true){
                    wrog.move_down();
                }*/


                zakres_lewy = false;
                zakres_prawy = false;
                zakres_gorny = false;
                zakres_dolny = false;

            }
        }


    }


}

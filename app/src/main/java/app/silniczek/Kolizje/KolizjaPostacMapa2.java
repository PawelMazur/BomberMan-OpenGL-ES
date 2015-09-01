package app.silniczek.Kolizje;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-05-30.
 */
public class KolizjaPostacMapa2 <G extends BazaMapa, P extends Postac, A extends Animacja> {

    G mapa;
    P postac;
    A animcja;

    private String ZNACZNIK = "KolizjaPostacMapa";

    public KolizjaPostacMapa2(G mapa, P postac, A animcja) {
        this.mapa = mapa;
        this.postac = postac;
        this.animcja = animcja;
        kolizja();
    }

    private void kolizja() {


        if (!postac.isDestroy) {
            if (!mapa.brick.isDestroy) {
                // --------------------- zakes lewy --------------
                //chodzi dobrze nie poprawiac
                if (postac.PLAYER_ACTION == postac.PLAYER_MOVE_LEFT) {
                    if (((mapa.brick.posX  <= postac.posX) //-0.09
                            && (postac.posX + 0.01 <= mapa.brick.posX + 0.11))
                            && ((mapa.brick.posY + 0.01 <= postac.posY + 0.09)
                            && (postac.posY <= mapa.brick.posY + 0.09))) {
                        //Log.d(ZNACZNIK, "Zakres lewy");
                        postac.BANK_POSITION_PLAYER_X = postac.BANK_POSITION_PLAYER_X + postac.PLAYER_SPEED;

                    }
                }

                /*
                if ((wrog.PLAYER_ACTION == wrog.PLAYER_MOVE_LEFT) && (wrog.BANK_POSITION_PLAYER_Y > 0.05)) {
                    if (((mapa.brick.posX - 0.1 <= wrog.posX) // - 0.1 oznacz lewa przeszkode
                            && (wrog.posX + 0.01 <= mapa.brick.posX + 0.1)) //0.01 - oznacza ze wrog jest mniej szersza
                            && ((mapa.brick.posY + 0.01 < wrog.posY + 0.1) //0.01 odstep od gory
                            && (wrog.posY < mapa.brick.posY + 0.1))) {
                        //Log.d(ZNACZNIK, "Zakres lewy dolny");
                        wrog.BANK_POSITION_PLAYER_Y = wrog.BANK_POSITION_PLAYER_Y - wrog.PLAYER_SPEED_Y;

                    }
                }
                */
                //----------------
                //---------------zakres prawy ----------------------
                //chodzi dobrze nie poprawiac
                if (postac.PLAYER_ACTION == postac.PLAYER_MOVE_RIGHT) {
                    if (((mapa.brick.posX + 0.01 <= postac.posX + 0.11)// zwiekszone odbicie od sciany z prawej strony
                            && (postac.posX + 0.01 <= mapa.brick.posX + 0.09))
                            && ((mapa.brick.posY + 0.01 <= postac.posY + 0.09)
                            && (postac.posY <= mapa.brick.posY + 0.09))) {
                        //Log.d(ZNACZNIK, "Zakres prawy");
                        postac.BANK_POSITION_PLAYER_X = postac.BANK_POSITION_PLAYER_X - postac.PLAYER_SPEED;
                    }
                }

                /*
                if ((wrog.PLAYER_ACTION == wrog.PLAYER_MOVE_RIGHT) && (wrog.BANK_POSITION_PLAYER_Y > 0.05)) {
                    if (((mapa.brick.posX + 0.01 <= wrog.posX + 0.11)
                            && (wrog.posX + 0.01 <= mapa.brick.posX + 0.1))
                            && ((mapa.brick.posY + 0.01 <= wrog.posY + 0.1)
                            && (wrog.posY <= mapa.brick.posY + 0.1))) {

                        //Log.d(ZNACZNIK, "Zakres prawy dolny");
                        wrog.BANK_POSITION_PLAYER_Y = wrog.BANK_POSITION_PLAYER_Y - wrog.PLAYER_SPEED_Y;
                    }
                }
                */
                //-------------zakres gorny ----------------------
                //chodzi dobrze nie poprawiac
                if ((postac.PLAYER_ACTION == postac.PLAYER_MOVE_UP)) {
                    if (((mapa.brick.posX + 0.01 <= postac.posX + 0.09 )
                            && (postac.posX <= mapa.brick.posX + 0.09 ))
                            && ((mapa.brick.posY - 0.01 <= postac.posY ) //0.1 nie skacze (0.09) skacze
                            && (postac.posY + 0.01 <= mapa.brick.posY + 0.11))) {
                        //Log.d(ZNACZNIK, "zakres gorny");

                        postac.BANK_POSITION_PLAYER_Y = postac.BANK_POSITION_PLAYER_Y + postac.PLAYER_SPEED_Y;

                    }
                }
                //---------------zakres dolny -----------------------------

                //mozna poprawic
                if ((postac.PLAYER_ACTION == postac.PLAYER_MOVE_DOWN) ) {
                    if (((mapa.brick.posX + 0.01 < postac.posX + 0.09) //0.1
                            && (postac.posX < mapa.brick.posX + 0.09))
                            && ((mapa.brick.posY + 0.01 <= postac.posY + 0.11)
                            && (postac.posY + 0.01 <= mapa.brick.posY + 0.09))) { //nie dodajac 0.1 mam odbicie od gornej sciany
                        //Log.d(ZNACZNIK, "zakres dolny");
                        postac.BANK_POSITION_PLAYER_Y = postac.BANK_POSITION_PLAYER_Y - postac.PLAYER_SPEED_Y;
                    }
                }

            }
        }
    }
}

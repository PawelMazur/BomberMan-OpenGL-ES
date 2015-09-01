package app.silniczek.Kolizje;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.EnemyMapa;

/**
 * Created by Pawel on 2015-06-02.
 */
public class KolizjaEnemyMapa2<G extends BazaMapa, E extends EnemyMapa, A extends Animacja> {

    G mapa;
    E wrog;
    A animcja;

    private String ZNACZNIK = "KolizjaEnemyMapa";

    public KolizjaEnemyMapa2(G mapa, E wrog, A animcja) {
        this.mapa = mapa;
        this.wrog = wrog;
        this.animcja = animcja;
        kolizja();
    }

    private void kolizja() {


        if (!wrog.box.isDestroy) {
            if (!mapa.brick.isDestroy) {
                // --------------------- zakes lewy --------------
                //chodzi dobrze nie poprawiac
                //if (wrog.PLAYER_ACTION_X == wrog.PLAYER_MOVE_LEFT) {
                if (wrog.PLAYER_ACTION == wrog.PLAYER_MOVE_LEFT) {
                    if (((mapa.brick.posX  <= wrog.box.posX) //-0.09
                            && (wrog.box.posX + 0.01 <= mapa.brick.posX + 0.11))
                            && ((mapa.brick.posY + 0.01 <= wrog.box.posY + 0.09)
                            && (wrog.box.posY <= mapa.brick.posY + 0.09))) {
                        //Log.d(ZNACZNIK, "Zakres lewy");
                        wrog.positionX = wrog.positionX + wrog.speed_X;

                    }
                }

                //----------------
                //---------------zakres prawy ----------------------
                //chodzi dobrze nie poprawiac
                //if (wrog.PLAYER_ACTION_X == wrog.PLAYER_MOVE_RIGHT) {
                if (wrog.PLAYER_ACTION == wrog.PLAYER_MOVE_RIGHT) {
                    if (((mapa.brick.posX + 0.01 <= wrog.box.posX + 0.11)// zwiekszone odbicie od sciany z prawej strony
                            && (wrog.box.posX + 0.01 <= mapa.brick.posX + 0.09))
                            && ((mapa.brick.posY + 0.01 <= wrog.box.posY + 0.09)
                            && (wrog.box.posY <= mapa.brick.posY + 0.09))) {
                        //Log.d(ZNACZNIK, "Zakres prawy");
                        wrog.positionX = wrog.positionX - wrog.speed_X;
                    }
                }



                //-------------zakres gorny ----------------------
                //chodzi dobrze nie poprawiac
                //if ((wrog.PLAYER_ACTION_Y == wrog.PLAYER_MOVE_UP)) {
                if ((wrog.PLAYER_ACTION == wrog.PLAYER_MOVE_UP)) {
                    if (((mapa.brick.posX + 0.01 <= wrog.box.posX + 0.09 )
                            && (wrog.box.posX <= mapa.brick.posX + 0.09 ))
                            && ((mapa.brick.posY - 0.01 <= wrog.box.posY ) //0.1 nie skacze (0.09) skacze
                            && (wrog.box.posY <= mapa.brick.posY + 0.11))) {
                        //Log.d(ZNACZNIK, "zakres gorny");

                        wrog.positionY = wrog.positionY + wrog.speed_Y;

                    }
                }
                //---------------zakres dolny -----------------------------

                //mozna poprawic
                //if ((wrog.PLAYER_ACTION_Y == wrog.PLAYER_MOVE_DOWN) ) {
                if ((wrog.PLAYER_ACTION == wrog.PLAYER_MOVE_DOWN) ) {
                    if (((mapa.brick.posX + 0.01 < wrog.box.posX + 0.09) //0.1
                            && (wrog.box.posX < mapa.brick.posX + 0.09))
                            && ((mapa.brick.posY + 0.01 <= wrog.box.posY + 0.11)
                            && (wrog.box.posY + 0.01 <= mapa.brick.posY + 0.11))) { //nie dodajac 0.1 mam odbicie od gornej sciany
                        //Log.d(ZNACZNIK, "zakres dolny");
                        wrog.positionY = wrog.positionY - wrog.speed_Y;
                    }
                }

            }
        }
    }
}

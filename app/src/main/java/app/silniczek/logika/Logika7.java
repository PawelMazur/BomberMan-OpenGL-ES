package app.silniczek.logika;

import java.util.Random;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-06-08.
 */
public class Logika7<G extends BazaMapa, E extends EnemyMapa, P extends Postac,A extends Animacja> {




    private String ZNACZNIK = "LOGIKA5 : ";
    private boolean blokuj = false;
    Random random = new Random();
    G mapa;
    E wrog;
    P postac;
    A animacja;


    public Logika7(G mapa, E wrog,P postac, A animacja) {
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
               if (((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02))) {
                    wrog.move_left();
                }

                //---------------------------zakes lewy ---------------
                else if (((mapa.brick.posX  <= wrog.box.posX)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))/*0.02*/{
                    //Log.d(ZNACZNIK, "Zakres lewy");
                    wrog.move_right();
                }

                // --------------------- zakes gorny --------------
                else if (((mapa.brick.posX  <= wrog.box.posX + 0.08 )
                        && (wrog.box.posX <= mapa.brick.posX + 0.02 ))
                        && ((mapa.brick.posY <= wrog.box.posY )
                        && (wrog.box.posY - 0.08 <= mapa.brick.posY + 0.11))) {
                    //Log.d(ZNACZNIK, "zakres gorny");
                    wrog.move_down();
                }


                //---------------zakres dolny -----------------------------
                else if (((mapa.brick.posX <= wrog.box.posX + 0.08)
                        && (wrog.box.posX <= mapa.brick.posX + 0.02))
                        && ((mapa.brick.posY - 0.08 <= wrog.box.posY + 0.11 )
                        && (wrog.box.posY <= mapa.brick.posY ))) {
                    wrog.move_up();
                }




                //--------------------zakres lewy - gorny
                if (((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12))) {
                }
                //--------------------zakres prawy - gorny ---------
                if (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12))) {
                }

                //--------------------zakres lewy - dolny ---------
                if (((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02))) {
                }

                //-------------------zakres prawy - dolny ----------------
                if (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02))) {
                }





            }
        }


    }

}

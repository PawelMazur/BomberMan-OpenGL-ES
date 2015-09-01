package app.silniczek.logika;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-06-06.
 */
public class Logika5<G extends BazaMapa, E extends EnemyMapa, P extends Postac,A extends Animacja> {




    private String ZNACZNIK = "LOGIKA5 : ";
    private boolean blokuj = false;
    G mapa;
    E wrog;
    P postac;
    A animacja;


    public Logika5(G mapa, E wrog,P postac, A animacja) {
        this.mapa = mapa;
        this.wrog = wrog;
        this.postac = postac;
        this.animacja = animacja;

        kolizja();


    }

    private void kolizja() {


        if (!wrog.box.isDestroy) {
            if (!mapa.brick.isDestroy) {
            //-zakresu : (lewy - gorny) (prawy - gorny) (lewy - dolny)(prawy -dolny)(lewy)-

                if ((((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12)))
                        || (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12)))
                        || (((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02)))
                        || (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02)))
                        || (((mapa.brick.posX  <= wrog.box.posX)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))){
                    //mapa.brick.isDestroy = true;
                    wrog.move_right();
                    //wrog.positionX = wrog.positionX + wrog.speed_X;


                }

                //-zakresu : (lewy - gorny) (prawy - gorny) (lewy - dolny)(prawy -dolny)(prawy)-
                else if ((((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12)))
                        || (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12)))
                        || (((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02)))
                        || (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02)))
                        || (((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))){
                    wrog.move_left();
                    //mapa.brick.isDestroy = true;
                    //wrog.positionX = wrog.positionX + wrog.speed_X;


                }


                //---------brak zakres : prawy - lewy - gorny ------------
                else if ((((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))
                        || (((mapa.brick.posX  <= wrog.box.posX)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))
                        || (((mapa.brick.posX  <= wrog.box.posX + 0.08 )
                        && (wrog.box.posX <= mapa.brick.posX + 0.02 ))
                        && ((mapa.brick.posY <= wrog.box.posY )
                        && (wrog.box.posY - 0.08 <= mapa.brick.posY + 0.11)))){
                    wrog.move_down();
                    //wrog.positionX = wrog.positionX + wrog.speed_X;
                }

                    // -------zakres : gorny - dolny ----------
                else if ((((mapa.brick.posX  <= wrog.box.posX + 0.08 )
                        && (wrog.box.posX <= mapa.brick.posX + 0.08 ))//---porawione
                        && ((mapa.brick.posY <= wrog.box.posY )
                        && (wrog.box.posY - 0.08 <= mapa.brick.posY + 0.11)))
                        || (((mapa.brick.posX <= wrog.box.posX + 0.08)
                        && (wrog.box.posX <= mapa.brick.posX + 0.08)) //-- porawione
                        && ((mapa.brick.posY - 0.08 <= wrog.box.posY + 0.11 )
                        && (wrog.box.posY <= mapa.brick.posY )))){
                    wrog.move_left();
                }



                //---------zakres : prawy - lewy - gorny ------------
                /*
                if ((((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))
                        || (((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))
                        || (((mapa.brick.posX  <= wrog.box.posX + 0.08 )
                        && (wrog.box.posX <= mapa.brick.posX + 0.02 ))
                        && ((mapa.brick.posY <= wrog.box.posY )
                        && (wrog.box.posY - 0.08 <= mapa.brick.posY + 0.11)))){
                    wrog.move_down();
                    //mapa.brick.isDestroy = true;
                }*/
                /*
                //---------zakres : prawy - lewy - dolny ------------
                else if ((((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.08)))
                        || (((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.08)))
                        || (((mapa.brick.posX <= wrog.box.posX + 0.08)
                        && (wrog.box.posX <= mapa.brick.posX + 0.08))
                        && ((mapa.brick.posY - 0.08 <= wrog.box.posY + 0.11 )
                        && (wrog.box.posY <= mapa.brick.posY )))){
                    wrog.move_up();


                }else
                    // --------------------- zakes lewy --------------
                if (((mapa.brick.posX  <= wrog.box.posX)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.08))){
                    wrog.move_right();
                } else

                //---------zakres : gorny - dolny ------------
                if ((((mapa.brick.posX  <= wrog.box.posX + 0.08 )
                        && (wrog.box.posX <= mapa.brick.posX + 0.08 ))
                        && ((mapa.brick.posY <= wrog.box.posY )
                        && (wrog.box.posY - 0.08 <= mapa.brick.posY + 0.11)))
                        || (((mapa.brick.posX <= wrog.box.posX + 0.08)
                        && (wrog.box.posX <= mapa.brick.posX + 0.08))
                        && ((mapa.brick.posY - 0.08 <= wrog.box.posY + 0.11 )
                        && (wrog.box.posY <= mapa.brick.posY )))){
                    wrog.move_right();
                } */

                //----zakres (prawy - gorny) - (prawy) - ( prawy - dolny)
                if ((((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12)))
                        || (((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))
                        || (((mapa.brick.posX - 0.08  <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX - 0.02))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02)))){
                    wrog.move_left();
                }

                //--zakres (lewy - gorny) - (lewy) - (lewy - dolny) (
                else if ((((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY - 0.02)
                        && (wrog.box.posY <= mapa.brick.posY + 0.12)))
                        || (((mapa.brick.posX  <= wrog.box.posX)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))
                        || (((mapa.brick.posX  <= wrog.box.posX - 0.02)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.12)
                        && (wrog.box.posY <= mapa.brick.posY - 0.02)))){

                    wrog.move_right();
                }





                // --------------------- zakes prawy --------------
                if (((mapa.brick.posX - 0.08 <= wrog.box.posX + 0.11)
                        && (wrog.box.posX <= mapa.brick.posX ))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02))) {
                }
                // --------------------- zakes lewy --------------
                if (((mapa.brick.posX  <= wrog.box.posX)
                        && (wrog.box.posX - 0.08 <= mapa.brick.posX + 0.11))
                        && ((mapa.brick.posY <= wrog.box.posY + 0.08)
                        && (wrog.box.posY <= mapa.brick.posY + 0.02)))/*0.02*/{
                    //Log.d(ZNACZNIK, "Zakres lewy");
                }

                // --------------------- zakes gorny --------------
                if (((mapa.brick.posX  <= wrog.box.posX + 0.08 )
                        && (wrog.box.posX <= mapa.brick.posX + 0.02 ))
                        && ((mapa.brick.posY <= wrog.box.posY )
                        && (wrog.box.posY - 0.08 <= mapa.brick.posY + 0.11))) {
                    //Log.d(ZNACZNIK, "zakres gorny");
                }


                //---------------zakres dolny -----------------------------
                if (((mapa.brick.posX <= wrog.box.posX + 0.08)
                        && (wrog.box.posX <= mapa.brick.posX + 0.02))
                        && ((mapa.brick.posY - 0.08 <= wrog.box.posY + 0.11 )
                        && (wrog.box.posY <= mapa.brick.posY ))) {
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

package app.silniczek.Kolizje;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.TloMapy;
import app.silniczek.pociski.Pociski;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-06-07.
 */
public class KolizjaBombaMapa2<G extends BazaMapa, P extends Pociski, A extends Animacja, Pl extends Postac> {

    private String ZNACZNIK = "KolizjaBombaMapa 2 : ";
    private int czas = 10;
    G mapa;
    P pociski;
    A animacja;
    Pl postac;

    public KolizjaBombaMapa2(G m, P p, A a, Pl pl) {
        mapa = m;
        pociski = p;
        animacja = a;
        postac = pl;

        kolizja();
    }

    public void kolizja() {

        if (!mapa.brick.isDestroy) {
            /*
            //--------------------- zakres prawy
            if (((mapa.brick.posX - 0.08 <= pociski.posX + 0.11)
                    && (pociski.posX <= mapa.brick.posX ))
                    && ((mapa.brick.posY <= pociski.posY + 0.08)
                    && (pociski.posY <= mapa.brick.posY + 0.02))) {
                mapa.brick.typCegly--;
                if (mapa.brick.typCegly == 0) {
                    mapa.brick.isDestroy = true;
                }
            }
            // --------------------- zakes lewy --------------
            if (((mapa.brick.posX  <= pociski.posX)
                    && (pociski.posX - 0.08 <= mapa.brick.posX + 0.11))
                    && ((mapa.brick.posY <= pociski.posY + 0.08)
                    && (pociski.posY <= mapa.brick.posY + 0.02))){
                mapa.brick.typCegly--;
                if (mapa.brick.typCegly == 0) {
                    mapa.brick.isDestroy = true;

                }
            }

            // --------------------- zakes gorny --------------
            if (((mapa.brick.posX  <= pociski.posX + 0.08 )
                    && (pociski.posX <= mapa.brick.posX + 0.02 ))
                    && ((mapa.brick.posY <= pociski.posY )
                    && (pociski.posY - 0.08 <= mapa.brick.posY + 0.11))) {
                mapa.brick.typCegly--;
                if (mapa.brick.typCegly == 0) {
                    mapa.brick.isDestroy = true;
                }
            }


            //---------------zakres dolny -----------------------------
            if (((mapa.brick.posX <= pociski.posX + 0.08)
                    && (pociski.posX <= mapa.brick.posX + 0.02))
                    && ((mapa.brick.posY - 0.08 <= pociski.posY + 0.11 )
                    && (pociski.posY <= mapa.brick.posY ))) {
                mapa.brick.typCegly--;
                if (mapa.brick.typCegly == 0) {
                    mapa.brick.isDestroy = true;
                }
            }*/
            pociski.isDestroy = false;
            if (!pociski.isDestroy) {
                if (pociski.wybuch == true) {
                    //Log.d(ZNACZNIK, "Wybuch : "+ pociski.wybuch);
                    //--------------------- zakres prawy
                    if (!(mapa instanceof TloMapy)) {
                        if (((mapa.brick.posX - 0.08 <= pociski.posX + 0.11)
                                && (pociski.posX <= mapa.brick.posX))
                                && ((mapa.brick.posY <= pociski.posY + 0.08)
                                && (pociski.posY <= mapa.brick.posY + 0.02))) {
                            mapa.brick.typCegly--;
                            if (mapa.brick.typCegly == 0) {
                                mapa.brick.isDestroy = true;
                            }


                        }
                        // --------------------- zakes lewy --------------
                        if (((mapa.brick.posX <= pociski.posX)
                                && (pociski.posX - 0.08 <= mapa.brick.posX + 0.11))
                                && ((mapa.brick.posY <= pociski.posY + 0.08)
                                && (pociski.posY <= mapa.brick.posY + 0.02))) {
                            mapa.brick.typCegly--;
                            if (mapa.brick.typCegly == 0) {
                                mapa.brick.isDestroy = true;

                            }

                        }

                        // --------------------- zakes gorny --------------
                        if (((mapa.brick.posX <= pociski.posX + 0.08)
                                && (pociski.posX <= mapa.brick.posX + 0.02))
                                && ((mapa.brick.posY <= pociski.posY)
                                && (pociski.posY - 0.08 <= mapa.brick.posY + 0.11))) {
                            mapa.brick.typCegly--;
                            if (mapa.brick.typCegly == 0) {
                                mapa.brick.isDestroy = true;
                            }

                        }


                        //---------------zakres dolny -----------------------------
                        if (((mapa.brick.posX <= pociski.posX + 0.08)
                                && (pociski.posX <= mapa.brick.posX + 0.02))
                                && ((mapa.brick.posY - 0.08 <= pociski.posY + 0.11)
                                && (pociski.posY <= mapa.brick.posY))) {
                            mapa.brick.typCegly--;

                            if (mapa.brick.typCegly == 0) {
                                mapa.brick.isDestroy = true;
                            }


                        }

                        /////////////---zakres dolny-------------------

                        if (((postac.posX - 0.08 <= pociski.posX + 0.11)
                                && (pociski.posX <= postac.posX))
                                && ((postac.posY <= pociski.posY + 0.08)
                                && (pociski.posY <= postac.posY + 0.02))) {
                            postac.isDestroy = true;

                        }
                        // --------------------- zakes lewy --------------
                        if (((postac.posX <= pociski.posX)
                                && (pociski.posX - 0.08 <= postac.posX + 0.11))
                                && ((postac.posY <= pociski.posY + 0.08)
                                && (pociski.posY <= postac.posY + 0.02))) {
                            postac.isDestroy = true;

                        }

                        // --------------------- zakes gorny --------------
                        if (((postac.posX <= pociski.posX + 0.08)
                                && (pociski.posX <= postac.posX + 0.02))
                                && ((postac.posY <= pociski.posY)
                                && (pociski.posY - 0.08 <= postac.posY + 0.11))) {
                            postac.isDestroy = true;

                        }


                        //---------------zakres dolny -----------------------------
                        if (((postac.posX <= pociski.posX + 0.08)
                                && (pociski.posX <= postac.posX + 0.02))
                                && ((postac.posY - 0.08 <= pociski.posY + 0.11)
                                && (pociski.posY <= postac.posY))) {
                            postac.isDestroy = true;
                        }


                        //if (pociski instanceof Bomba) {



                            postac.shot_3 = false;
                            pociski.jesliZostalWystrzelony = false;
                            pociski.isDestroy = true;
                        //}


                    }



                }
            }
        }

    }
}


package app.silniczek.Kolizje;

import android.util.Log;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.TloMapy;
import app.silniczek.pociski.Granatnik;
import app.silniczek.pociski.Miotacz;
import app.silniczek.pociski.Pociski;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-05-09.
 */
public class KolizjaPociskMapaZAnimacja2<G extends BazaMapa, P extends Pociski, A extends Animacja, Pl extends Postac> {

    private String ZNACZNIK = "KolizjaPociskMapaZAnimacja : ";
    G mapa;
    P pociski;
    A animacja;
    Pl player;

    public KolizjaPociskMapaZAnimacja2(G m, P p, A a, Pl pl) {
        mapa = m;
        pociski = p;
        animacja = a;
        player = pl;

        kolizja();
    }

    public void kolizja(){

        if (!mapa.brick.isDestroy){

            if (((pociski.posY < mapa.brick.posY + 0.1)
                    && (mapa.brick.posY < pociski.posY + 0.03 ))
                    && ((pociski.posX < mapa.brick.posX  + 0.1f)
                    && (mapa.brick.posX  < pociski.posX + 0.03f ))){

                //Log.d(ZNACZNIK , "Pocisk  posX " + pociski.posX + " : posY " + pociski.posY );

            /*if (((pociski.posX < mapa.brick.posX + 0.1 )
            && (mapa.brick.posX < pociski.posX + 0.05))
            && ((pociski.posY < mapa.brick.posY + 0.1)
            && (mapa.brick.posY < pociski.posY + 0.05))){*/

                //Log.d(ZNACZNIK , "Pocisk  posX " + pociski.posX + " : posY " + pociski.posY );
                if (!pociski.isDestroy){
                    //wykrycieKolizjiPomiedzyElementami(0);


                    if (pociski instanceof Miotacz){
                        animacja.animacjaWybuchu(pociski.posX - 0.05f, pociski.posY);
                    } if (pociski instanceof Granatnik) {
                        animacja.animacjaWybuchu(pociski.posX , pociski.posY);
                        pociski.ileRazyPodniesc = 20;
                    } else {
                        animacja.animacjaWybuchu(pociski.posX, pociski.posY);
                    }

                    //pociski.jesliZostalWystrzelony = false;
                    //pociski.ileRazyPodniesc = 20;
                    player.shot_1 = false;
                    player.shot_2 = false;
                    player.shot_3 = false;
                    pociski.jesliZostalWystrzelony = false;

                    if (!(mapa instanceof TloMapy)) {
                        mapa.brick.typCegly--;
                    }

                    if (mapa.brick.typCegly == 0){
                        mapa.brick.isDestroy = true;

                    }
                    pociski.isDestroy = true;
                }

            }
        }
    }


    public void wykrycieKolizjiPomiedzyElementami(float rozmiarWybuchu){

        if ((( pociski.posX < mapa.brick.posX - rozmiarWybuchu)
                && (mapa.brick.posX - rozmiarWybuchu < pociski.posX + 0.1f))
                && ((pociski.posY < mapa.brick.posY + 0.1f)
                && (mapa.brick.posY < pociski.posY ))){

            Log.d(ZNACZNIK, "Znajduje sie w przedziale");
            mapa.brick.isDestroy = true;
            pociski.isDestroy = true;

        }

    }
}

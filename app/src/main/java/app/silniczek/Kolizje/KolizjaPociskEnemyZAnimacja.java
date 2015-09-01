package app.silniczek.Kolizje;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.pociski.Pociski;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-06-08.
 */
public class KolizjaPociskEnemyZAnimacja<G extends BazaMapa, P extends Pociski, A extends Animacja, Pl extends Postac, E extends EnemyMapa> {

    private String ZNACZNIK = "KolizjaPociskMapaZAnimacja : ";
    G mapa;
    P pociski;
    A animacja;
    Pl player;
    E wrog;

    public KolizjaPociskEnemyZAnimacja(G m, P p, A a, Pl pl, E w) {
        mapa = m;
        pociski = p;
        animacja = a;
        player = pl;
        wrog = w;

        kolizja();
    }

    public void kolizja(){

        if (!mapa.brick.isDestroy){

            if (((pociski.posY < wrog.box.posY + 0.1)
                    && (wrog.box.posY < pociski.posY + 0.03 ))
                    && ((pociski.posX < wrog.box.posX  + 0.1f)
                    && (wrog.box.posX  < pociski.posX + 0.03f ))){

                if (!pociski.isDestroy) {
                    wrog.box.isDestroy = true;
                    pociski.isDestroy = true;
                }

            }
        }
    }
}

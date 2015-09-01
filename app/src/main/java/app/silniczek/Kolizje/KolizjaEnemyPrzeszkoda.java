package app.silniczek.Kolizje;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.BeczkaMapa;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.mapa.KamienieMapa;
import app.silniczek.mapa.KolceMapa;

/**
 * Created by Pawel on 2015-04-03.
 */
public class KolizjaEnemyPrzeszkoda <G extends BazaMapa, E extends EnemyMapa, A extends Animacja> {

    G mapa;
    E postac;
    A animacja;

    public KolizjaEnemyPrzeszkoda(G mapa, E postac, A animacja) {
        this.mapa = mapa;
        this.postac = postac;
        this.animacja = animacja;
        kolizja();
    }

    public void kolizja(){

        if (!mapa.brick.isDestroy){
            if ((mapa instanceof KamienieMapa)
                    || (mapa instanceof KolceMapa)){
                if (((mapa.brick.posX <= postac.brick.posX + 0.1 )
                        && (postac.brick.posX <= mapa.brick.posX + 0.1))
                        && ((mapa.brick.posY <= postac.brick.posY + 0.1)
                        && (postac.brick.posY <= mapa.brick.posY + 0.1))){
                    if (!mapa.brick.isDestroy){
                        animacja.animacjaWybuchu(postac.brick.posX + 0.05f , postac.brick.posY);
                        postac.brick.isDestroy = true;
                    }
                }
            }
            if (mapa instanceof BeczkaMapa){
                if (((mapa.brick.posX < postac.brick.posX + 0.09 )
                        && (postac.brick.posX < mapa.brick.posX + 0.09))
                        && ((mapa.brick.posY < postac.brick.posY + 0.09)
                        && (postac.brick.posY < mapa.brick.posY + 0.09))){
                    if (mapa.kill == true){
                        postac.brick.isDestroy = true;
                    }
                }
            }
        }
    }

}

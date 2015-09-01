package app.silniczek.Kolizje;



import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.BeczkaMapa;
import app.silniczek.mapa.KamienieMapa;
import app.silniczek.mapa.KolceMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 07.02.15.
 */
public class KolizjaPostacPrzeszkoda<G extends BazaMapa, P extends Postac, A extends Animacja> {

    G mapa;
    P postac;
    A animacja;

    public KolizjaPostacPrzeszkoda(G mapa, P postac, A animacja) {
        this.mapa = mapa;
        this.postac = postac;
        this.animacja = animacja;
        kolizja();
    }


    public void kolizja(){

        if (!mapa.brick.isDestroy){
            if ((mapa instanceof KamienieMapa)
            || (mapa instanceof KolceMapa)){
                if (((mapa.brick.posX <= postac.posX + 0.1 )
                && (postac.posX <= mapa.brick.posX + 0.1))
                && ((mapa.brick.posY <= postac.posY + 0.1)
                && (postac.posY <= mapa.brick.posY + 0.1))){
                    if (!mapa.brick.isDestroy){
                        animacja.animacjaWybuchu(postac.posX + 0.05f , postac.posY);
                        postac.isDestroy = true;
                    }
                }
            }
            if (mapa instanceof BeczkaMapa){
                if (((mapa.brick.posX < postac.posX + 0.1 )
                        && (postac.posX < mapa.brick.posX + 0.1))
                        && ((mapa.brick.posY < postac.posY + 0.1)
                        && (postac.posY < mapa.brick.posY + 0.1))){
                    if (mapa.kill == true){
                        postac.isDestroy = true;
                    }
                }
            }
        }
    }
}

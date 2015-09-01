package app.silniczek.Kolizje;

import app.silniczek.animacje.Animacja;
import app.silniczek.pociski.Pociski;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 09.02.15.
 */
public class KolizjaPostacPocisk<P extends Postac, Po extends Pociski, A extends Animacja>  {

    P postac;
    Po pocisk;
    A animacja;

    public KolizjaPostacPocisk(P postac, Po pocisk, A animacja) {
        this.postac = postac;
        this.pocisk = pocisk;
        this.animacja = animacja;
        kolizja();
    }

    public void kolizja(){

        if (!postac.isDestroy){
            /*
            if (((pocisk.posX <= wrog.posX + 0.1 )
            && (wrog.posX <= pocisk.posX + 0.1))
            && ((pocisk.posY <= wrog.posY + 0.1)
            && (wrog.posY <= pocisk.posY + 0.1))){*/
            if (((pocisk.posY < postac.posY + 0.1)
                && (postac.posY < pocisk.posY + 0.03 ))
                && ((pocisk.posX < postac.posX  + 0.1f)
                && (postac.posX  < pocisk.posX + 0.03f ))){
                    postac.isDestroy = true;
                    pocisk.isDestroy = true;
                    animacja.animacjaWybuchu(postac.posX + 0.05f , postac.posY);
            }
        }
    }
}

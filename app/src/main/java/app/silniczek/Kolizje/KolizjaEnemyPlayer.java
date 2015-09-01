package app.silniczek.Kolizje;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-04-04.
 */
public class KolizjaEnemyPlayer <E extends EnemyMapa, P extends Postac, A extends Animacja>{

    E wrog;
    P postac;
    A animacja;

    public KolizjaEnemyPlayer(E wrog, P postac, A animacja) {
        this.wrog = wrog;
        this.postac = postac;
        this.animacja = animacja;
        kolija();
    }

    private void kolija(){
        if (((wrog.brick.posX < postac.posX + 0.1)
                && (postac.posX < wrog.brick.posX + 0.11))
                && ((wrog.brick.posY < postac.posY + 0.1)
                && (postac.posY < wrog.brick.posY + 0.11))){
            postac.isDestroy = true;
        }

    }

}

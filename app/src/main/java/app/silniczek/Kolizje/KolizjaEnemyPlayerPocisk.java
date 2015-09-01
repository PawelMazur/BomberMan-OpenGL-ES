package app.silniczek.Kolizje;

import app.silniczek.mapa.EnemyMapa;
import app.silniczek.pociski.Pociski;

/**
 * Created by Pawel on 2015-05-09.
 */
public class KolizjaEnemyPlayerPocisk<E extends EnemyMapa, P extends Pociski> {

    E wrog;
    P pocisk;

    public KolizjaEnemyPlayerPocisk(E wrog, P pocisk) {
        this.wrog = wrog;
        this.pocisk = pocisk;
    }

    private void kolija(){
        if (((wrog.brick.posX < pocisk.posX + 0.1)
                && (pocisk.posX < wrog.brick.posX + 0.11))
                && ((wrog.brick.posY < pocisk.posY + 0.1)
                && (pocisk.posY < wrog.brick.posY + 0.11))){
            pocisk.isDestroy = true;
        }

    }
}

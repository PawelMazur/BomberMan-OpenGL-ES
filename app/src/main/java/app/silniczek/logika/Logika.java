package app.silniczek.logika;

import app.silniczek.mapa.EnemyMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-04-03.
 */
public class Logika<E extends EnemyMapa, P extends Postac> {

    E wrog;
    P postac;

    public Logika(E wrog, P postac) {
        this.wrog = wrog;
        this.postac = postac;
        kolizja();
    }

    private void kolizja(){



    }
}

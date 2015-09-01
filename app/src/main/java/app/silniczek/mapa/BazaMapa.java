package app.silniczek.mapa;

import app.silniczek.geometria.Box;

/**
 * Created by Pawel on 2015-04-02.
 */
public abstract class BazaMapa {

    private String ZNACZNIK = "BazaMapy : ";
    public CeglaMapy brick;
    public Box box;
    public boolean kill = false;



    public BazaMapa() {
        brick = new CeglaMapy();
    }

    public abstract void tworzenieMapy();


}

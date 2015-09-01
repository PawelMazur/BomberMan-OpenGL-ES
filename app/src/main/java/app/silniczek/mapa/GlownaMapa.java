package app.silniczek.mapa;

/**
 * Created by Pawel on 14.12.14.
 */
public abstract class GlownaMapa extends BazaMapa {

    public float pozycja_X = 0;
    public float pozycja_Y = 0;

    public float poruszanie = 0.01f;

    public int action;
    public int MOVE_LEFT = 1;
    public int MOVE_RIGHT = 2;

    public void move_right(){
        action = MOVE_RIGHT;
        pozycja_X = pozycja_X + poruszanie;
    }

    public void move_left(){
        action = MOVE_LEFT;
        pozycja_X = pozycja_X - poruszanie;
    }

}

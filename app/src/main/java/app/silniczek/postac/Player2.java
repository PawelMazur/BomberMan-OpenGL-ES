package app.silniczek.postac;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 2015-05-30.
 */
public class Player2 extends Postac {

    private String ZNACZNIK = "Player ";

    private int [] tekstura;
    private int [] tekstura1;
    private int [] tekstura2;
    private int [] tekstura3;
    private GL10 gl10;

    public Player2(float x, float y) {
        super(x, y);

    }

    public void zaladowanie(GL10 gl10, int[] tekstura){
        this.gl10 = gl10;
        this.tekstura = tekstura;
    }

    public void zaladowanie2(GL10 gl10, int [] ...tekstura){
        this.gl10 = gl10;
        this.tekstura1 = tekstura[0];
        this.tekstura2 = tekstura[1];
        this.tekstura3 = tekstura[2];
    }

    public void poruszanie(){

        if (!isDestroy){
            /*
            if ((BANK_POSITION_PLAYER_Y >= 0.81) && (down == false)){
                BANK_POSITION_PLAYER_Y = BANK_POSITION_PLAYER_Y - PLAYER_SPEED_Y;
            }*/
            move_left();
            move_right();
            move_down();
            move_up();

            posX = BANK_POSITION_PLAYER_X;
            posY = BANK_POSITION_PLAYER_Y;

            setLocalTranslation(gl10, posX, posY, 0, tekstura1, tekstura2, tekstura3);
        }

    }

    public float getBANK_POSITION_PLAYER_Y() {
        return BANK_POSITION_PLAYER_Y;
    }

    public float getBANK_POSITION_PLAYER_X() {
        return BANK_POSITION_PLAYER_X;
    }

    //-----------------------
}

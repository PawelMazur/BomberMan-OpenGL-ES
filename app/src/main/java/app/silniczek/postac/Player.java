package app.silniczek.postac;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 17.12.14.
 */
public class Player extends Postac {

    private String ZNACZNIK = "Player ";
    public boolean shot_1;
    public boolean shot_2;
    public boolean shot_3;

    private int [] tekstura;

    private GL10 gl10;

    //private float zakres_prawy_X = 20;
    //private float zakres_lewy_X = 20;

    public Player(float x, float y) {
        super(x, y);

    }

    public void zaladowanie(GL10 gl10, int[] tekstura){
        this.gl10 = gl10;
        this.tekstura = tekstura;
    }

    public void poruszanie(){
        /*
        if (!isDestroy){

            if (posX < 0.7){
                posX = posX + PLAYER_SPEED;
            }
            BANK_POSITION_SIDE_PLAYER = posX;
            setLocalTranslation(gl10, tekstura, posX, posY, 0);
        }*/

        //posX = BANK_POSITION_PLAYER_X;
        //posY = BANK_POSITION_PLAYER_Y;
        if ((BANK_POSITION_PLAYER_Y < 0.8) && (up == false)){
            BANK_POSITION_PLAYER_Y = BANK_POSITION_PLAYER_Y + PLAYER_SPEED_Y;
        }
        if (!isDestroy){
        if ((PLAYER_ACTION == PLAYER_MOVE_LEFT) /*&& (BANK_POSITION_SIDE_PLAYER  > 0.0)*/ && (left == true)) {

            //BANK_POSITION_SIDE_PLAYER = BANK_POSITION_SIDE_PLAYER - PLAYER_SPEED;

            if (zakres_lewy_X > 0){
                BANK_POSITION_SIDE_PLAYER = BANK_POSITION_SIDE_PLAYER - PLAYER_SPEED;
                zakres_lewy_X--;
                left = true;
            } if (zakres_lewy_X == 0){
                zakres_lewy_X = 20;
                left = false;
            }

        }else if ((PLAYER_ACTION == PLAYER_MOVE_RIGHT) && (right == true) && (czasSkokuPlayera == 20) ) {
            //BANK_POSITION_SIDE_PLAYER = BANK_POSITION_SIDE_PLAYER + PLAYER_SPEED;

            if (zakres_prawy_X > 0){
                BANK_POSITION_SIDE_PLAYER = BANK_POSITION_SIDE_PLAYER + PLAYER_SPEED;
                zakres_prawy_X--;
                right = true;
            } if (zakres_prawy_X == 0){
                zakres_prawy_X = 20;
                right = false;
            }
            //BANK_POSITION_SIDE_PLAYER = BANK_POSITION_SIDE_PLAYER + PLAYER_SPEED;
            //PLAYER_BOOL = false;

        }else if (((BANK_POSITION_PLAYER_Y < 0.8f )) && (down == true)){
            BANK_POSITION_PLAYER_Y = BANK_POSITION_PLAYER_Y + PLAYER_SPEED;
            down = false;

        } else if (((PLAYER_ACTION == PLAYER_MOVE_UP) && (BANK_POSITION_PLAYER_Y > 0.05f)) && (up == true) ){
            PLAYER_JUMP = true;
            if (czasSkokuPlayera > 0){

                if (BANK_POSITION_PLAYER_Y > 0.05){

                    BANK_POSITION_PLAYER_Y = BANK_POSITION_PLAYER_Y - PLAYER_SPEED_Y;
                }
                czasSkokuPlayera--;
                BANK_POSITION_SIDE_PLAYER += PLAYER_SPEED_X;
            }
            else if (czasSkokuPlayera <= 0){
                if (BANK_POSITION_PLAYER_Y < 0.8){
                    BANK_POSITION_PLAYER_Y = BANK_POSITION_PLAYER_Y + PLAYER_SPEED_Y;
                    BANK_POSITION_SIDE_PLAYER += PLAYER_SPEED_X;
                }
            }
        }
        /*
        if ((BANK_POSITION_PLAYER_Y > 0.8) && (BANK_POSITION_PLAYER_Y <= 9.0)){
            czasSkokuPlayera = 20;
            up = false;
        }*/
        //posX = BANK_POSITION_PLAYER_X;
            posX = BANK_POSITION_SIDE_PLAYER;
            posY = BANK_POSITION_PLAYER_Y;

        //setLocalTranslation(gl10, tekstura, posX, posY, 0);
            //setLocalTranslation(gl10, tekstura, posX, posY, 0);
        }

    }

    public GL10 getGl10() {
        return gl10;
    }

    public void setGl10(GL10 gl10) {
        this.gl10 = gl10;
    }

    public int[] getTekstura() {
        return tekstura;
    }

    public void setTekstura(int[] tekstura) {
        this.tekstura = tekstura;
    }

    public float getBANK_POSITION_SIDE_PLAYER() {
        return BANK_POSITION_SIDE_PLAYER;
    }

    public float getBANK_POSITION_PLAYER_Y() {
        return BANK_POSITION_PLAYER_Y;
    }

    public float getBANK_POSITION_PLAYER_X() {
        return BANK_POSITION_PLAYER_X;
    }

    //--------------------------------

    public boolean isShot_1() {
        return shot_1;
    }

    public boolean isShot_2() {
        return shot_2;
    }

    public boolean isShot_3() {
        return shot_3;
    }



}

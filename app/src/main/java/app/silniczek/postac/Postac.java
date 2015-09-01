package app.silniczek.postac;


import javax.microedition.khronos.opengles.GL10;

import app.silniczek.geometria.Box;

/**
 * Created by Pawel on 17.12.14.
 */
public abstract class Postac {

    private String ZNACZNIK = "Postac";

    public Box box;

    public float posX = 0.5f;
    public float posY = 0.8f;
    public float camera_posX = 0;
    public float camera_posY = 0;

    public boolean poruszanieMapy = false;

    public float PLAYER_ACTION;
    public float PLAYER_MOVE_LEFT = 1;
    public float PLAYER_MOVE_RIGHT = 2;
    public float PLAYER_MOVE_DOWN = 3;
    public float PLAYER_MOVE_UP = 4;
    public float PLAYER_SPEED = 0.01f;
    public float PLAYER_SPEED_Y = 0.01f;
    public float PLAYER_SPEED_X = 0.01f; //0.005f;

    public float BANK_POSITION_SIDE_PLAYER = 0.5f;
    public float BANK_POSITION_PLAYER_Y = 0.80f;
    public float BANK_POSITION_PLAYER_X = 0.50f;


    public boolean PLAYER_SHOOT = false;
    public boolean PLAYER_SHOOT_2 = false;
    public boolean PLAYER_JUMP = false;

    public int czasSkokuPlayera = 20;

    public boolean isDestroy;


    public boolean left = false;
    public boolean right = false;
    public boolean up = false;
    public boolean down = false;

    public float zakres_prawy_X = 10;
    public float zakres_lewy_X = 10;

    public float zakres_gorny_Y = 10;
    public float zakres_dolny_Y = 10;

    public boolean shot_1;
    public boolean shot_2;
    public boolean shot_3;

    private int ileKlatek = 0;

    public Postac(float x, float y) {
        box = new Box(x, y);

    }


    /*
    public void setLocalTranslation(GL10 gl10, float x, float y, float z, int[] tekstura){

        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_PROJECTION);
        gl10.glLoadIdentity();
        camera_posX = -x * 2 + 1.0f;
        gl10.glTranslatef(camera_posX, 0, 0);
        gl10.glOrthof(0f, 1f, 1f, 0f, -1f, 1f);
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        gl10.glTranslatef(x, y, z);
        gl10.glMatrixMode(GL10.GL_TEXTURE);
        gl10.glLoadIdentity();
        gl10.glTranslatef(0.1f, 0.1f, 0);
        box.rysujBox(gl10, tekstura);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }*/


    public void setLocalTranslation(GL10 gl10, float x, float y, float z, int[] ...tekstura){

        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_PROJECTION);
        gl10.glLoadIdentity();
        camera_posX = -x * 2 + 1.0f;
        gl10.glTranslatef(camera_posX, 0, 0);
        gl10.glOrthof(0f, 1f, 1f, 0f, -1f, 1f);
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        gl10.glTranslatef(x, y, z);
        gl10.glMatrixMode(GL10.GL_TEXTURE);
        gl10.glLoadIdentity();

        if (ileKlatek % 3 == 0){
            box.rysujBox(gl10, tekstura[0]);
        } else if ((ileKlatek % 3 == 1) && (PLAYER_ACTION != 0)) {
            box.rysujBox(gl10, tekstura[1]);
        } else if ((ileKlatek % 3 == 2) && (PLAYER_ACTION != 0)) {
            box.rysujBox(gl10, tekstura[0]);
        }
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
        ileKlatek++;
    }

    public void move_left(){
        if ((PLAYER_ACTION == PLAYER_MOVE_LEFT) && (left == true)) {
            if (zakres_lewy_X > 0){
                BANK_POSITION_PLAYER_X = BANK_POSITION_PLAYER_X - PLAYER_SPEED_X;
                zakres_lewy_X--;
                left = true;
            } if (zakres_lewy_X == 0){
                zakres_lewy_X = 10;
                left = false;
            }
        }
    }

    public void move_right(){
        if ((PLAYER_ACTION == PLAYER_MOVE_RIGHT) && (right == true)) {

            if (zakres_prawy_X > 0){
                BANK_POSITION_PLAYER_X = BANK_POSITION_PLAYER_X + PLAYER_SPEED_X;
                zakres_prawy_X--;
                right = true;
            } if (zakres_prawy_X == 0){
                zakres_prawy_X = 10;
                right = false;
            }

        }
    }

    public void move_up(){
        if ((PLAYER_ACTION == PLAYER_MOVE_UP) && (up == true)) {

            if (zakres_gorny_Y > 0){
                BANK_POSITION_PLAYER_Y = BANK_POSITION_PLAYER_Y - PLAYER_SPEED_Y;
                zakres_gorny_Y--;
                up = true;
            } if (zakres_gorny_Y == 0){
                zakres_gorny_Y = 10;
                up = false;
            }
        }
    }

    public void move_down(){
        if ((PLAYER_ACTION == PLAYER_MOVE_DOWN) && (down == true)) {

            if (zakres_dolny_Y > 0){
                BANK_POSITION_PLAYER_Y = BANK_POSITION_PLAYER_Y + PLAYER_SPEED_Y;
                zakres_dolny_Y--;
                down = true;
            } if (zakres_dolny_Y == 0){
                zakres_dolny_Y = 10;
                down = false;
            }
        }
    }

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

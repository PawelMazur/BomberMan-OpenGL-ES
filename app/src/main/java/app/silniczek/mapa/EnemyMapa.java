package app.silniczek.mapa;

import android.util.Log;

import app.silniczek.pociski.Bron;

/**
 * Created by Pawel on 2015-03-16.
 */
public abstract class EnemyMapa extends BazaMapa implements Bron {

    private String ZNACZNIK = "EnemyMapa : ";
    public float positionX = 0;
    public float positionY = 0;
    public float czasSkoku = 20;
    public float speed_Y = 0.01f;
    public float speed_X = 0.01f;

    //public float zakres_lewy_X = 20;
    //public float zakres_prawy_X = 20;


    public boolean jump = true;
    public boolean shot = false;

    public float PLAYER_ACTION;
    public float PLAYER_ACTION_X;
    public float PLAYER_ACTION_Y;
    public float PLAYER_MOVE_LEFT = 1;
    public float PLAYER_MOVE_RIGHT = 2;
    public float PLAYER_MOVE_DOWN = 3;
    public float PLAYER_MOVE_UP = 4;

    public float zakres_prawy_X = 10;
    public float zakres_lewy_X = 10;

    public float zakres_gorny_Y = 10;
    public float zakres_dolny_Y = 10;

    public void jump(){
        if (czasSkoku > 0){
            PLAYER_ACTION_Y = PLAYER_MOVE_UP;
            positionY = positionY - speed_Y/*0.01f*/;
            czasSkoku--;
            Log.d(ZNACZNIK, " czas skoku " + czasSkoku);
        } if (czasSkoku == 0 ){
            PLAYER_ACTION_Y = PLAYER_MOVE_DOWN;
        }
    }

    /*
    public void move_left(){

        //PLAYER_ACTION_X = PLAYER_MOVE_LEFT;
        PLAYER_ACTION = PLAYER_MOVE_LEFT;
        positionX = positionX - speed_X;
    }

    public void move_right(){

        //PLAYER_ACTION_X = PLAYER_MOVE_RIGHT;
        PLAYER_ACTION = PLAYER_MOVE_RIGHT;
        positionX = positionX + speed_X;
        //}
    }

    public void move_up(){
        //PLAYER_ACTION_Y = PLAYER_MOVE_UP;
        PLAYER_ACTION = PLAYER_MOVE_UP;
        positionY = positionY - speed_Y;
    }

    public void move_down(){
        //PLAYER_ACTION_Y = PLAYER_MOVE_DOWN;
        PLAYER_ACTION = PLAYER_MOVE_DOWN;
        positionY = positionY + speed_Y;
    }*/


    public void move_left(){
        //PLAYER_ACTION_X = PLAYER_MOVE_LEFT;
        PLAYER_ACTION = PLAYER_MOVE_LEFT;
        if (zakres_lewy_X > 0){
            positionX = positionX - speed_X;
            zakres_lewy_X--;
        } if (zakres_lewy_X == 0){
            zakres_lewy_X = 10;
        }

    }

    public void move_right(){
        //PLAYER_ACTION_X = PLAYER_MOVE_RIGHT;
        PLAYER_ACTION = PLAYER_MOVE_RIGHT;
        if (zakres_prawy_X > 0){
            positionX = positionX + speed_X;
            zakres_prawy_X--;
        } if (zakres_prawy_X == 0){
            zakres_prawy_X = 10;
        }
    }

    public void move_up(){
        //PLAYER_ACTION_Y = PLAYER_MOVE_UP;
        PLAYER_ACTION = PLAYER_MOVE_UP;
        if (zakres_gorny_Y > 0){
            positionY = positionY - speed_Y;
            zakres_gorny_Y--;
        } if (zakres_gorny_Y == 0){
            zakres_gorny_Y = 10;
        }
    }

    public void move_down(){
        //PLAYER_ACTION_Y = PLAYER_MOVE_DOWN;
        PLAYER_ACTION = PLAYER_MOVE_DOWN;
        if (zakres_dolny_Y > 0){
            positionY = positionY + speed_Y;
            zakres_dolny_Y--;
        } if (zakres_dolny_Y == 0){
            zakres_dolny_Y = 10;
        }
    }




    public void gravitation() {
        if (PLAYER_ACTION_Y != PLAYER_MOVE_UP) {
            PLAYER_ACTION_Y = PLAYER_MOVE_DOWN;
            positionY = positionY + speed_Y;
        }
    }

    public void gravitation2(float masa){
        if(PLAYER_ACTION_Y != PLAYER_MOVE_UP){
            PLAYER_ACTION_Y = PLAYER_MOVE_DOWN;
            positionY = positionY + masa;
        }
    }

    public void move(){
        if (zakres_prawy_X > 0){
            move_right();
            zakres_prawy_X--;
        }else if (zakres_lewy_X == 0){
            zakres_prawy_X = 20;
            zakres_lewy_X = 20;
        }else if (zakres_prawy_X <= 0){
            //move_left();
            zakres_lewy_X--;
        }
    }
}

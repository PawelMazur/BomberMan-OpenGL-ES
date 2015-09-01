package app.silniczek;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.Display;
import android.view.MotionEvent;

import app.silniczek.pociski.TworzeniePocisku;
import app.silniczek.postac.Player;
import app.silniczek.postac.Player2;
import app.silniczek.postac.PlayerVars;


/**
 * Created by Pawel on 01.12.14.
 */
public class WidokGL extends GLSurfaceView {

    private String ZNACZNIK = "WidokGL : ";
    private RenderGL renderGL;
    private Player2 player = new Player2(0.09f, 0.09f);
    public Display display;
    private float czas = 20;
    private boolean czas_start = true;
    private boolean czas_aktywacji = false;
    private TworzeniePocisku tworzeniePocisku;
    public WidokGL(Context context) {
        super(context);
        PlayerVars.player = player;
        renderGL = new RenderGL(context);
        setRenderer(renderGL);
        
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        float rozmiarEklanu_X = display.getWidth();
        float rozmiarEklanu_Y = display.getHeight();
        float uklad_X = rozmiarEklanu_X / 10;
        float uklad_Y = rozmiarEklanu_Y / 10;
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //Log.d(ZNACZNIK , "uklad_X : " + uklad_X);
                //Log.d(ZNACZNIK, "uklad_Y : " + uklad_Y);
                //Log.d(ZNACZNIK, "x : " + x);
                //Log.d(ZNACZNIK, "y : " + y);
                if((uklad_X * 1 < x && x < uklad_X * 2) &&
                        (uklad_Y * 8 < y && y < uklad_Y * 9)){
                    player.PLAYER_ACTION = player.PLAYER_MOVE_UP;
                    player.up = true;
                }else if((uklad_X * 1 < x && x < uklad_X * 2 ) &&
                        (uklad_Y * 9 < y && y < uklad_Y * 10 )){
                    player.PLAYER_ACTION = player.PLAYER_MOVE_DOWN;
                    player.down = true;
                }else if((uklad_X * 0 < x && x < uklad_X * 1 ) &&
                        (uklad_Y * 8.5 < y && y < uklad_Y * 9.5 )){
                    if (player.czasSkokuPlayera == 20){
                        player.PLAYER_ACTION = player.PLAYER_MOVE_LEFT;
                        player.left = true;
                    }
                }else if((uklad_X * 2 < x && x < uklad_X * 3) &&
                        (uklad_Y * 8.5  < y && y < uklad_Y * 9.5 )){
                    if (player.czasSkokuPlayera == 20){
                        player.PLAYER_ACTION = player.PLAYER_MOVE_RIGHT;
                        player.right = true;
                    }
                }else if((uklad_X * 9 < x && x < uklad_X * 10)
                        &&(uklad_Y * 8 < y && y < uklad_Y * 10)){
                    player.shot_1 = true;
                }else if((uklad_X * 8 < x && x < uklad_X * 9)
                    &&(uklad_Y * 8 < y && y < uklad_Y * 10)){
                    player.shot_2 = true;
                }else if((uklad_X * 7 < x && x < uklad_X * 8)
                        &&(uklad_Y * 8 < y && y < uklad_Y * 10)){
                    player.shot_3 = true;
                    //czasOdnowieniaPocisku(player);
                }else if((uklad_X * 9 < x && x < uklad_X * 10)
                        &&(uklad_Y * 0 < y && y < uklad_Y * 1)){
                    player.PLAYER_SHOOT_2 = true;

                }

                break;

        }
        //tworzeniePocisku.start();



        return super.onTouchEvent(event);
    }

    private void czasPocisku(){
        czas_start = true;
        if (czas_start){
            czas_aktywacji = true;
        }
    }

    private void czasOdnowieniaPocisku(Player player){
        if (czas_aktywacji){
            czas--;
            czas_start = false;
        } if (czas >= 0){
            player.shot_3 = true;
        } if (czas == 0){
            czas = 20;
            player.shot_3 = false;
        }

    }
}

package app.silniczek.pociski;

import android.util.Log;

import app.silniczek.postac.Player;

/**
 * Created by Pawel on 2015-05-04.
 */
public class TworzeniePocisku extends Thread{

    private String ZNACZNIK = "TworzeniePocisku : ";
    private Player player;

    public TworzeniePocisku(Player player){
        this.player = player;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            player.PLAYER_SHOOT = false;
            player.shot_2 = false;
            player.shot_3 = false;
            Log.d(ZNACZNIK, "Player PLAYER SHOOT: " + player.PLAYER_SHOOT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

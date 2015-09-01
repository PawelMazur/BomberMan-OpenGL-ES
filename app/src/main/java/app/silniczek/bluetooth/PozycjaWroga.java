package app.silniczek.bluetooth;

import java.util.StringTokenizer;

/**
 * Created by Pawel on 2015-05-29.
 */
public class PozycjaWroga {

    float posX = 0.7f;
    float posY = 0.8f;


    public void pozycja(String pozycja) {
        StringTokenizer tokenizer = new StringTokenizer(pozycja);
        while (tokenizer.hasMoreTokens()){
            setPosX(Float.parseFloat(tokenizer.nextToken()));
            setPosY(Float.parseFloat(tokenizer.nextToken()));
        }
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
}

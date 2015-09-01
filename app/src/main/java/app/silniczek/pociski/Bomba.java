package app.silniczek.pociski;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 2015-05-31.
 */
public class Bomba extends Pociski {

    int czas = 60;
    int[] tekstura1;
    int[] tekstura2;

    public Bomba(float x, float y, int[] ...tekstura) {
        super(x, y);
        this.tekstura1 = tekstura[0];
        this.tekstura2 = tekstura[1];
    }

    @Override
    public void wystrzel(GL10 gl10, float pozycjaY, float pozycjaX, boolean shot) {
        if (shot){
            wybuch = false;
            isDestroy = false;
        }

        if (shot){
            if (!isDestroy){

                if (!jesliZostalWystrzelony){
                    jesliZostalWystrzelony = true;
                    posY = pozycjaY;
                    posX = pozycjaX;
                    czas = 20;
                }
                czas--;
                if (czas < 0){
                    wybuch = true;
                }
                setLocalTranslation(gl10, tekstura1, posX, posY, 0);
            }

            if (wybuch){
                setLocalTranslation(gl10, tekstura2, posX, posY, 0);
            }
        }

    }
}

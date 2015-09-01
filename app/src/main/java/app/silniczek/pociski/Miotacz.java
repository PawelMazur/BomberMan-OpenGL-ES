package app.silniczek.pociski;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 17.12.14.
 */
public class Miotacz extends Pociski {

    private int[] tekstura;

    public Miotacz(float x, float y, int[] tekstura) {
        super(x, y);
        this.tekstura = tekstura;
    }


    @Override
    public void wystrzel(GL10 gl10, float pozycjaY, float pozycjaX, boolean shot) {

        if (shot){
            isDestroy = false;
        }

        if (shot){
            //if (zakres >= 0){
                if (!isDestroy){

                posX += szybkoscPocisku;
                    if (!jesliZostalWystrzelony){
                        jesliZostalWystrzelony = true;
                        posY = pozycjaY;
                        posX = pozycjaX;
                    }
                    setLocalTranslation(gl10, tekstura, posX, posY, 0);
                }
                //zakres--;

            //}
            /* if (zakres == 0){
                zakres = 20;
                jesliZostalWystrzelony = true;
                isDestroy = false;
            }*/
        }

    }
}

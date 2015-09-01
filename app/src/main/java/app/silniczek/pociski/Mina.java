package app.silniczek.pociski;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 22.12.14.
 */
public class Mina extends Pociski {

    int czas = 30;
    int[] tekstura;

    public Mina(float x, float y, int[] tekstura) {
        super(x, y);
        this.tekstura = tekstura;
    }

    @Override
    public void wystrzel(GL10 gl10, float pozycjaY, float pozycjaX, boolean shot) {

        if (shot){
            isDestroy = false;
        }

        if (shot){
            if (!isDestroy){

                if (!jesliZostalWystrzelony){
                    jesliZostalWystrzelony = true;
                    posY = pozycjaY;
                    posX = pozycjaX;
                }

                setLocalTranslation(gl10, tekstura, posX, posY, 0);
            }
        }
    }
}

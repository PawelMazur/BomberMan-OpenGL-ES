package app.silniczek.pociski;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 17.12.14.
 */
public class Kula extends Pociski {

    private String ZNACZNIK = "Kula : ";
    int [] tekstura;

    public Kula(float x, float y, int [] tekstura) {
        super(x, y);
        this.tekstura = tekstura;
    }



    @Override
    public void wystrzel(GL10 gl10, float pozycjaY, float pozycjaX, boolean shot ) {

        if (shot){
            isDestroy = false;
        }

        if (shot){
            if (!isDestroy){
                posX += szybkoscPocisku;
                if (!jesliZostalWystrzelony){

                    jesliZostalWystrzelony = true;
                    posY = pozycjaY + 0.03f;
                    posX = pozycjaX;
                }
                //Log.d(ZNACZNIK, "pozycja : " + posX + " : " + posY);
                setLocalTranslation(gl10, tekstura, posX, posY, 0);
            }
        }
    }
}

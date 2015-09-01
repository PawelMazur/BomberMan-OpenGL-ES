package app.silniczek.pociski;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 17.12.14.
 */
public class Granatnik extends Pociski {

    private int[] tekstura;
    private float przesuniecie_X = 0.003f;
    private float przesuniecie_Y = 0.01f;
    private boolean strzal = false;

    public Granatnik(float x, float y, int[] tekstura) {
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

                if (ileRazyPodniesc > 0){
                    posY = posY - przesuniecie_X/*0.01f*/;
                    ileRazyPodniesc--;

                } else if (ileRazyPodniesc <= 0){
                    posY = posY + przesuniecie_X/*0.01f*/;
                }
                posX += przesuniecie_Y;
                if (!jesliZostalWystrzelony){
                    jesliZostalWystrzelony = true;
                    zaladowanieUruchom = true;
                    posY = pozycjaY;
                    posX = pozycjaX;

                }

                setLocalTranslation(gl10, tekstura, posX, posY, 0);

            }
        }
        /*
        if (jesliZostalWystrzelony){
            czasZaladowania--;
        }
        if (czasZaladowania <= 0){
            jesliZostalWystrzelony = false;
            isDestroy = false;
            czasZaladowania = 20;
        }*/
    }
}

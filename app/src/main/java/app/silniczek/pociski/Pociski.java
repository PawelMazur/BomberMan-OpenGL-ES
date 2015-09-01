package app.silniczek.pociski;



import javax.microedition.khronos.opengles.GL10;

import app.silniczek.geometria.Box;

/**
 * Created by Pawel on 17.12.14.
 */
public abstract class Pociski {

    private String ZNACZNIK = "Postac";

    public Box box;
    private float x = 0.1f;
    private float y = 0.1f;
    public float posX = -1;
    public float posY = -1;
    public boolean isDestroy = false;
    public int typPosisku;
    public int ileRazyPodniesc = 20;
    public boolean jesliZostalWystrzelony = false;
    public float szybkoscPocisku = 0.01f;
    public float zakres = 20;
    public int czasZaladowania = 40;
    public boolean zaladowanieUruchom = false;
    public boolean wybuch = false;


    public Pociski(float x, float y) {
        box = new Box(x, y);
    }


    public void setLocalTranslation(GL10 gl10, int[] tekstura, float x, float y, float z){
        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        gl10.glTranslatef(x, y, z);
        gl10.glMatrixMode(GL10.GL_TEXTURE);
        gl10.glLoadIdentity();
        box.rysujBox(gl10, tekstura);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }


    public abstract void wystrzel(GL10 gl10, float BANK_POSITION_PLAYER, float pozycjaX, boolean PLAYER_SHOOT);
}

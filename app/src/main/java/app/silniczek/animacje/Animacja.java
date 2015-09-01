package app.silniczek.animacje;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 08.01.15.
 */
public class Animacja {

    private String ZNACZNIK = "Animacja : ";
    private WybuchPocisku wybuchPocisku;
    private GL10 gl10;
    private int[] tekstura;

    public Animacja(GL10 gl10, int [] tekstura) {

        wybuchPocisku = new WybuchPocisku();
        this.gl10 = gl10;
        this.tekstura = tekstura;
    }

    public void animacjaDymu(float pozycjaX, float pozycjaY){

        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        gl10.glTranslatef(pozycjaX , pozycjaY + 0.05f , 0);
        gl10.glMatrixMode(GL10.GL_TEXTURE);
        gl10.glLoadIdentity();
        wybuchPocisku.rysujWybuchPocisku(gl10, tekstura);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }


    public void animacjaWybuchu( float pozycjaX, float pozycjaY){

        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        gl10.glTranslatef(pozycjaX, pozycjaY, 0);
        gl10.glMatrixMode(GL10.GL_TEXTURE);
        gl10.glLoadIdentity();
        wybuchPocisku.rysujWybuchPocisku(gl10, tekstura);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }


}

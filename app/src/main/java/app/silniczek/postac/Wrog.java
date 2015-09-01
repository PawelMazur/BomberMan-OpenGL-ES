package app.silniczek.postac;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 17.12.14.
 */
public class Wrog extends Postac {

    private GL10 gl10;
    public float ENEMY_ACTION;
    public float ENEMY_MOVE_LEFT = 1;
    public float ENEMY_MOVE_RIGHT = 2;
    public float ENEMY_MOVE_DOWN = 3;
    public float ENEMY_MOVE_UP = 4;
    public float ENEMY_SPEED = 0.01f;
    public float BANK_POSITION_SIDE_ENEMY = 0.5f;
    public float BANK_POSITION_ENEMY = 0.60f;
    public float BANK_POSITION_ENEMY_X = 0.60f;
    public boolean ENEMY_BOOL = false;
    public float temp_position_side_enemy = 0;
    public float temp_position_enemy = 0;
    public boolean ENEMY_SHOOT = false;
    public int [] tekstura;
    public float przesuniecie_X;

    public Wrog(float x, float y, int[] tekstura) {
        super(x, y);
        this.tekstura = tekstura;
    }

    public void poruszanie(GL10 gl10, float x, float y, float z){

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

}

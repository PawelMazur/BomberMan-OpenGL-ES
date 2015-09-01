package app.silniczek.Przyciski;


import javax.microedition.khronos.opengles.GL10;

import app.silniczek.tekstury.Tekstury;

/**
 * Created by Pawel on 20.12.14.
 */
public class TorzeniePrzyciskow {

    private Tekstury tekstury;
    private Przycisk przycisk = new Przycisk();
    private GL10 gl10;
    private float camera_posX = 0;

    public TorzeniePrzyciskow(GL10 gl10, Tekstury tekstury ) {
        this.tekstury = tekstury;
        this.gl10 = gl10;
    }

    public void przyciskWDol(float x){
        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        //gl10.glTranslatef(0.1f, 0.9f, 0);
        gl10.glTranslatef(x - 0.4f, 0.9f, 0);

        gl10.glMatrixMode(gl10.GL_TEXTURE);
        gl10.glLoadIdentity();
        przycisk.rysujPrzycisk(gl10, tekstury.teksturaStrzalkiWDol);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }

    public void przyciskWGore(float x){
        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        //gl10.glTranslatef(0.1f, 0.8f, 0);
        gl10.glTranslatef(x - 0.4f, 0.8f, 0);

        gl10.glMatrixMode(gl10.GL_TEXTURE);
        gl10.glLoadIdentity();
        przycisk.rysujPrzycisk(gl10, tekstury.teksturaStrzalkiWGore);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }

    public void przyciskWLewo(float x){
        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        //gl10.glTranslatef(0.0f, 0.85f, 0);
        gl10.glTranslatef(x - 0.5f, 0.85f, 0);
        gl10.glMatrixMode(gl10.GL_TEXTURE);
        gl10.glLoadIdentity();
        przycisk.rysujPrzycisk(gl10, tekstury.teksturaStrzalkiWLewo);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }

    public void przyciskWPrawo(float x){
        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        //gl10.glTranslatef(0.2f, 0.85f, 0);
        gl10.glTranslatef(x - 0.3f, 0.85f, 0);
        gl10.glMatrixMode(gl10.GL_TEXTURE);
        gl10.glLoadIdentity();
        przycisk.rysujPrzycisk(gl10, tekstury.teksturaStrzalkiWPrawo);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }

    public void przyciskDoUzycjaGranatu(float x){
        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        //gl10.glTranslatef(0.9f, 0.9f, 0);
        gl10.glTranslatef(x + 0.4f, 0.9f, 0);
        gl10.glMatrixMode(gl10.GL_TEXTURE);
        gl10.glLoadIdentity();
        przycisk.rysujPrzycisk(gl10, tekstury.teksturaGranat);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }

    public void przyciskDoUzycjaKuli(float x){
        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        //gl10.glTranslatef(0.8f, 0.9f, 0);
        gl10.glTranslatef(x + 0.3f, 0.9f, 0);
        gl10.glMatrixMode(gl10.GL_TEXTURE);
        gl10.glLoadIdentity();
        przycisk.rysujPrzycisk(gl10, tekstury.teksturaPocisk);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }

    public void przyciskDoUzycjaMiotacza(float x){
        gl10.glPushMatrix();
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
        //gl10.glTranslatef(0.7f, 0.9f, 0);
        gl10.glTranslatef(x + 0.2f, 0.9f, 0);
        gl10.glMatrixMode(gl10.GL_TEXTURE);
        gl10.glLoadIdentity();
        przycisk.rysujPrzycisk(gl10, tekstury.teksturaFlame);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }




}

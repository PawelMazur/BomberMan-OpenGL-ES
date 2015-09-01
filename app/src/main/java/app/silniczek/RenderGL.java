package app.silniczek;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import app.silniczek.Przyciski.TorzeniePrzyciskow;
import app.silniczek.bluetooth.MyServer;
import app.silniczek.mapa.CzytaczMapy;
import app.silniczek.postac.PlayerVars;
import app.silniczek.postac.Wrog;
import app.silniczek.tekstury.Tekstury;

/**
 * Created by Pawel on 01.12.14.
 */
public class RenderGL implements GLSurfaceView.Renderer {

    private String ZNACZNIK = "RenderGL : ";
    private Context context;
    private Tekstury tekstury;
    //private Player2 player;
    private TorzeniePrzyciskow przyciski;
    private GlownaKlasa glownaKlasa2;
    private CzytaczMapy czytaczMapy;
    private Wrog wrog;
    private MyServer myServer;


    public RenderGL(Context context) {
        this.context = context;

        /*(
        myServer = new MyServer(context);
        Thread thread = new Thread(myServer);
        thread.start();
        )*/
        Toast.makeText(context.getApplicationContext(), " " + MainVars.adapter, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

        staleGeometrii(gl10);
        staleTekstur(gl10);
        MainVars.gl10 = gl10;


        tekstury = new Tekstury(gl10, context);
        przyciski = new TorzeniePrzyciskow(gl10, tekstury);
        czytaczMapy = new CzytaczMapy(gl10, context);
        glownaKlasa2 = new GlownaKlasa(gl10, context, czytaczMapy.getElementyMapies());
        wrog = new Wrog(.1f, .1f, tekstury.teksturaWrog);

        dodaniePrzezroczystosci(gl10);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int szerokosc, int wysokosc) {

        gl10.glViewport(0, 0, szerokosc, wysokosc);

    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        gl10.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        glownaKlasa2.tworzenieGry(PlayerVars.player);

        //myServer.setWiadomosc("" + PlayerVars.player.posX + " " + PlayerVars.player.posY);
        //wrog.poruszanie(gl10, myServer.pozycjaWroga.getPosX(), myServer.pozycjaWroga.getPosY(), 0);

        przyciski.przyciskWDol(PlayerVars.player.posX);
        przyciski.przyciskWGore(PlayerVars.player.posX);
        przyciski.przyciskWLewo(PlayerVars.player.posX);
        przyciski.przyciskWPrawo(PlayerVars.player.posX);
        przyciski.przyciskDoUzycjaGranatu(PlayerVars.player.posX);
        przyciski.przyciskDoUzycjaKuli(PlayerVars.player.posX);
        przyciski.przyciskDoUzycjaMiotacza(PlayerVars.player.posX);


        glownaKlasa2.tworzenieListyMap(PlayerVars.player);
    }

    private void staleGeometrii(GL10 gl10){
        gl10.glEnable(GL10.GL_DEPTH_TEST);
        gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    }

    private void staleTekstur(GL10 gl10){
        gl10.glEnable(GL10.GL_TEXTURE_2D);
        gl10.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    }

    private void dodaniePrzezroczystosci(GL10 gl10){
        gl10.glDisable(GL10.GL_DEPTH_TEST);
        gl10.glEnable(GL10.GL_BLEND);
        gl10.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE);
    }


}

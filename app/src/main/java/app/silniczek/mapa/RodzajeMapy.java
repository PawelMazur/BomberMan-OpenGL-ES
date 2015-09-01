package app.silniczek.mapa;

import android.util.Log;

/**
 * Created by Pawel on 26.10.14.
 */
public class RodzajeMapy {

    private String ZNACZNIK = " RodzajeMapy : " ;
    private CeglaMapy[] brick;

    public RodzajeMapy(CeglaMapy[] brick) {
        this.brick = brick;

    }

    protected void normalnaMapa(int numerKolumny){
        for (int i = 0; i < numerKolumny; i++ ){
            brick[i] = new CeglaMapy();
            if (i < 40 ){
                brick[i].posX =  i * 0.5f / 10;
                brick[i].posY = 0.95f;
            }
            if (40 <= i && i < 80){
                brick[i].posX = (i % 40) * 0.5f / 10;
                brick[i].posY = 0.00f;
            }
            if (80 <= i && i < 100){
                brick[i].posX = 0.0f;
                brick[i].posY =  (i % 80) * 0.5f / 10;
            }
            if (i >= 100){
                Log.d(ZNACZNIK, " Przeszlo ");
                brick[i].posX = 0.8f;
                brick[i].posY = 0.8f;
            }
            /*
            if (100 <= i && i < 120){
                brick[i].posX = 1f;
                brick[i].posY =  (i % 100) * 0.5f / 10;
            }
            if (120 <= i && i < 140){
                brick[i].posX = 1.05f;
                brick[i].posY =  (i % 120) * 0.5f / 10;
            }
            if (140 <= i && i < 160){
                brick[i].posX = 1.1f;
                brick[i].posY =  (i % 140) * 0.5f / 10;
            }*/
            /*
            if (i >= 15 && i < 20){
                brick[i].posX = 0.1f + (i % 15) * 2f / 10f;
                brick[i].posY = 0.6f;
            }*/
        }
    }

    protected void tloMapy(int numerKolumny){
        for (int i = 0; i < numerKolumny; i++ ){
            brick[i] = new CeglaMapy();
            if (i < 40 ){
                brick[i].posX =  i * 0.5f / 10;
                brick[i].posY = 0.95f;
            }
            if (40 <= i && i < 80){
                brick[i].posX = (i % 40) * 0.5f / 10;
                brick[i].posY = 0.00f;
            }
            if (80 <= i && i < 100){
                brick[i].posX = 0.0f;
                brick[i].posY =  (i % 80) * 0.5f / 10;
            }
        }
    }

    protected void mapa(int numerKolumny){
        for (int i = 0; i < numerKolumny; i++ ){
            brick[i] = new CeglaMapy();
            brick[i].jakoscCegly = 3;
            if (0 <= i && i < 20){
                brick[i].posX = 1f;
                brick[i].posY =  i  * 0.5f / 10;
            }
            if (20 <= i && i < 40){
                brick[i].posX = 1.05f;
                brick[i].posY =  (i % 20) * 0.5f / 10;
            }
            if (40 <= i && i < 60){
                brick[i].posX = 1.1f;
                brick[i].posY =  (i % 40) * 0.5f / 10;
            }
            if (60 <= i && i < 80){
                brick[i].posX = 1.15f;
                brick[i].posY =  (i % 60) * 0.5f / 10;
            }
        }
    }


}

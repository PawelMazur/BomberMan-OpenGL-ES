package app.silniczek.logika;

import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.BeczkaMapa;
import app.silniczek.mapa.EnemyMapa;
import app.silniczek.mapa.KolceMapa;
import app.silniczek.postac.Postac;

/**
 * Created by Pawel on 2015-04-04.
 */
public class Logika2 <G extends BazaMapa, E extends EnemyMapa, P extends Postac,A extends Animacja> {

    G mapa;
    E wrog;
    P postac;
    A animacja;

    public Logika2(G mapa, E wrog,P postac, A animacja) {
        this.mapa = mapa;
        this.wrog = wrog;
        this.postac = postac;
        this.animacja = animacja;

        kolizja();
    }

    private void kolizja(){
        if (!mapa.brick.isDestroy){

            if (mapa instanceof KolceMapa){
                if (((wrog.brick.posX < mapa.brick.posX + 0.31)
                && (mapa.brick.posX < wrog.brick.posX + 0.31))
                && ((wrog.brick.posY < mapa.brick.posY + 0.31)
                && (mapa.brick.posY < mapa.brick.posY + 0.31))){
                    if (((KolceMapa) mapa).action == ((KolceMapa) mapa).MOVE_LEFT){
                        wrog.move_left();
                    }

                }
            }

            if (mapa instanceof BeczkaMapa) {
                if (((wrog.brick.posX < mapa.brick.posX + 0.20)
                && (mapa.brick.posX < wrog.brick.posX + 0.20))
                && ((wrog.brick.posY < mapa.brick.posY + 0.20)
                && (mapa.brick.posY < mapa.brick.posY + 0.20))){
                    if (mapa.kill == true){
                        //wrog.jump();
                    }
                }
            }

            if (((wrog.brick.posX < postac.posX + 0.3)
                    && (postac.posX < wrog.brick.posX + 0.3))
                    && ((wrog.brick.posY < postac.posY + 0.3)
                    && (mapa.brick.posY < mapa.brick.posY + 0.3))){
                if (postac.PLAYER_ACTION == postac.PLAYER_MOVE_LEFT){
                    wrog.move_left();
                }
            }

            if (((wrog.brick.posX < mapa.brick.posX + 0.10)
                    && (mapa.brick.posX < wrog.brick.posX + 1.10))
                    && ((wrog.brick.posY < mapa.brick.posY + 0.10)
                    && (mapa.brick.posY < mapa.brick.posY + 0.10))){
                if (postac.PLAYER_ACTION == postac.PLAYER_MOVE_RIGHT){
                    wrog.move_up();;
                }
            }



        }
    }
}

package app.silniczek;

/**
 * Created by Pawel on 25.01.15.
 */

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import app.silniczek.Kolizje.KolizjaBombaMapa2;
import app.silniczek.Kolizje.KolizjaEnemyMapa;
import app.silniczek.Kolizje.KolizjaEnemyMapa2;
import app.silniczek.Kolizje.KolizjaPociskEnemyZAnimacja;
import app.silniczek.Kolizje.KolizjaPociskMapaZAnimacja2;
import app.silniczek.Kolizje.KolizjaPostacMapa2;
import app.silniczek.Kolizje.KolizjaPostacPrzeszkoda;
import app.silniczek.animacje.Animacja;
import app.silniczek.mapa.BazaMapa;
import app.silniczek.mapa.BeczkaMapa;
import app.silniczek.mapa.BeczkaMapa2;
import app.silniczek.mapa.DrzwiMapa;
import app.silniczek.mapa.DymMapa;
import app.silniczek.mapa.ElementyMapy;
import app.silniczek.mapa.Enemy;
import app.silniczek.mapa.EnemyM;
import app.silniczek.mapa.KamienieMapa;
import app.silniczek.mapa.KolceMapa;
import app.silniczek.mapa.PustaMapa;
import app.silniczek.mapa.TloMapy;
import app.silniczek.mapa.ZewMapa;
import app.silniczek.pociski.Bomba;
import app.silniczek.pociski.Granatnik;
import app.silniczek.pociski.Kula;
import app.silniczek.pociski.Mina;
import app.silniczek.pociski.Miotacz;
import app.silniczek.pociski.Pociski;
import app.silniczek.postac.Player2;
import app.silniczek.tekstury.Tekstury;


/**
 * Created by Pawel on 20.12.14.
 */
public class GlownaKlasa {

    private GL10 gl10;
    private Context context;
    private String ZNACZNIK = "GlownaKlasa";
    private Tekstury tekstury;
    private Granatnik granatnikPlayera;
    private Miotacz flamePlayera ;
    private Kula kulaPlayer;
    private Mina minaPlayera;
    private Bomba bomba;

    private TloMapy tloMapy;
    private ZewMapa zewMapa;
    private DymMapa dymMapa;
    private PustaMapa pustaMapa;

    private Animacja animacjaDymu;

    //private List<GlownaMapa> listaMap = new ArrayList<GlownaMapa>();
    private List<BazaMapa> listaMap = new ArrayList<BazaMapa>();

    public boolean mapaZostalaZmieniona = false;
    private List<ElementyMapy> elementyMapy = new ArrayList<ElementyMapy>();


    private Pociski pociskWroga;
    private Pociski pociskWroga2;
    private Pociski pociskWroga3;

    private EnemyM wrog = null;
    private EnemyM wrog2 = null;
    private EnemyM wrog3 = null;
    private BeczkaMapa2 beczkaMapa2 = null;
    private BeczkaMapa2 beczkaMapa3 = null;

    private Pociski pociskBeczki1;
    private Pociski pociskBeczki2;
    private Pociski pociskBeczki3;

    private Pociski pociskPrzeciwnika;
    private Pociski pociskPrzeciwnika2;
    private Pociski pociskPrzeciwnika3;

    private List<BeczkaMapa2> beczkaMapa2List = new ArrayList<>();

    public GlownaKlasa(GL10 gl10, Context context, List<ElementyMapy> elementyMapies) {

        //tworzenieMapy(elementyMapies);
        //elementyMapy.addAll(elementyMapies);
        //tworzenieElementowMapy(elementyMapy);

        this.gl10 = gl10;
        this.context = context;

        tekstury = new Tekstury(gl10, context);
        granatnikPlayera = new Granatnik(0.03f, 0.03f, tekstury.teksturaGranat);
        flamePlayera = new Miotacz(0.2f, 0.1f, tekstury.teksturaFlame);
        kulaPlayer = new Kula(0.03f, 0.03f, tekstury.teksturaPocisk);
        minaPlayera = new Mina(0.07f, 0.07f, tekstury.teksturaMiny);
        bomba = new Bomba(0.1f, 0.1f, tekstury.teksturaMiny, tekstury.teksturaWybuch2);


        tloMapy = new TloMapy(gl10);

        tworzenieElementowMapy(elementyMapies);
    }

    public void tworzenieGry(Player2 player){
        //player.poruszanie(gl10, tekstury.teksturaPlayera);\
       //player.zaladowanie(gl10, tekstury.teksturaBomberMan);

        player.zaladowanie2(gl10, tekstury.teksturaBomberMan1,
                                  tekstury.teksturaBomberMan2,
                                  tekstury.teksturaBomberMan3);
        //player.poruszanie();

        granatnikPlayera.wystrzel(gl10, player.getBANK_POSITION_PLAYER_Y(), player.getBANK_POSITION_PLAYER_X(), player.isShot_1());
        kulaPlayer.wystrzel(gl10, player.getBANK_POSITION_PLAYER_Y(), player.getBANK_POSITION_PLAYER_X(), player.isShot_2());
        flamePlayera.wystrzel(gl10, player.getBANK_POSITION_PLAYER_Y(), player.getBANK_POSITION_PLAYER_X(), player.isShot_3());
        //bomba.wystrzel(gl10, player.getBANK_POSITION_PLAYER_Y(), player.getBANK_POSITION_PLAYER_X(), player.isShot_3());

        //kulaPlayer.wystrzel(gl10, player.getBANK_POSITION_PLAYER_Y(), player.isPLAYER_SHOOT_2());



        animacjaDymu = new Animacja(gl10, tekstury.teksturaDymu);

    }

    public void tworzenieMapy(List<ElementyMapy> elementyMapies){
        elementyMapy.addAll(elementyMapies);

    }


    public void tworzenieElementowMapy(List<ElementyMapy> elementyMapy){

        for (ElementyMapy e: elementyMapy){
            if ("0".equals(e.getElement())){
                listaMap.add(new TloMapy(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaMetal, tekstury.teksturaPeknietyMetal));

            } if ("1".equals(e.getElement())){
                listaMap.add(new ZewMapa(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaCegly, tekstury.teksturaPeknietaCegla));

            } if ("2".equals(e)){

            } if ("D".equals(e.getElement())){

                listaMap.add(new DrzwiMapa(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaDrzwi, tekstury.teksturaDrzwi));
                //listaMap.add(new DymMapa(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaDymu, tekstury.teksturaDymu ));

            } if ("C".equals(e.getElement())){

                listaMap.add(new KamienieMapa(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaMetal, tekstury.teksturaMetal ));

            } if ("K".equals(e.getElement())){

                listaMap.add(new KolceMapa(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaKolce, tekstury.teksturaKolce ));

            } if ("E".equals(e.getElement())){

                Enemy enemyMapa = new Enemy(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaPlayera, tekstury.teksturaPlayera);
                //Pociski pociski = enemyMapa.granatnik(0.03f, 0.03f, tekstury.teksturaGranat);
                //pociskWroga = enemyMapa.miotacz(0.2f, 0.1f, tekstury.teksturaFlame);
                pociskWroga = enemyMapa.kula(0.03f, 0.03f, tekstury.teksturaPocisk);
                enemyMapa.setPociski(pociskWroga);
                listaMap.add(enemyMapa);
            } if ("B".equals(e.getElement())){

                BeczkaMapa beczkaMapa = new BeczkaMapa(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaBeczka, tekstury.teksturaWybuch2);
                pociskWroga2 = beczkaMapa.kula(0.03f, 0.03f, tekstury.teksturaPocisk);
                beczkaMapa.setPociski(pociskWroga2);
                listaMap.add(beczkaMapa);
            }

            if ("X".equals(e)){
                //PustaMapa pustaMapa = new PustaMapa(gl10, e.getKolumna(), e.getWiersz());
                //pustaMapa.tworzenieMapy(tekstury.teksturaPopiol);

            }
            if ("A".equals(e.getElement())){
                wrog = new EnemyM(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaPlayera, tekstury.teksturaPlayera);
                //pociskWroga3 = wrog.kula(0.03f, 0.03f, tekstury.teksturaPocisk);
                //pociskWroga3 = wrog.granatnik(0.03f, 0.03f, tekstury.teksturaGranat);
                pociskPrzeciwnika = wrog.bomba(0.1f, 0.1f, tekstury.teksturaMiny, tekstury.teksturaWybuch2);
                wrog.setPociski(pociskPrzeciwnika);
                listaMap.add(wrog);
            }

            if ("P".equals(e.getElement())){


                beczkaMapa2 = new BeczkaMapa2(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaBeczka, tekstury.teksturaWybuch2);
                pociskBeczki2 = beczkaMapa2.kula(0.03f, 0.03f, tekstury.teksturaPocisk);
                beczkaMapa2.setPociski(pociskBeczki2);
                listaMap.add(beczkaMapa2);

            }

            if ("Z".equals(e.getElement())){

                beczkaMapa3 = new BeczkaMapa2(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaBeczka, tekstury.teksturaWybuch2);
                pociskBeczki3 = beczkaMapa3.kula(0.03f, 0.03f, tekstury.teksturaPocisk);
                beczkaMapa3.setPociski(pociskBeczki3);
                listaMap.add(beczkaMapa3);

            }

            if ("S".equals(e.getElement())){
                wrog2 = new EnemyM(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaPlayera, tekstury.teksturaPlayera);
                //pociskWroga3 = wrog.kula(0.03f, 0.03f, tekstury.teksturaPocisk);
                //pociskWroga3 = wrog.granatnik(0.03f, 0.03f, tekstury.teksturaGranat);
                pociskPrzeciwnika2 = wrog2.bomba(0.1f, 0.1f, tekstury.teksturaMiny, tekstury.teksturaWybuch2);
                wrog2.setPociski(pociskPrzeciwnika2);
                listaMap.add(wrog2);
            }

            if ("F".equals(e.getElement())){
                wrog3 = new EnemyM(gl10, e.getKolumna(), e.getWiersz(), tekstury.teksturaPlayera, tekstury.teksturaPlayera);
                //pociskWroga3 = wrog.kula(0.03f, 0.03f, tekstury.teksturaPocisk);
                //pociskWroga3 = wrog.granatnik(0.03f, 0.03f, tekstury.teksturaGranat);
                pociskPrzeciwnika3 = wrog3.bomba(0.1f, 0.1f, tekstury.teksturaMiny, tekstury.teksturaWybuch2);
                wrog3.setPociski(pociskPrzeciwnika3);
                listaMap.add(wrog3);
            }
        }

    }

    public void tworzenieListyMap(Player2 player){
        //player.poruszanie();

        for(BazaMapa g: listaMap){
            //player.poruszanie();

            //new KolizjaPostacMapa<>(g, player, animacjaDymu);
            new KolizjaPostacMapa2<>(g, player, animacjaDymu);
            //g.tworzenieMapy(player.BANK_POSITION_SIDE_PLAYER);
            g.tworzenieMapy();

            //new KolizjaPociskMapaZAnimacja<>(g, flamePlayera, animacjaDymu);
            //new KolizjaPociskMapaZAnimacja(g, granatnikPlayera, animacjaDymu);
            //new KolizjaPociskMapaZAnimacja(g, kulaPlayer, animacjaDymu);

            new KolizjaPociskMapaZAnimacja2(g, flamePlayera, animacjaDymu, player);
            new KolizjaPociskMapaZAnimacja2(g, granatnikPlayera, animacjaDymu, player);
            new KolizjaPociskMapaZAnimacja2(g, kulaPlayer, animacjaDymu, player);

            //new KolizjaPostacPocisk(player, pociskWroga, animacjaDymu);
            new KolizjaPostacPrzeszkoda(g, player, animacjaDymu);

            new KolizjaEnemyMapa<>(g, beczkaMapa2, animacjaDymu);
            new KolizjaEnemyMapa<>(g, beczkaMapa3, animacjaDymu);


            new KolizjaEnemyMapa2<>(g, wrog, animacjaDymu);
            new KolizjaEnemyMapa2<>(g, wrog2, animacjaDymu);
            new KolizjaEnemyMapa2<>(g, wrog3, animacjaDymu);


            new KolizjaBombaMapa2<>(g, bomba, animacjaDymu, player);
            new KolizjaBombaMapa2<>(g, pociskPrzeciwnika, animacjaDymu, player);
            new KolizjaBombaMapa2<>(g, pociskPrzeciwnika2, animacjaDymu, player);
            new KolizjaBombaMapa2<>(g, pociskPrzeciwnika3, animacjaDymu, player);

            new KolizjaPociskEnemyZAnimacja<>(g, kulaPlayer, animacjaDymu, player, wrog);
            new KolizjaPociskEnemyZAnimacja<>(g, kulaPlayer, animacjaDymu, player, wrog2);
            new KolizjaPociskEnemyZAnimacja<>(g, kulaPlayer, animacjaDymu, player, wrog3);

            new KolizjaPociskEnemyZAnimacja<>(g, flamePlayera, animacjaDymu, player, wrog);
            new KolizjaPociskEnemyZAnimacja<>(g, flamePlayera, animacjaDymu, player, wrog2);
            new KolizjaPociskEnemyZAnimacja<>(g, flamePlayera, animacjaDymu, player, wrog3);

            new KolizjaPociskEnemyZAnimacja<>(g, granatnikPlayera, animacjaDymu, player, wrog);
            new KolizjaPociskEnemyZAnimacja<>(g, granatnikPlayera, animacjaDymu, player, wrog2);
            new KolizjaPociskEnemyZAnimacja<>(g, granatnikPlayera, animacjaDymu, player, wrog3);
            //new KolizjaPostacMapa(g, player, player.getGl10(), player.getTekstura(), animacjaDymu);
            //player.setLocalTranslation(player.getGl10(), player.getTekstura(), k.kolizja(0));


        }
        player.poruszanie();
        //player.setLocalTranslation(player.getGl10(), player.getTekstura(),
         //       player.getBANK_POSITION_PLAYER_X(), player.getBANK_POSITION_PLAYER_Y(), 0);

    }
}


package app.silniczek.tekstury;


import android.content.Context;

import javax.microedition.khronos.opengles.GL10;

import app.silniczek.R;

/**
 * Created by Pawel on 25.10.14.
 */
public class Tekstury {

    private Context context;
    private GL10 gl10;
    private ZaladowanieTekstury teksPLayera = new ZaladowanieTekstury();
    private ZaladowanieTekstury tekstury1 = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksStrzalkiWGore = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksStrzalkiWDol = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksStrzalkiWLewo = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksStrzalkiWPrawo = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksCegly = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksCegly2 = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksPeknietaCegla = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksPocisk = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksDuzyPocisk = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksGranat = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksMetal = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksWybuch = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksWybuch2 = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksPeknietyMetal = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksPopiol = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksFlame = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksMiny = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksDym = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksKolce = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksDrzwi = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksBeczka = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksWrog = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksBomberMan = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksBomberMan1 = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksBomberMan2 = new ZaladowanieTekstury();
    private ZaladowanieTekstury teksBomberMan3 = new ZaladowanieTekstury();


    public int[] teksturaPlayera = new int[1];
    public int[] tekstura1 = new int[1];
    public int[] teksturaStrzalkiWGore = new int[1];
    public int[] teksturaStrzalkiWDol = new int[1];
    public int[] teksturaStrzalkiWLewo = new int[1];
    public int[] teksturaStrzalkiWPrawo = new int[1];
    public int[] teksturaCegly = new int[1];
    public int[] teksturaCegly2 = new int[1];
    public int[] teksturaPeknietaCegla = new int[1];
    public int[] teksturaPocisk = new int[1];
    public int[] teksturaDuzyPocisk = new int[1];
    public int[] teksturaGranat = new int[1];
    public int[] spriteSheets = new int[3];
    public int[] teksturaMetal = new int[1];
    public int[] teksturaWybuch = new int[1];
    public int[] teksturaWybuch2 = new int[1];
    public int[] teksturaPeknietyMetal = new int[1];
    public int[] teksturaPopiol = new int[1];
    public int[] teksturaFlame = new int[1];
    public int[] teksturaMiny = new int[1];
    public int[] teksturaDymu = new int[1];
    public int[] teksturaKolce = new int[1];
    public int[] teksturaDrzwi = new int[1];
    public int[] teksturaBeczka = new int[1];
    public int[] teksturaWrog = new int[1];
    public int[] teksturaBomberMan = new int[1];
    public int[] teksturaBomberMan1 = new int[1];
    public int[] teksturaBomberMan2 = new int[1];
    public int[] teksturaBomberMan3 = new int[1];

    public Tekstury(GL10 gl10, Context context) {
        this.gl10 = gl10;
        this.context = context;

        teksturaPlayera = teksPLayera.zaladujTeksture(gl10, context, R.drawable.ic_launcher);
        tekstura1 = tekstury1.zaladujTeksture(gl10, context, R.drawable.ic_launcher);
        teksturaStrzalkiWGore = teksStrzalkiWGore.zaladujTeksture(gl10, context, R.drawable.strzalka_w_gore);
        teksturaStrzalkiWDol = teksStrzalkiWDol.zaladujTeksture(gl10, context, R.drawable.strzalka_w_dol);
        teksturaStrzalkiWLewo = teksStrzalkiWLewo.zaladujTeksture(gl10, context, R.drawable.strzalka_w_lewo);
        teksturaStrzalkiWPrawo = teksStrzalkiWPrawo.zaladujTeksture(gl10, context, R.drawable.strzalka_w_prawo);
        teksturaCegly = teksCegly.zaladujTeksture(gl10, context, R.drawable.cegla);
        teksturaPocisk = teksPocisk.zaladujTeksture(gl10, context, R.drawable.pocisk);
        teksturaGranat = teksGranat.zaladujTeksture(gl10, context, R.drawable.granat);
        teksturaMetal = teksMetal.zaladujTeksture(gl10, context, R.drawable.metal);
        teksturaWybuch = teksWybuch.zaladujTeksture(gl10, context, R.drawable.wybuch2bez_tla);
        teksturaWybuch2 = teksWybuch2.zaladujTeksture(gl10, context, R.drawable.wybuch);
        teksturaPeknietaCegla = teksPeknietaCegla.zaladujTeksture(gl10, context, R.drawable.kamien);
        teksturaPopiol = teksPopiol.zaladujTeksture(gl10, context, R.drawable.popiol);
        teksturaFlame = teksFlame.zaladujTeksture(gl10, context, R.drawable.flame);
        teksturaMiny = teksMiny.zaladujTeksture(gl10, context, R.drawable.mina);
        teksturaKolce = teksKolce.zaladujTeksture(gl10, context, R.drawable.kolce);
        teksturaDrzwi = teksDrzwi.zaladujTeksture(gl10, context, R.drawable.brama);
        teksturaBeczka = teksBeczka.zaladujTeksture(gl10, context, R.drawable.beczka_metalowa);
        teksturaWrog = teksWrog.zaladujTeksture(gl10, context, R.drawable.client_android);
        teksturaBomberMan = teksBomberMan.zaladujTeksture(gl10, context, R.drawable.bomberman_animacja);
        teksturaBomberMan1 = teksBomberMan1.zaladujTeksture(gl10, context, R.drawable.bomberman_animacja1);
        teksturaBomberMan2 = teksBomberMan2.zaladujTeksture(gl10, context, R.drawable.bomberman_animacja2);
        teksturaBomberMan3 = teksBomberMan3.zaladujTeksture(gl10, context, R.drawable.bomberman_animacja3);

    }


}

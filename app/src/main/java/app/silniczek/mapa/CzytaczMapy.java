package app.silniczek.mapa;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.microedition.khronos.opengles.GL10;

import app.silniczek.R;


/**
 * Created by Pawel on 30.12.14.
 */
public class CzytaczMapy {

    private String ZNACZNIK = "CzytaczMapy : ";
    private Context context;
    private GL10 gl10;
    private List<ElementyMapy> elementyMapies = new ArrayList<ElementyMapy>();

    public CzytaczMapy(GL10 gl10, Context context) {
        this.gl10 = gl10;
        this.context = context;

        try {
            odczytZPliku();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ElementyMapy> getElementyMapies() {
        return elementyMapies;
    }

    private void odczytZPliku() throws IOException {


        String str = "";
        StringBuffer buf = new StringBuffer();
        String s = "";
        int licznikWierszy = 0;
        int licznikKolumn = 0;
        InputStream is = context.getResources().openRawResource(R.drawable.bomberman);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if (is != null){

            while((str = reader.readLine()) != null){
                buf.append(str + "\n");
            }
            s = buf.toString();
        }

        StringTokenizer tokenizer = new StringTokenizer(s);
        String element = "";
        List<String> elementy = new ArrayList<String>();
        //List<ElementyMapy> elementyMapies = new ArrayList<ElementyMapy>();
        while (tokenizer.hasMoreTokens()){

            element = tokenizer.nextToken();
            if ("|".equals(element)){
                licznikWierszy++;
                licznikKolumn = 0;
            }else {
                elementyMapies.add(new ElementyMapy(element, licznikKolumn, licznikWierszy));
                //tworzenieMapy.tworzenieMapy(element, licznikKolumn, licznikWierszy);
                licznikKolumn++;
            }

        }
        //tworzenieMapy.tworzenieMapy(elementyMapies);



        //konwersjaMapy.konwertujMape(elementyMapies);
       // wierszMapy.setElementyMapies(elementyMapies);
        //glownaMapa.setIloscWierszy(licznikWierszy);
        //Log.d(ZNACZNIK, "ilosc Wierszy : " + glownaMapa.getIloscWierszy());
        //glownaMapa.setElementyMapies(elementyMapies);

        for (String e: elementy){

            if (e.equals("|")){
                Log.d(ZNACZNIK, " enter ");
            }else {
                Log.d(ZNACZNIK, " " + e);

            }
        }

        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

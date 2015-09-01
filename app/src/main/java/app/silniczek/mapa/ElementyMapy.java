package app.silniczek.mapa;

/**
 * Created by Pawel on 03.01.15.
 */
public class ElementyMapy {

    private String ZNACZNIK = "ElementyMapy";
    private String element;
    private int kolumna;
    private int wiersz;

    public ElementyMapy(String element, int kolumna, int wiersz) {
        this.element = element;
        this.kolumna = kolumna;
        this.wiersz = wiersz;
    }

    public String getElement() {
        return element;
    }

    public int getKolumna() {
        return kolumna;
    }

    public int getWiersz() {
        return wiersz;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setKolumna(int kolumna) {
        this.kolumna = kolumna;
    }

    public void setWiersz(int wiersz) {
        this.wiersz = wiersz;
    }
}

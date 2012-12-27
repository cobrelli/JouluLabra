package Yksikot;

import java.util.ArrayList;

/**
 * Luokka johon talletetaan useita yksiköitä. Luokalla on erilaisia
 * hallinnollisia metodeja, joilla yksiköitä käsitellään.
 *
 * @author Cobrelli
 */
public class Ryhma {

    private String partyNimi;
    private ArrayList<Yksikko> party;
    private int pisteet;
    private int kokonaisPisteet;

    /**
     * Luokan konstruktori alustaa ArrayListin ja yksikön nimen.
     */
    public Ryhma() {
        this.party = new ArrayList<>();
        this.partyNimi = "";
        this.pisteet = 0;
        this.kokonaisPisteet = 0;
    }

    /**
     * Nimen getteri
     *
     * @return Palauttaa ryhmän nimen.
     */
    public String getNimi() {
        return this.partyNimi;
    }

    /**
     * Nimen setteri
     *
     * @param nimi Asettaa ryhmän nimen.
     */
    public void setNimi(String nimi) {
        this.partyNimi = nimi;
    }

    /**
     * Lisaa uuden yksikön arraylistiin.
     *
     * @param hahmo Liittaa lisattavan CharClass olion arraylistiin.
     */
    public void lisaaHahmo(Yksikko hahmo) {
        this.party.add(hahmo);
    }

    /**
     * Poistaa halutun yksikön arraylististä. Esimerkiksi kuollessa.
     *
     * @param hahmo Poistaa parametrinä annetun CharClass olion arraylististä
     */
    public void poistaHahmo(Yksikko hahmo) {
        this.party.remove(hahmo);
    }

    /**
     * Palauttaa arraylistin
     *
     * @return Palauttaa viitteen arraylistiin.
     */
    public ArrayList<Yksikko> palautaHahmot() {
        return this.party;
    }

    /**
     * Tulostaa kaikki arraylistin sisältämät CharClass oliot.
     */
    public void tulostaHahmot() {
        for (Yksikko c : party) {
            System.out.println(c);
        }
    }

    /**
     * Tarkistaa onko arraylist tyhjä. Esimerkiksi taistelun aika jos kaikki
     * hahmot ovat kuolleet on arraylist tyhjä.
     *
     * @return Palauttaa true jos tyhjä, false jos ei.
     */
    public boolean isEmpty() {
        if (party.isEmpty()) {
            return true;
        }
        return false;
    }

    public void alustaKaikkienHP() {
        for (Yksikko y : party) {
            y.alustaStatsit();
        }
    }

    public int getKokonaisPisteet() {
        return this.kokonaisPisteet;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void lisaaPisteita(int maara) {
        this.pisteet += maara;
        this.kokonaisPisteet += maara;
    }

    public void vahennaPisteita(int maara) {
        this.pisteet -= maara;
    }

    public boolean riittaako(int maara) {
        return this.pisteet - maara >= 0;
    }
}

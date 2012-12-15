package CharClass;

import java.util.ArrayList;

/**
 * Luokka johon talletetaan useita yksiköitä. Luokalla on erilaisia
 * hallinnollisia metodeja, joilla yksiköitä käsitellään.
 *
 * @author Cobrelli
 */
public class CharParty {

    private String partyNimi;
    private ArrayList<CharClass> party;

    /**
     * Luokan konstruktori alustaa ArrayListin ja yksikön nimen.
     */
    public CharParty() {
        this.party = new ArrayList<>();
        this.partyNimi = "";
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
    public void lisaaHahmo(CharClass hahmo) {
        this.party.add(hahmo);
    }

    /**
     * Poistaa halutun yksikön arraylististä. Esimerkiksi kuollessa.
     *
     * @param hahmo Poistaa parametrinä annetun CharClass olion arraylististä
     */
    public void poistaHahmo(CharClass hahmo) {
        this.party.remove(hahmo);
    }

    /**
     * Palauttaa arraylistin
     *
     * @return Palauttaa viitteen arraylistiin.
     */
    public ArrayList<CharClass> palautaHahmot() {
        return this.party;
    }

    /**
     * Tulostaa kaikki arraylistin sisältämät CharClass oliot.
     */
    public void tulostaHahmot() {
        for (CharClass c : party) {
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
}

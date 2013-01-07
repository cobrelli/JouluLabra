package Sovelluslogiikka;

import Peli.Peli;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Yksikko;

/**
 * Luokka jonka tehtävänä on hallinnoida pelaajayksiköiden ja hirviöiden vuoroa.
 *
 * @author vito
 */
public class Vuoro {

    private Ryhma ryhma;
    private int indeksi;
    private Yksikko nykyinen;
    private AI ai;
    private HirvioRyhma hirvioRyhma;
    Peli peli;

    /**
     * Konstruktori, alustaa kaikki tarvittavat oliot ja attribuutit.
     *
     * @param ryhma Antaa viitteen pelaajan yksiköt sisältävään oliosäiliöön.
     * @param hirvioRyhma Antaa viitteen hirviöt sisältävään oliosäiliöön.
     * @param peli Antaa viitteen peli olioon.
     */
    public Vuoro(Ryhma ryhma, HirvioRyhma hirvioRyhma, Peli peli) {
        this.ryhma = ryhma;
        this.indeksi = 0;
        this.nykyinen = ryhma.palautaHahmot().get(this.indeksi);
        this.hirvioRyhma = hirvioRyhma;
        this.ai = new AI(ryhma, hirvioRyhma);
        this.peli = peli;
    }

    /**
     * Getteri
     *
     * @return Palauttaa viitteen nykyisen vuoron omaavaan hahmoon.
     */
    public Yksikko getVuoro() {
        return this.nykyinen;
    }

    /**
     * Getteri
     *
     * @return Palauttaa nykyisen vuoron indeksiarvon.
     */
    public int getIndeksi() {
        return this.indeksi;
    }

    /**
     * Getteri
     *
     * @return Palauttaa pelaajan ryhmän koon.
     */
    public int getKoko() {
        return this.ryhma.palautaHahmot().size();
    }

    /**
     * Antaa vuoron seuraavalle pelaajalle tai jos pelaajan kaikki ovat
     * liikkuneet antaa vuoron hirviöille ja kutsuu AI:tä tekemään siirtoja.
     * Hallinnoi myös tilanteita joissa pelaajien ryhmä tai hirviöiden ryhmä on
     * tyhjä. Jos pelaajan ryhmä on tyhjä on peli päättynyt ja siirrytään
     * tulosten esittämisruutuun, jos taas hirviöryhmä on tyhjä siirrytään
     * seuraavalle tasolle.
     */
    public void seuraavaVuoro() {
        if (ryhma.isEmpty()) {
            peli.tulosRuutu();
            return;
        }

        if (hirvioRyhma.palautaMosat().isEmpty()) {
            peli.seuraavaTaso();
            return;
        }

        this.indeksi++;

        if (this.indeksi > getKoko() - 1) {
//            System.out.println("vaihto");
            ai.liikuKohtiLahinta();
            this.indeksi = 0;
        }
        if (ryhma.isEmpty()) {
            peli.tulosRuutu();
            return;
        }

        nykyinen = this.ryhma.palautaHahmot().get(this.indeksi);
    }
}

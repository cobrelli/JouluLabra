package Viholliset;

import java.util.ArrayList;

/**
 * Luokka jonka tehtävänä on tallentaa ja hallinnoida kaikkia lisättyjä Hirvio
 * olioita.
 *
 * @author Cobrelli
 */
public class HirvioRyhma {

    /**
     * hirviöRyhma sisältää viitteen käytössä olevaan ArrayListiin, johon Hirvio
     * oliot talletetaan.
     */
    private ArrayList<Hirvio> hirvioRyhma;

    /**
     * Konstruktori alustaa tyhjän ArrayListin hirvio olioiden lisäämistä
     * varten.
     */
    public HirvioRyhma() {
        this.hirvioRyhma = new ArrayList<>();
    }

    /**
     * Lisää luokan sisältämään ArrayListiin uuden monster olion.
     *
     * @param mosa Parametrinä annettu monster olio lisätään arraylistiin.
     */
    public void lisaaMosa(Hirvio mosa) {
        if (hirvioRyhma.size() > 105) {
            return;
        }
        this.hirvioRyhma.add(mosa);
    }

    /**
     * Poistaa halutun monster olion ArrayLististä.
     *
     * @param mosa Parametrinä annettu monster poistetaan Arraylististä.
     */
    public void poistaMosa(Hirvio mosa) {
        this.hirvioRyhma.remove(mosa);
    }

    /**
     * Palauttaa luokan sisältämän ArrayListin.
     *
     * @return Palauttaa viitteen ArrayListiin.
     */
    public ArrayList<Hirvio> palautaMosat() {
        return this.hirvioRyhma;
    }

    /**
     * Tulostaa kaikki luokan sisältämät hirvio oliot.
     */
    public void tulostaMosat() {
        for (Hirvio m : hirvioRyhma) {
            System.out.println(m);
        }
    }
}

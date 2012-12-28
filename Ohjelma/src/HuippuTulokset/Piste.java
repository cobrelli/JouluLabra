package HuippuTulokset;

import java.io.Serializable;

/**
 * Yksittäinen huipputuloksiin talletettava piste olio, joka sisältää yhden
 * pelikerran pisteet ja pelaajan nimen.
 *
 * @author vito
 */
public class Piste implements Serializable, Comparable<Piste> {

    private String nimi;
    private int pisteet;

    /**
     * Konstruktori, alustaa kaikki luokan tarvitsemat attribuutit.
     *
     * @param nimi Kertoo pelaajan nimen.
     * @param pisteet Kertoo pelaajan saamat pisteet.
     */
    public Piste(String nimi, int pisteet) {
        this.nimi = nimi;
        this.pisteet = pisteet;
    }

    /**
     * Getteri
     *
     * @return Palauttaa pelaajan saamat pisteet.
     */
    public int getPisteet() {
        return this.pisteet;
    }

    /**
     * Getteri
     *
     * @return Palauttaa pelaajan nimen.
     */
    public String getNimi() {
        return this.nimi;
    }

    @Override
    public int compareTo(Piste p) {
        return ((Integer) p.getPisteet()).compareTo(getPisteet());
    }
}

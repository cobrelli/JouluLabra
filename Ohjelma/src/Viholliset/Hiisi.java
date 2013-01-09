package Viholliset;

/**
 * Hirviöiden aliluokka hiisi.
 *
 * @author vito
 */
public class Hiisi extends Hirvio {

    /**
     * Konstruktori, joka alustaa uuden Hiisi olion.
     *
     * @param nimi Kertoo hirviön nimen.
     */
    public Hiisi(String nimi) {
        super(nimi);
        setHpMax(25);
        setMonsterClassID("Hiisi");
        alustaStatsit();
        setPalkkio(3);
        setVahinko(10);
        setKuvanSijainti("Kuvat/hiisi.png");
    }
}

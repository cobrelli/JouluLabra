package Yksikot;

/**
 * Hahmojen yksikön aliluokka Nostoväki.
 *
 * @author vito
 */
public class Nostovaki extends Yksikko {

    /**
     * Konstruktori, alustaa uuden Nostoväki olion.
     *
     * @param nimi Kertoo yksikön nimen.
     */
    public Nostovaki(String nimi) {
        super(nimi);
        setHpMax(30);
        setVahinko(5);
        setCharClassID("Nostovaki");
        alustaStatsit();
    }
}

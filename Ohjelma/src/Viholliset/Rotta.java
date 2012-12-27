package Viholliset;

/**
 * Monsterin aliluokka Rat
 * @author Cobrelli
 */
public class Rotta extends Hirvio{
    
    /**
     * Konstruktori luo uuden Rat olion, jolla haluttu nimi ja konstruktorissa
     * Määrätyt attribuutit.
     * @param nimi      Asettaa oliolle halutun nimen.
     */
    public Rotta(String nimi) {
        super(nimi);
        setHpMax(5);
        setMonsterClassID("Rat");
        alustaStatsit();
        setPalkkio(1);
        setVahinko(3);
    }
}

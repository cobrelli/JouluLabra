
package Yksikot;

/**
 * Aliluokka Fighter
 * 
 * @author Cobrelli
 */
public class Soturi extends Yksikko{
    
    /**
     * Konstruktori luo uuden Soturin. 
     * @param nimi      Luo uuden fighterin halutulla nimellä.
     */
    public Soturi(String nimi){
        super(nimi);
        setHpMax(85);
        setCharClassID("Soturi");
        alustaStatsit();
        setVahinko(10);
        setKuvanSijainti("Kuvat/soturi.png");
    }
}

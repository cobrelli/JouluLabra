
package Yksikot;

/**
 * Aliluokka Fighter
 * 
 * @author Cobrelli
 */
public class Soturi extends Yksikko{
    
    /**
     * Konstruktori luo uuden Fighterin. Luokka tulee sisältämään enemmän tälle
     * hahmotyypille tyypillisiä eroja suhteessa toisiin hahmoluokkiin.
     * @param nimi      Luo uuden fighterin halutulla nimellä.
     */
    public Soturi(String nimi){
        super(nimi);
        setHpMax(100);
        setCharClassID("Soturi");
        alustaStatsit();
    }
    
}


package CharClass;

/**
 * Aliluokka Fighter
 * 
 * @author Cobrelli
 */
public class Fighter extends CharClass{
    
    /**
     * Konstruktori luo uuden Fighterin
     * @param nimi      Luo uuden fighterin halutulla nimellä.
     */
    public Fighter(String nimi){
        super(nimi);
        setHpMax(100);
        setMpMax(0);
        setCharClassID("Fighter");
        alustaStatsit();
    }
    
}

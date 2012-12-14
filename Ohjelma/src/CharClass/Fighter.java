
package CharClass;

/**
 *
 * @author Cobrelli
 */
public class Fighter extends CharClass{
    
    /**
     *
     * @param nimi
     */
    public Fighter(String nimi){
        super(nimi);
        setHpMax(100);
        setMpMax(0);
        setCharClassID("Fighter");
        alustaStatsit();
    }
    
}

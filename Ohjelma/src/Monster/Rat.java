package Monster;

/**
 * Monsterin aliluokka Rat
 * @author Cobrelli
 */
public class Rat extends Monster{
    
    /**
     * Konstruktori luo uuden Rat olion, jolla haluttu nimi ja konstruktorissa
     * Määrätyt attribuutit.
     * @param nimi      Asettaa oliolle halutun nimen.
     */
    public Rat(String nimi) {
        super(nimi);
        setHpMax(5);
        setMonsterClassID("Rat");
        alustaStatsit();
    }
}

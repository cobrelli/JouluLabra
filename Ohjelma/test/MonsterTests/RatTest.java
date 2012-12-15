package MonsterTests;

import Monster.Rat;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Rat aliluokan testi luokka
 * @author Cobrelli
 */
public class RatTest {
    
    Rat rat;
    
    /**
     * Konstruktori
     */
    public RatTest() {
    }
        
    /**
     * Asettaa globaalin Rat olion testaamista varten.
     */
    @Before
    public void setUp() {
        rat = new Rat("rat-dummy");
    }
    
    /**
     * Tarkistaa että MonsterClassID palautuu oikein
     */
    @Test
    public void testaaEttaMonsterClassIDAnnetaanOikein(){
        assertEquals("Rat", rat.getMonsterClassID());
    }
}

package MonsterTests;

import Viholliset.Rotta;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Rat aliluokan testi luokka
 * @author Cobrelli
 */
public class RatTest {
    
    Rotta rat;
    
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
        rat = new Rotta("rat-dummy");
    }
    
    /**
     * Tarkistaa että MonsterClassID palautuu oikein
     */
    @Test
    public void testaaEttaMonsterClassIDAnnetaanOikein(){
        assertEquals("Rat", rat.getMonsterClassID());
    }
}

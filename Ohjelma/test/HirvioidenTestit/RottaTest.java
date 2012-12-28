package HirvioidenTestit;

import Viholliset.Rotta;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Rotta aliluokan testit
 * @author Cobrelli
 */
public class RottaTest {
    
    Rotta rotta;
    
    /**
     * Konstruktori
     */
    public RottaTest() {
    }
        
    /**
     * Asettaa globaalin Rotta olion testaamista varten.
     */
    @Before
    public void setUp() {
        rotta = new Rotta("rat-dummy");
    }
    
    /**
     * Tarkistaa että MonsterClassID palautuu oikein
     */
    @Test
    public void testaaEttaMonsterClassIDAnnetaanOikein(){
        assertEquals("Rotta", rotta.getMonsterClassID());
    }
}

package CharClassTests;

import Yksikot.Soturi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testaa aliluokkaa Fighter. Suurin osa tämän käyttämistä metodeista on testattu
 * jo yliluokan testeissä.
 * @author Cobrelli
 */
public class FighterTest {
    
    Soturi fighter;
    
    /**
     * Konstruktori
     */
    public FighterTest() {
    }

    /**
     * Asettaa käsiteltävän yksikön globaalisti.
     */
    @Before
    public void setUp() {
        fighter = new Soturi("testi");
    }

    /**
     * Testaa että CharClass palautuu oikein.
     */
    @Test
    public void testPalauttaaOikeanCharClassID(){
        assertEquals("Fighter", fighter.getCharClassID());
    }
    
}

package YksikoidenTestit;

import Yksikot.Soturi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testaa aliluokkaa Soturi. Suurin osa tämän käyttämistä metodeista on testattu
 * jo yliluokan testeissä.
 *
 * @author Cobrelli
 */
public class SoturiTest {

    Soturi soturi;

    /**
     * Konstruktori
     */
    public SoturiTest() {
    }

    /**
     * Asettaa käsiteltävän yksikön globaalisti.
     */
    @Before
    public void setUp() {
        soturi = new Soturi("testi");
    }

    /**
     * Testaa että Yksikön ID palautuu oikein.
     */
    @Test
    public void testPalauttaaOikeanCharClassID() {
        assertEquals("Soturi", soturi.getCharClassID());
    }
}

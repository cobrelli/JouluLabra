package HirvioidenTestit;

import Viholliset.HirvioRyhma;
import Viholliset.Rotta;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class HirvioRyhmaTest {

    HirvioRyhma m;
    Rotta r;

    /**
     *
     */
    public HirvioRyhmaTest() {
    }

    /**
     * Pistää pystyyn testattavan alkutilanteen ja alustaa oliot.
     */
    @Before
    public void setUp() {
        m = new HirvioRyhma();
        r = new Rotta("Rat");
    }

    /**
     * Testaa että annettu Hirvio lisätään oikeasti
     */
    @Test
    public void testaaEttaLisattyHirvioLoytyy() {
        m.lisaaMosa(r);
        assertTrue(m.palautaMosat().contains(r));
    }
    
    /**
     * Testaa että luokkaan voidaan lisätä useita olioita.
     */
    @Test
    public void testaaEttaUseanLisaysOnnistuu(){
        int maara = 5;
        for(int i = 0;i<maara;i++){
            m.lisaaMosa(new Rotta("Rat"));
        }
        assertEquals(5, m.palautaMosat().size());
    }

    /**
     * Testaa että poistettava olio poistuu oikeasti.
     */
    @Test
    public void testaaEttaPoistettavaMonsterPoistuu() {
        m.lisaaMosa(r);
        m.poistaMosa(r);
        assertFalse(m.palautaMosat().contains(r));
    }
}

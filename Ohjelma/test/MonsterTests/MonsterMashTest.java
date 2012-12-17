/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterTests;

import Monster.MonsterMash;
import Monster.Rat;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class MonsterMashTest {

    MonsterMash m;
    Rat r;

    public MonsterMashTest() {
    }

    @Before
    public void setUp() {
        m = new MonsterMash();
        r = new Rat("Rat");
    }

    /**
     * Testaa että annettu Monster lisätään oikeasti
     */
    @Test
    public void testaaEttaLisattyMonsterLoytyy() {
        m.lisaaMosa(r);
        assertTrue(m.palautaMosat().contains(r));
    }
    
    @Test
    public void testaaEttaUseanLisaysOnnistuu(){
        int maara = 5;
        for(int i = 0;i<maara;i++){
            m.lisaaMosa(new Rat("Rat"));
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

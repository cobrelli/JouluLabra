/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CharClassTests;

import CharClass.CharParty;
import CharClass.Fighter;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class CharPartyTest {

    CharParty p;

    public CharPartyTest() {
    }

    @Before
    public void setUp() {
        p = new CharParty();
    }

    @Test
    public void testaaEttaSetteriMuuttaaNimenOikein() {
        p.setNimi("k");

        assertEquals("k", p.getNimi());
    }
    
    @Test
    public void testaaEttaLisattyCharClassLisataanArrayListiin(){
        Fighter f = new Fighter("F");
        p.lisaaHahmo(f);
        assertTrue(p.palautaHahmot().contains(f));
    }
    
    @Test
    public void testaaEttaPoistettavaCharClassPoistuuArrayListista(){
        Fighter f = new Fighter("F");
        p.lisaaHahmo(f);
        p.poistaHahmo(f);
        assertFalse(p.palautaHahmot().contains(f));
    }
    
    @Test
    public void testaaEttaPalauttaaTyhjanJosTyhja(){
        assertTrue(p.isEmpty());
    }
    
    @Test
    public void TestaaEttaPalauttaaFalseJosEiTyhja(){
        p.lisaaHahmo(new Fighter("testi"));
        assertFalse(p.isEmpty());
    }
}

package CharClassTests;

import CharClass.CharParty;
import CharClass.Fighter;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Yksikköjä hallinnoivan luokan testejä.
 * @author Cobrelli
 */
public class CharPartyTest {

    CharParty p;

    /**
     * Konstruktori
     */
    public CharPartyTest() {
    }

    /**
     * Asettaa uuden globaalin CharParty olion.
     */
    @Before
    public void setUp() {
        p = new CharParty();
    }

    /**
     * Testaa että setterillä voidaan muuttaa nimi oikein.
     */
    @Test
    public void testaaEttaSetteriMuuttaaNimenOikein() {
        p.setNimi("k");

        assertEquals("k", p.getNimi());
    }
    
    /**
     * Testaa että annettu CharClass menee oikeasti arraylistiin
     */
    @Test
    public void testaaEttaLisattyCharClassLisataanArrayListiin(){
        Fighter f = new Fighter("F");
        p.lisaaHahmo(f);
        assertTrue(p.palautaHahmot().contains(f));
    }
    
    /**
     * Testaa että CharClass saadaan poistettua listalta.
     */
    @Test
    public void testaaEttaPoistettavaCharClassPoistuuArrayListista(){
        Fighter f = new Fighter("F");
        p.lisaaHahmo(f);
        p.poistaHahmo(f);
        assertFalse(p.palautaHahmot().contains(f));
    }
    
    /**
     * Testaa että jos lista on tyhjä palautetaan true.
     */
    @Test
    public void testaaEttaPalauttaaTyhjanJosTyhja(){
        assertTrue(p.isEmpty());
    }
    
    /**
     * Testaa että jos lista ei ole tyhjä palautetaan false.
     */
    @Test
    public void TestaaEttaPalauttaaFalseJosEiTyhja(){
        p.lisaaHahmo(new Fighter("testi"));
        assertFalse(p.isEmpty());
    }
}

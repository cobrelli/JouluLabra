package CharClassTests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import CharClass.Fighter;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testaa aliluokkaa Fighter
 * @author Cobrelli
 */
public class FighterTest {
    
    Fighter fighter;
    
    /**
     * 
     */
    public FighterTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        fighter = new Fighter("testi");
    }

    /**
     *
     */
    @Test
    public void testPalauttaaOikeanCharClassID(){
        assertEquals("Fighter", fighter.getCharClassID());
    }
    
}

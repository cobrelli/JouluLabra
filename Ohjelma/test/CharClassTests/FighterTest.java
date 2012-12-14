package CharClassTests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import CharClass.Fighter;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class FighterTest {
    
    Fighter fighter;
    
    public FighterTest() {
    }

    @Before
    public void setUp() {
        
    }

    @Test
    public void test(){
        fighter = new Fighter("testi");
    }
    
}

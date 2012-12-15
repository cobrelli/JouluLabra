package MonsterTests;

import Monster.Rat;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class RatTest {
    
    Rat rat;
    
    /**
     *
     */
    public RatTest() {
    }
        
    /**
     *
     */
    @Before
    public void setUp() {
        rat = new Rat("rat-dummy");
    }
    
    /**
     *
     */
    @Test
    public void testaaEttaMonsterClassIDAnnetaanOikein(){
        assertEquals("Rat", rat.getMonsterClassID());
    }
}

package HirvioidenTestit;

import Viholliset.Hiisi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vito
 */
public class HiisiTest {
    
    Hiisi hiisi;
    
    public HiisiTest() {
    }
    
    @Before
    public void setUp() {
        hiisi = new Hiisi("");
    }
    
    @Test
    public void testaaEttaMonsterClassIDAnnetaanOikein(){
        assertEquals("Hiisi", hiisi.getMonsterClassID());
    }
}

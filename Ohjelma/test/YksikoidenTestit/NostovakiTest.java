package YksikoidenTestit;

import Yksikot.Nostovaki;
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
public class NostovakiTest {
    
    Nostovaki nostovaki;
    
    public NostovakiTest() {
    }
    
    @Before
    public void setUp() {
        nostovaki = new Nostovaki("");
    }

    @Test
    public void testPalauttaaOikeanCharClassID() {
        assertEquals("Nostovaki", nostovaki.getCharClassID());
    }

}

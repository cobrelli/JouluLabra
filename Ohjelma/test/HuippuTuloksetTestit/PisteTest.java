package HuippuTuloksetTestit;

import HuippuTulokset.Piste;
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
public class PisteTest {
    
    Piste piste;
    
    public PisteTest() {
    }
    
    @Before
    public void setUp() {
        piste = new Piste("esa", 3);
    }
    
     @Test
     public void testaaEttaAsetettuPistePalauttaaOikeanNimen() {
         assertEquals("esa", piste.getNimi());
     }
     
     @Test
     public void testaaEttaAsetettuPistePalauttaaPisteetOikein(){
         assertEquals(3, piste.getPisteet());
     }
}

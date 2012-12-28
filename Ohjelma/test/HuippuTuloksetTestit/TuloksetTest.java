package HuippuTuloksetTestit;

import HuippuTulokset.Piste;
import HuippuTulokset.Tulokset;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author vito
 */
public class TuloksetTest {
    
    Tulokset tulokset;
    
    public TuloksetTest() {
    }
    
    @Before
    public void setUp() {
        tulokset = new Tulokset();
    }
    
    @Test
    public void testaaEttaTuloksetPalautuvat() {
        assertFalse(tulokset.palautaPisteet().isEmpty());
    }
    
    @Test
    public void testaaEttaTulostenTallettaminenOnnistuu(){
        boolean loytyy = false;
        tulokset.lisaaPiste("testi-esa", 0);
        for (Piste p : tulokset.palautaPisteet()) {
            if(p.getNimi().equals("testi-esa")){
                loytyy = true;
            }
        }
        assertTrue(loytyy);
    }
}

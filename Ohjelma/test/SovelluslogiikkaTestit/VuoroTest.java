package SovelluslogiikkaTestit;

import Peli.Peli;
import Sovelluslogiikka.Vuoro;
import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Viholliset.Rotta;
import Yksikot.Ryhma;
import Yksikot.Soturi;
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
public class VuoroTest {

    Vuoro vuoro;
    Peli peli;
    HirvioRyhma hirvioRyhma;
    Ryhma ryhma;

    public VuoroTest() {
    }

    @Before
    public void setUp() {
        this.peli = new Peli();
        this.hirvioRyhma = new HirvioRyhma();
        Rotta rotta = new Rotta("");
        hirvioRyhma.lisaaMosa(rotta);
        rotta.setX(451);
        rotta.setY(451);
        
        this.ryhma = new Ryhma();
        Soturi soturi = new Soturi("");
        ryhma.lisaaHahmo(soturi);
        soturi.setX(101);
        soturi.setY(101);
        
        Soturi soturi2 = new Soturi("");
        ryhma.lisaaHahmo(soturi2);
        soturi2.setX(126);
        soturi2.setY(126);
        
        this.vuoro = new Vuoro(ryhma, hirvioRyhma, peli);
    }
    
    @Test
    public void testaaEttaKunVuorotEivatOleAlkaneetVuoroOnEkalla(){
        assertEquals(0, vuoro.getIndeksi());
    }
    
    @Test
    public void testaaEttaKunEiVielaLiikuttuPalautetaanOikeaOlio(){
        assertEquals(vuoro.getVuoro(), ryhma.palautaHahmot().get(0));
    }
    
    @Test
    public void testaaEttaVuoroSiirtyyOikeinSeuraavalle(){
        vuoro.seuraavaVuoro();
        assertEquals(1, vuoro.getIndeksi());
    }
    
    @Test
    public void testaaEttaKunLiikuttuKerranPalautetaanOikeaOlio(){
        vuoro.seuraavaVuoro();
        assertEquals(vuoro.getVuoro(), ryhma.palautaHahmot().get(1));
    }
    
    @Test
    public void testaaEttaVuoroSiirtyyOikeinAlkuunKunKaikkiLiikkuneet(){
        vuoro.seuraavaVuoro();
        vuoro.seuraavaVuoro();
        assertEquals(0, vuoro.getIndeksi());
    }
    
    @Test
    public void testaaEttaHirvioLiikkuuKunPelaajatLiikkuneet(){
        vuoro.seuraavaVuoro();
        vuoro.seuraavaVuoro();
        assertEquals(426, hirvioRyhma.palautaMosat().get(0).getX());
        assertEquals(426, hirvioRyhma.palautaMosat().get(0).getY());
    }
}

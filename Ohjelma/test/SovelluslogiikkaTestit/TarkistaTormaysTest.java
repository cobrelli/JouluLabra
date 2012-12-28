package SovelluslogiikkaTestit;

import Sovelluslogiikka.TarkistaTormays;
import Viholliset.Hiisi;
import Viholliset.HirvioRyhma;
import Viholliset.Rotta;
import Yksikot.Ryhma;
import Yksikot.Soturi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author vito
 */
public class TarkistaTormaysTest {

    TarkistaTormays tormays;
    HirvioRyhma hirvioRyhma;
    Ryhma ryhma;

    public TarkistaTormaysTest() {
    }

    @Before
    public void setUp() {
        this.ryhma = new Ryhma();
        Soturi soturi = new Soturi("");
        ryhma.lisaaHahmo(soturi);
        soturi.setX(101);
        soturi.setY(101);

        this.hirvioRyhma = new HirvioRyhma();
        Rotta rotta = new Rotta("");
        hirvioRyhma.lisaaMosa(rotta);
        rotta.setX(451);
        rotta.setY(451);

        Hiisi hiisi = new Hiisi("");
        hirvioRyhma.lisaaMosa(hiisi);
        hiisi.setX(301);
        hiisi.setY(301);

        this.tormays = new TarkistaTormays(ryhma, hirvioRyhma);
    }

    @Test
    public void testaaEttaPalautetaanFalseJosEiTormaa() {
        assertFalse(tormays.tarkistaTormaako(126, 126, 5));
    }

    @Test
    public void testaaEttaPalautetaanTrueJosTormataanPelaajaan() {
        assertTrue(tormays.tarkistaTormaako(101, 101, 100));
    }

    @Test
    public void testaaEttaPalautetaanTrueJosTormataanHirvioon() {
        assertTrue(tormays.tarkistaTormaako(301, 301, 10));
    }

    @Test
    public void testaaEttaHirvioltaVaheneeKestotJosSiihenTormataan() {
        tormays.tarkistaTormaako(301, 301, 10);
        assertEquals(hirvioRyhma.palautaMosat().get(1).getHpMax() - 10,
                hirvioRyhma.palautaMosat().get(1).getHp());
    }
    
    @Test
    public void testaaEttaHirvioPoistetaanRyhmastaJosSenKestotMeneeNolliin(){
        tormays.tarkistaTormaako(451, 451, 100);
        assertEquals(hirvioRyhma.palautaMosat().size(), 1);
    }
}

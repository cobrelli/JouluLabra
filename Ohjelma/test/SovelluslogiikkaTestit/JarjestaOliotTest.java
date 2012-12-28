package SovelluslogiikkaTestit;

import Sovelluslogiikka.JarjestaOliot;
import Viholliset.Hiisi;
import Viholliset.HirvioRyhma;
import Viholliset.Rotta;
import Yksikot.Nostovaki;
import Yksikot.Ryhma;
import Yksikot.Soturi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author vito
 */
public class JarjestaOliotTest {

    JarjestaOliot jarjestys;
    HirvioRyhma hirvioRyhma;
    Ryhma ryhma;

    public JarjestaOliotTest() {
    }

    @Before
    public void setUp() {
        hirvioRyhma = new HirvioRyhma();
        Rotta rotta = new Rotta("");
        hirvioRyhma.lisaaMosa(rotta);

        ryhma = new Ryhma();
        Soturi soturi = new Soturi("");
        ryhma.lisaaHahmo(soturi);

        jarjestys = new JarjestaOliot(hirvioRyhma, ryhma);
        jarjestys.jarjesta();
    }

    @Test
    public void testaaEttaJarjestamatonPelaajaYksikkoAsetetaanRuudulle() {
        assertEquals(101, ryhma.palautaHahmot().get(0).getX());
        assertEquals(101, ryhma.palautaHahmot().get(0).getY());
    }

    @Test
    public void testaaEttaJarjestamatonVihollisYksikkoAsetetaanRuudulle() {
        assertEquals(451, hirvioRyhma.palautaMosat().get(0).getX());
        assertEquals(101, hirvioRyhma.palautaMosat().get(0).getY());
    }

    @Test
    public void testaaEttaSuurellaMaarallaYksikoitaSiirrytäänViereiselleRiville() {
        for (int i = 0; i < 16; i++) {
            ryhma.lisaaHahmo(new Nostovaki(""));
        }
        jarjestys.jarjesta();

        assertEquals(126, ryhma.palautaHahmot().get(15).getX());
        assertEquals(101, ryhma.palautaHahmot().get(15).getY());
    }

    @Test
    public void testaaEttaSuurellaMaarallaVihollisYksikoitaSiirrytäänViereiselleRiville() {
        for (int i = 0; i < 16; i++) {
            hirvioRyhma.lisaaMosa(new Hiisi(""));
        }
        jarjestys.jarjesta();

        assertEquals(426, hirvioRyhma.palautaMosat().get(15).getX());
        assertEquals(101, hirvioRyhma.palautaMosat().get(15).getY());
    }
}

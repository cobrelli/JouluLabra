package YksikoidenTestit;

import Yksikot.Soturi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testaa YksikkoLuokkaa
 *
 * @author Cobrelli
 */
public class YksikkoTest {

    Soturi soturi;

    /**
     * Yksikko luokan konstruktori.
     */
    public YksikkoTest() {
    }

    /**
     * Pistää tarvittavat esitilanteet pystyyn.
     */
    @Before
    public void setUp() {
        soturi = new Soturi("testi");
    }

    /**
     * Tarkistaa setterin toimivuuden
     */
    @Test
    public void testaaEttaSetXAsettaaPaikanOikein() {
        soturi.setX(5);
        assertEquals(5, soturi.getX());
    }

    /**
     * Tarkistaa setterin toimivuuden
     */
    @Test
    public void testaaEttaSetYAsettaaPaikanOikein() {
        soturi.setY(5);
        assertEquals(5, soturi.getY());
    }

    /**
     * Alustusmetodi muuttaa nykyiseksi hp:ksi max hp:n oikein.
     */
    @Test
    public void testaaAlustusAsettaaHpOikein() {
        soturi.setHpMax(99);
        soturi.alustaStatsit();
        assertEquals(99, soturi.getHp());
    }

    /**
     * Hahmolta vahennettava hp laskee oikein hp arvoa.
     */
    @Test
    public void testaaEttaHpVaheneeOikeasti() {
        int arvo = soturi.getHp();

        soturi.vahennaHp(30);
        assertEquals(arvo - 30, soturi.getHp());
    }

    /**
     * Testaa että jos yksikön hp on laskenut alle nollan ei se enää lisätessä
     * kasva.
     */
    @Test
    public void testaaEttaAlleNollanVahenevaHpEiPalauduPlussalle() {
        soturi.vahennaHp((soturi.getHp() + 20));
        soturi.lisaaHp(30);

        assertEquals(-1, soturi.getHp());
    }

    /**
     * Hahmolle lisätty hp nostaa hp arvoa oikein
     */
    @Test
    public void testaaEttaLisattyHpKasvattaaOikeastiMaaraa() {
        soturi.vahennaHp(50);
        int arvo = soturi.getHp();

        soturi.lisaaHp(10);

        assertEquals(arvo + 10, soturi.getHp());
    }

    /**
     * Hpmax setterin testaus
     */
    @Test
    public void testaaEttaSetteriMuuttaaMaxHp() {
        soturi.setHpMax(10);
        assertEquals(10, soturi.getHpMax());
    }

    /**
     * Elossa olevalle hahmolle palautetaan boolean elossa oikein.
     */
    @Test
    public void getteriPalauttaaElossaOikein() {
        assertTrue(soturi.getIsAlive());
    }

    /**
     * Jos hp laskee alle nollan niin hahmo muuttuu kuolleeksi niin kuin pitää.
     */
    @Test
    public void HpnLaskuAlleNollaMuuttaaKuolleeksi() {
        soturi.vahennaHp(100000);
        assertFalse(soturi.getIsAlive());
    }

    /**
     * Jos hahmo kuolee ei lisää hp herätä sitä henkiin.
     */
    @Test
    public void HpnLaskuAlleNollaMuuttaaKuolleeksiEikaHpNousuHerataHenkiin() {
        soturi.vahennaHp(100000);
        soturi.lisaaHp(100000);
        assertFalse(soturi.getIsAlive());
    }
    
    @Test
    public void testaaEttaSetVahinkoAsettaaVahingonOikein(){
        soturi.setVahinko(20);
        assertEquals(20, soturi.getVahinko());
    }
}

package HirvioidenTestit;

import Viholliset.Rotta;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class HirvioTest {

    Rotta rotta;

    /**
     *
     */
    public HirvioTest() {
    }

    /**
     * Pistää testaustilanteen pystyyn ja alustaa käytettävät oliot.
     */
    @Before
    public void setUp() {
        rotta = new Rotta("rat-dummy");
    }

    /**
     * Tarkistaa setterin toimivuuden
     */
    @Test
    public void testaaEttaSetXAsettaaPaikanOikein() {
        rotta.setX(5);
        assertEquals(5, rotta.getX());
    }

    /**
     * Tarkistaa setterin toimivuuden
     */
    @Test
    public void testaaEttaSetYAsettaaPaikanOikein() {
        rotta.setY(5);
        assertEquals(5, rotta.getY());
    }

    /**
     * Alustusmetodi muuttaa nykyiseksi hp:ksi max hp:n oikein.
     */
    @Test
    public void testaaAlustusAsettaaHpOikein() {
        rotta.setHpMax(9);
        rotta.alustaStatsit();
        assertEquals(9, rotta.getHp());
    }

    /**
     * Hahmolta vahennettava hp laskee oikein hp arvoa.
     */
    @Test
    public void testaaEttaHpVaheneeOikeasti() {
        int arvo = rotta.getHp();

        rotta.vahennaHp(3);
        assertEquals(arvo - 3, rotta.getHp());
    }

    /**
     * Testaa että jos yksikön hp on laskenut alle nollan ei se enää lisätessä
     * kasva.
     */
    @Test
    public void testaaEttaAlleNollanVahenevaHpEiPalauduPlussalle() {
        rotta.vahennaHp((rotta.getHp() + 20));
        rotta.lisaaHp(30);

        assertEquals(-1, rotta.getHp());
    }

    /**
     * Hahmolle lisätty hp nostaa hp arvoa oikein
     */
    @Test
    public void testaaEttaLisattyHpKasvattaaOikeastiMaaraa() {
        rotta.vahennaHp(3);
        int arvo = rotta.getHp();

        rotta.lisaaHp(1);

        assertEquals(arvo + 1, rotta.getHp());
    }

    /**
     * Hpmax setterin testaus
     */
    @Test
    public void testaaEttaSetteriMuuttaaMaxHp() {
        rotta.setHpMax(10);
        assertEquals(10, rotta.getHpMax());
    }

    /**
     * Elossa olevalle hahmolle palautetaan boolean elossa oikein.
     */
    @Test
    public void getteriPalauttaaElossaOikein() {
        assertTrue(rotta.isAlive());
    }

    /**
     * Jos hp laskee alle nollan niin hahmo muuttuu kuolleeksi niin kuin pitää.
     */
    @Test
    public void HpnLaskuAlleNollaMuuttaaKuolleeksi() {
        rotta.vahennaHp(100000);
        assertFalse(rotta.isAlive());
    }

    /**
     * Jos hahmo kuolee ei lisää hp herätä sitä henkiin.
     */
    @Test
    public void HpnLaskuAlleNollaMuuttaaKuolleeksiEikaHpNousuHerataHenkiin() {
        rotta.vahennaHp(100000);
        rotta.lisaaHp(100000);
        assertFalse(rotta.isAlive());
    }

    @Test
    public void testaaEttaVahingonAsettaminenToimiiOikein() {
        rotta.setVahinko(20);
        assertEquals(20, rotta.getVahinko());
    }

    @Test
    public void testaaEttaPalkkionAsettaminenToimiiOikein() {
        rotta.setPalkkio(20);
        assertEquals(20, rotta.getPalkkio());
    }
}

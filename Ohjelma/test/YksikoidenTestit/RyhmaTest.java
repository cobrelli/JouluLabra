package YksikoidenTestit;

import Yksikot.Nostovaki;
import Yksikot.Ryhma;
import Yksikot.Soturi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Yksikköjä hallinnoivan luokan testejä.
 *
 * @author Cobrelli
 */
public class RyhmaTest {

    Ryhma p;

    /**
     * Konstruktori
     */
    public RyhmaTest() {
    }

    /**
     * Asettaa uuden globaalin CharParty olion.
     */
    @Before
    public void setUp() {
        p = new Ryhma();
    }

    /**
     * Testaa että setterillä voidaan muuttaa nimi oikein.
     */
    @Test
    public void testaaEttaSetteriMuuttaaNimenOikein() {
        p.setNimi("k");

        assertEquals("k", p.getNimi());
    }

    /**
     * Testaa että annettu CharClass menee oikeasti arraylistiin
     */
    @Test
    public void testaaEttaLisattyCharClassLisataanArrayListiin() {
        Soturi f = new Soturi("F");
        p.lisaaHahmo(f);
        assertTrue(p.palautaHahmot().contains(f));
    }

    /**
     * Testaa että luokkaan voidaan lisätä useita olioita.
     */
    @Test
    public void testaaEttaUseammanLisaysOnnistuu() {
        int maara = 5;

        for (int i = 0; i < maara; i++) {
            p.lisaaHahmo(new Soturi("eki"));
        }
        assertEquals(maara, p.palautaHahmot().size());
    }

    /**
     * Testaa että CharClass saadaan poistettua listalta.
     */
    @Test
    public void testaaEttaPoistettavaCharClassPoistuuArrayListista() {
        Soturi f = new Soturi("F");
        p.lisaaHahmo(f);
        p.poistaHahmo(f);
        assertFalse(p.palautaHahmot().contains(f));
    }

    /**
     * Testaa että jos lista on tyhjä palautetaan true.
     */
    @Test
    public void testaaEttaPalauttaaTyhjanJosTyhja() {
        assertTrue(p.isEmpty());
    }

    /**
     * Testaa että jos lista ei ole tyhjä palautetaan false.
     */
    @Test
    public void TestaaEttaPalauttaaFalseJosEiTyhja() {
        p.lisaaHahmo(new Soturi("testi"));
        assertFalse(p.isEmpty());
    }

    @Test
    public void testaaEttaRiittavyydenTarkastusPalauttaaFalseJosEiRiita() {
        assertFalse(p.riittaako(10));
    }

    @Test
    public void testaaEttaRiittavyydenTarkastusPalauttaaTrueJosRiittaa() {
        p.lisaaPisteita(20);
        assertTrue(p.riittaako(10));
    }

    @Test
    public void testaaEttaPisteitaLisataanOikein() {
        p.lisaaPisteita(20);
        assertEquals(20, p.getPisteet());
    }

    @Test
    public void testaaEttaPisteetVahenevatOikein() {
        p.lisaaPisteita(20);
        p.vahennaPisteita(10);
        assertEquals(10, p.getPisteet());
    }

    @Test
    public void testaaEtteivatKokonaispisteetVahene() {
        p.lisaaPisteita(20);
        p.vahennaPisteita(10);
        assertEquals(20, p.getKokonaisPisteet());
    }

    @Test
    public void testaaEttaAlustusNostaaYksiköidenHpnMaksimiin() {
        p.lisaaHahmo(new Nostovaki(""));
        p.palautaHahmot().get(0).vahennaHp(30);
        p.alustaKaikkienHP();
        assertEquals(p.palautaHahmot().get(0).getHpMax(), p.palautaHahmot().get(0).getHp());

    }
}

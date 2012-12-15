package CharClassTests;

import CharClass.Fighter;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Testaa CharClassLuokkaa
 * @author Cobrelli
 */
public class CharClassTest {
    
    Fighter fighter;
    
    /**
     *
     */
    public CharClassTest() {
    }
    
    /**
     * Pistää tarvittavat esitilanteet pystyyn.
     */
    @Before
    public void setUp() {
        fighter = new Fighter("testi");
    }
    
    /**
     * Tarkistaa setterin toimivuuden
     */
    @Test
    public void testaaEttaSetXAsettaaPaikanOikein(){
        fighter.setX(5);
        assertEquals(5, fighter.getX());
    }
    
    /**
     * Tarkistaa setterin toimivuuden
     */
    @Test
    public void testaaEttaSetYAsettaaPaikanOikein(){
        fighter.setY(5);
        assertEquals(5, fighter.getY());
    }
    
    /**
     * Alustusmetodi muuttaa nykyiseksi hp:ksi max hp:n oikein.
     */
    @Test
    public void testaaAlustusAsettaaHpOikein(){
        fighter.setHpMax(99);
        fighter.alustaStatsit();
        assertEquals(99, fighter.getHp());
    }
    
    /**
     * Hahmolta vahennettava hp laskee oikein hp arvoa.
     */
    @Test 
    public void testaaEttaHpVaheneeOikeasti(){
        int arvo = fighter.getHp();
        
        fighter.vahennaHp(30);
        assertEquals(arvo-30, fighter.getHp());
    }
    
    /**
     * Testaa että jos yksikön hp on laskenut alle nollan ei se enää lisätessä
     * kasva.
     */
    @Test
    public void testaaEttaAlleNollanVahenevaHpEiPalauduPlussalle(){
        fighter.vahennaHp((fighter.getHp()+20));
        fighter.lisaaHp(30);
        
        assertEquals(-1, fighter.getHp());
    }
    
    /**
     * Hahmolle lisätty hp nostaa hp arvoa oikein
     */
    @Test
    public void testaaEttaLisattyHpKasvattaaOikeastiMaaraa(){
        fighter.vahennaHp(50);
        int arvo = fighter.getHp();
        
        fighter.lisaaHp(10);
        
        assertEquals(arvo+10, fighter.getHp());
    }
    
    /**
     * Hpmax setterin testaus
     */
    @Test
    public void testaaEttaSetteriMuuttaaMaxHp(){
        fighter.setHpMax(10);
        assertEquals(10, fighter.getHpMax());
    }
    
    /**
     * Elossa olevalle hahmolle palautetaan boolean elossa oikein.
     */
    @Test
    public void getteriPalauttaaElossaOikein(){
        assertTrue(fighter.getIsAlive());
    }
    
    /**
     * Jos hp laskee alle nollan niin hahmo muuttuu kuolleeksi niin kuin pitää.
     */
    @Test
    public void HpnLaskuAlleNollaMuuttaaKuolleeksi(){
        fighter.vahennaHp(100000);
        assertFalse(fighter.getIsAlive());
    }
    
    /**
     * Jos hahmo kuolee ei lisää hp herätä sitä henkiin.
     */
    @Test
    public void HpnLaskuAlleNollaMuuttaaKuolleeksiEikaHpNousuHerataHenkiin(){
        fighter.vahennaHp(100000);
        fighter.lisaaHp(100000);
        assertFalse(fighter.getIsAlive());
    }
}

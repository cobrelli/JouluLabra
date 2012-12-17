/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MonsterTests;

import Monster.Rat;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class MonsterTest {
    
    Rat rat;
    
    /**
     *
     */
    public MonsterTest() {
    }
        
    /**
     * Pistää testaustilanteen pystyyn ja alustaa käytettävät oliot.
     */
    @Before
    public void setUp() {
        rat = new Rat("rat-dummy");
    }
    
    /**
     * Tarkistaa setterin toimivuuden
     */
    @Test
    public void testaaEttaSetXAsettaaPaikanOikein(){
        rat.setX(5);
        assertEquals(5, rat.getX());
    }
    
    /**
     * Tarkistaa setterin toimivuuden
     */
    @Test
    public void testaaEttaSetYAsettaaPaikanOikein(){
        rat.setY(5);
        assertEquals(5, rat.getY());
    }
    
    /**
     * Alustusmetodi muuttaa nykyiseksi hp:ksi max hp:n oikein.
     */
    @Test
    public void testaaAlustusAsettaaHpOikein(){
        rat.setHpMax(9);
        rat.alustaStatsit();
        assertEquals(9, rat.getHp());
    }
    
    /**
     * Hahmolta vahennettava hp laskee oikein hp arvoa.
     */
    @Test 
    public void testaaEttaHpVaheneeOikeasti(){
        int arvo = rat.getHp();
        
        rat.vahennaHp(3);
        assertEquals(arvo-3, rat.getHp());
    }
    
    /**
     * Testaa että jos yksikön hp on laskenut alle nollan ei se enää lisätessä
     * kasva.
     */
    @Test
    public void testaaEttaAlleNollanVahenevaHpEiPalauduPlussalle(){
        rat.vahennaHp((rat.getHp()+20));
        rat.lisaaHp(30);
        
        assertEquals(-1, rat.getHp());
    }
    
    /**
     * Hahmolle lisätty hp nostaa hp arvoa oikein
     */
    @Test
    public void testaaEttaLisattyHpKasvattaaOikeastiMaaraa(){
        rat.vahennaHp(3);
        int arvo = rat.getHp();
        
        rat.lisaaHp(1);
        
        assertEquals(arvo+1, rat.getHp());
    }
    
    /**
     * Hpmax setterin testaus
     */
    @Test
    public void testaaEttaSetteriMuuttaaMaxHp(){
        rat.setHpMax(10);
        assertEquals(10, rat.getHpMax());
    }
    
    /**
     * Elossa olevalle hahmolle palautetaan boolean elossa oikein.
     */
    @Test
    public void getteriPalauttaaElossaOikein(){
        assertTrue(rat.isAlive());
    }
    
    /**
     * Jos hp laskee alle nollan niin hahmo muuttuu kuolleeksi niin kuin pitää.
     */
    @Test
    public void HpnLaskuAlleNollaMuuttaaKuolleeksi(){
        rat.vahennaHp(100000);
        assertFalse(rat.isAlive());
    }
    
    /**
     * Jos hahmo kuolee ei lisää hp herätä sitä henkiin.
     */
    @Test
    public void HpnLaskuAlleNollaMuuttaaKuolleeksiEikaHpNousuHerataHenkiin(){
        rat.vahennaHp(100000);
        rat.lisaaHp(100000);
        assertFalse(rat.isAlive());
    }
}

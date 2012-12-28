package SovelluslogiikkaTestit;

import Sovelluslogiikka.AI;
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
public class AITest {
    
    AI ai;
    HirvioRyhma hirvioRyhma;
    Ryhma ryhma;
    Soturi soturi;
    Rotta rotta;
    
    public AITest() {
    }
    
    @Before
    public void setUp() {
        this.ryhma = new Ryhma();
        this.hirvioRyhma = new HirvioRyhma();
        
        soturi = new Soturi("testi-esa");
        ryhma.lisaaHahmo(soturi);
        soturi.setX(101);
        soturi.setY(101);
        soturi.setHpMax(20);
        ryhma.alustaKaikkienHP();
        
        rotta = new Rotta("testi-rotta");
        hirvioRyhma.lisaaMosa(rotta);
        rotta.setX(201);
        rotta.setY(201);
        rotta.setVahinko(10);
        
        this.ai = new AI(ryhma, hirvioRyhma);
    }
    
    @Test
    public void testaaEttaHirvioLiikkuuOikeinKohtiPelaajaa(){
        ai.liikuKohtiLahinta();
        assertEquals(176, rotta.getX());
        assertEquals(176, rotta.getY());
    }
    
    @Test
    public void testaaEttaHirvioHyokkaaViereisenHahmonKimppuun(){
        rotta.setX(126);
        rotta.setY(126);
        ai.liikuKohtiLahinta();
        assertEquals(10, soturi.getHp());
    }
  
    @Test
    public void testaaEttaLahinValitaanOikeinKahdestaHahmosta(){
        Soturi tokaSoturi = new Soturi("kauimmainen");
        tokaSoturi.setX(401);
        tokaSoturi.setY(401);
        ai.liikuKohtiLahinta();
        assertEquals(176, rotta.getX());
        assertEquals(176, rotta.getY());
    }
}

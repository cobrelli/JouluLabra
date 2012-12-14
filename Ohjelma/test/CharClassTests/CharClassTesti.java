package CharClassTests;

import CharClass.Fighter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * 
 * @author Cobrelli
 */
public class CharClassTesti {
    
    Fighter fighter;
    
    public CharClassTesti() {
    }
    
    @Before
    public void setUp() {
        fighter = new Fighter("testi");
    }
    
    @Test
    public void testaaEttaSetXAsettaaPaikanOikein(){
        fighter.setX(5);
        assertEquals(5, fighter.getX());
    }
    
    @Test
    public void testaaEttaSetYAsettaaPaikanOikein(){
        fighter.setY(5);
        assertEquals(5, fighter.getY());
    }
    
    @Test
    public void testaaAlustusAsettaaHpOikein(){
        fighter.setHpMax(99);
        fighter.alustaStatsit();
        assertEquals(99, fighter.getHp());
    }
    
    @Test
    public void testaaAlustusAsettaaMpOikein(){
        fighter.setMpMax(99);
        fighter.alustaStatsit();
        assertEquals(99, fighter.getMp());
    }
    
    @Test 
    public void testaaEttaHpVaheneeOikeasti(){
        int arvo = fighter.getHp();
        
        fighter.vahennaHp(30);
        assertEquals(arvo-30, fighter.getHp());
    }
    
    @Test
    public void testaaEttaLisattyHpKasvattaaOikeastiMaaraa(){
        fighter.vahennaHp(50);
        int arvo = fighter.getHp();
        
        fighter.lisaaHp(10);
        
        assertEquals(arvo+10, fighter.getHp());
    }
}

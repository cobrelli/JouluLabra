
package Main;

import CharClass.CharParty;
import CharClass.Fighter;
import GUI.GUI;
import Monster.MonsterMash;
import Monster.Rat;

/**
 *
 * @author Cobrelli
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Fighter eka = new Fighter("eka");
        Fighter toka = new Fighter("toka");
        
        CharParty p = new CharParty();
        
        p.lisaaHahmo(eka);
        p.lisaaHahmo(toka);
        
        eka.setX(101);
        eka.setY(101);
        
        toka.setX(126);
        toka.setY(126);
        
        Rat r = new Rat("rat");
        
        MonsterMash m = new MonsterMash();
        m.lisaaMosa(r);
        
        r.setX(401);
        r.setY(401);
//        System.out.println(eka.getHp());
        
//        p.tulostaHahmot();
        
        GUI gui = new GUI(m, p);
        gui.run();
        
        
    }
}

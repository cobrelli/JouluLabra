
package Main;

import Yksikot.Ryhma;
import Yksikot.Soturi;
import GUI.GUI;
import Viholliset.HirvioRyhma;
import Viholliset.Rotta;

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

        Soturi eka = new Soturi("eka");
        Soturi toka = new Soturi("toka");
        
        Ryhma p = new Ryhma();
        
        p.lisaaHahmo(eka);
        p.lisaaHahmo(toka);
        
        eka.setX(101);
        eka.setY(101);
        
        toka.setX(126);
        toka.setY(126);
        
        Rotta r = new Rotta("rat");
        
        HirvioRyhma m = new HirvioRyhma();
        m.lisaaMosa(r);
        
        r.setX(401);
        r.setY(401);
//        System.out.println(eka.getHp());
        
//        p.tulostaHahmot();
        
        GUI gui = new GUI(m, p);
        gui.run();
        
        
    }
}

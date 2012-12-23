
package Main;

import GUI.GUI;
import Viholliset.HirvioRyhma;
import Viholliset.Rotta;
import Yksikot.Ryhma;
import Yksikot.Soturi;

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
        
//        eka.setX(101);
//        eka.setY(101);
//        
//        toka.setX(126);
//        toka.setY(126);
//        
        Rotta r = new Rotta("rat");
        
        HirvioRyhma m = new HirvioRyhma();
        m.lisaaMosa(r);
        
//        r.setX(401);
//        r.setY(401);

        Rotta r2 = new Rotta("rotta");
        r2.setX(301);
//        r2.setY(401);
//        r2.setY(401);
        m.lisaaMosa(r2);
        
        Rotta r3 = new Rotta("rotta");
//        r3.setX(301);
//        r3.setY(301);
        m.lisaaMosa(r3);
        r.setHpMax(120);
        
        GUI gui = new GUI(m, p);
        gui.run();
        
        
    }
}

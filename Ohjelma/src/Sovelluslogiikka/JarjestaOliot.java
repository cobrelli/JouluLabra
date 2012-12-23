package Sovelluslogiikka;

import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Yksikko;

/**
 *
 * @author vito
 */
public class JarjestaOliot {

    HirvioRyhma hirviot;
    Ryhma ryhma;

    public JarjestaOliot(HirvioRyhma hirviot, Ryhma ryhma) {
        this.hirviot = hirviot;
        this.ryhma = ryhma;
    }

    public void jarjesta() {

        int x = 101;
        int y = 101;

        for (Yksikko yks : ryhma.palautaHahmot()) {
            if(y>475){
                x+=25;
                y=101;
            }
            yks.setX(x);
            yks.setY(y);
            y+=25;
        }

        x = 451;
        y = 101;
        
        for (Hirvio h : hirviot.palautaMosat()) {
           if(y>475){
               x-=25;
               y=101;
           } 
           h.setX(x);
           h.setY(y);
           y+=25;
        }
        
    }
}

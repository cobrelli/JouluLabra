package Sovelluslogiikka;

import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Yksikko;

/**
 *
 * @author vito
 */
public class TarkistaTormays {

    Ryhma ryhma;
    HirvioRyhma vihollisRyhma;
    Vuoro vuoro;

    public TarkistaTormays(Ryhma Ryhma, HirvioRyhma vihollisRyhma, Vuoro vuoro) {
        this.ryhma = Ryhma;
        this.vihollisRyhma = vihollisRyhma;
        this.vuoro = vuoro;
    }

    public boolean tarkistaTormaako(int x, int y, int vahinko) {
        for (Yksikko cha : ryhma.palautaHahmot()) {
            if (cha.getX() == x && cha.getY() == y) {
                return true;
            }
        }

        Hirvio kuoleva;

        for (Hirvio m : vihollisRyhma.palautaMosat()) {
            if (m.getX() == x && m.getY() == y) {
                m.vahennaHp(vahinko);

                if (!m.isAlive()) {
                    kuoleva = m;
                    ryhma.lisaaPisteita(m.getPalkkio());
                    vihollisRyhma.poistaMosa(kuoleva);
//                    vuoro.seuraavaVuoro();
                    return true;
                }
//                System.out.println("sattuuuuuuu!");
//                vuoro.seuraavaVuoro();
                return true;
            }
        }
       return false;
    }
}
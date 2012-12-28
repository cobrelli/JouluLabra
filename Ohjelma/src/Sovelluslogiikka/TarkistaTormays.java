package Sovelluslogiikka;

import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Yksikko;

/**
 * Luokka tarkistaa törmääkö kysytyllä siirrolla pelaajan yksikkö mihinkään.
 *
 * @author vito
 */
public class TarkistaTormays {

    Ryhma ryhma;
    HirvioRyhma vihollisRyhma;
//    Vuoro vuoro;

    /**
     * Konstruktori.
     * @param Ryhma Antaa viitteen pelaajan oliot sisältävään oliosäiliöön.
     * @param vihollisRyhma Antaa viitteen hirviöt sisältävään oliosäiliöön.
     * @param vuoro Antaa viitteen 
     */
    public TarkistaTormays(Ryhma Ryhma, HirvioRyhma vihollisRyhma) {
        this.ryhma = Ryhma;
        this.vihollisRyhma = vihollisRyhma;
//        this.vuoro = vuoro;
    }

    /**
     *
     * @param x
     * @param y
     * @param vahinko
     * @return
     */
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
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
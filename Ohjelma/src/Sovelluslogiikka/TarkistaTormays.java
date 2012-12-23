/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Yksikot.Yksikko;
import Yksikot.Ryhma;
import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;

/**
 *
 * @author vito
 */
public class TarkistaTormays {

    Ryhma party;
    HirvioRyhma mash;
    Vuoro vuoro;

    public TarkistaTormays(Ryhma party, HirvioRyhma mash, Vuoro vuoro) {
        this.party = party;
        this.mash = mash;
        this.vuoro = vuoro;
    }

    public boolean tarkistaTormaako(int x, int y) {
        for (Yksikko cha : party.palautaHahmot()) {
            if (cha.getX() == x && cha.getY() == y) {
                return true;
            }
        }


        Hirvio kuoleva;

        for (Hirvio m : mash.palautaMosat()) {
            if (m.getX() == x && m.getY() == y) {
                m.vahennaHp(10);

                if (!m.isAlive()) {
                    kuoleva = m;
                    mash.poistaMosa(kuoleva);
                    vuoro.seuraavaVuoro();
                    return true;
                }

                System.out.println("sattuuuuuuu!");
                vuoro.seuraavaVuoro();
                return true;
            }

        }

        return false;
    }
}

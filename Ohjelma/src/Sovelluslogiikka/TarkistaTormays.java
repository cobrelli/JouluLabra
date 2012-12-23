/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import CharClass.CharClass;
import CharClass.CharParty;
import Monster.MonsterMash;

/**
 *
 * @author vito
 */
public class TarkistaTormays {

    CharParty party;
    MonsterMash mash;

    public TarkistaTormays(CharParty party, MonsterMash mash) {
        this.party = party;
        this.mash = mash;
    }

    public boolean tarkistaTormaako(int x, int y) {
        for (CharClass cha : party.palautaHahmot()) {
            if (cha.getX() == x && cha.getY() == y) {
                return true;
            }
        }

        return false;
    }
}

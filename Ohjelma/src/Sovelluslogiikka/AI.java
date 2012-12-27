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
public class AI {

    Ryhma party;
    HirvioRyhma hirviot;

    public AI(Ryhma party, HirvioRyhma mash) {
        this.party = party;
        this.hirviot = mash;
    }

    //lasketaan jokaiselle monsterille lähin hahmo ja liikutaan sitä kohti
    public void liikuKohtiLahinta() {

        for (Hirvio m : hirviot.palautaMosat()) {
            Yksikko lahin = null;
            int lahinP = Integer.MAX_VALUE;
            int lahinX = Integer.MAX_VALUE;
            int lahinY = Integer.MAX_VALUE;

            //lasketaan lähin y ja x koordinaattien perusteella
            for (Yksikko c : party.palautaHahmot()) {
                int x = c.getX() - m.getX();
                if (x < 0) {
                    x *= -1;
                }
                int y = c.getY() - m.getY();
                if (y < 0) {
                    y *= -1;
                }
                if (x + y < lahinP) {
                    lahin = c;
                    lahinP = x + y;
                    lahinX = x;
                    lahinY = y;
                }
            }
//            System.out.println(lahin);
            //kulkee koordinaattien mukaisesti kohti lähintä
            if (lahinX == lahinY && lahin.getX() > m.getX() && lahin.getY() > m.getY()) {
                liikuJosValidi(m, m.getY() + 25, m.getX() + 25);
            } else if (lahinX == lahinY && lahin.getX() < m.getX() && lahin.getY() < m.getY()) {
                liikuJosValidi(m, m.getY() - 25, m.getX() - 25);
            } else if (lahinX == lahinY && lahin.getY() > m.getY() && lahin.getX() < m.getX()) {
                liikuJosValidi(m, m.getY() + 25, m.getX() - 25);
            } else if (lahinX == lahinY && lahin.getX() > m.getX() && lahin.getY() < m.getY()) {
                liikuJosValidi(m, m.getY() - 25, m.getX() + 25);
            } else if (lahinX < lahinY && lahin.getY() > m.getY()) {
                liikuJosValidi(m, m.getY() + 25, m.getX());
            } else if (lahinX < lahinY && lahin.getY() < m.getY()) {
                liikuJosValidi(m, m.getY()-25, m.getX());
            } else if (lahinX > lahinY && lahin.getX() > m.getX()) {
                liikuJosValidi(m, m.getY(), m.getX()+25);
            } else if (lahinX > lahinY && lahin.getX() < m.getX()) {
                liikuJosValidi(m, m.getY(), m.getX()-25);
            }
        }
    }

    public boolean tormaako(Hirvio mo, int x, int y) {

        for (Yksikko ch : party.palautaHahmot()) {
            if (x == ch.getX() && y == ch.getY()) {
                System.out.println("Die infidel!");
                ch.vahennaHp(mo.getVahinko());
                System.out.println(ch);
                if (!ch.getIsAlive()) {
                    party.poistaHahmo(ch);
                }
                if (party.isEmpty()) {
                    System.out.println("GAME OVER");
                    System.exit(0);
                }
                return true;
            }
        }
        for (Hirvio mon : hirviot.palautaMosat()) {
            if (x == mon.getX() && y == mon.getY()) {
                return true;
            }
        }
        return false;
    }

    public void liikuJosValidi(Hirvio m, int y, int x) {
        if (tormaako(m, x, y)) {
        } else {
            m.setX(x);
            m.setY(y);
        }
    }
}

package Sovelluslogiikka;

import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Yksikko;

/**
 * Luokka sisältää hirviöiden toiminnan logiikkaa.
 *
 * @author vito
 */
public class AI {

    Ryhma party;
    HirvioRyhma hirviot;

    /**
     * Konstruktori, luo uuden tekoäly olion, jolle annetaan tieto pelaajan
     * yksiköistä ja hirviöyksiköistä.
     *
     * @param ryhma Sisältää viitteen pelaajan yksiköt sisältävään oliosäiliöön.
     * @param hirvioRyhma Sisältää viitteet hirviöt sisältävään oliosäiliöön.
     */
    public AI(Ryhma ryhma, HirvioRyhma hirvioRyhma) {
        this.party = ryhma;
        this.hirviot = hirvioRyhma;
    }

    /**
     * Metodin avulla lasketaan jokaiselle monsterille lähin hahmo ja liikutaan
     * sitä kohti.
     */
    public void liikuKohtiLahinta() {

        for (Hirvio m : hirviot.palautaMosat()) {
            Yksikko lahin = null;
            int lahinP = Integer.MAX_VALUE;
            int lahinX = Integer.MAX_VALUE;
            int lahinY = Integer.MAX_VALUE;

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
            if (party.palautaHahmot().isEmpty()) {
                return;
            }
            tarkistaLiikkuminen(lahinX, lahinY, lahin, m);
        }
    }

    /**
     * Tarkistaa törmääkö vihollinen pelaajan johonkin yksikköön, jos törmää
     * niin vähentää hahmon osumapisteitä, jos osumapisteet laskevat nollaan tai
     * alle niin hahmo merkitään kuolleeksi ja poistetaan. Jos törmää johonkin
     * toiseen vihollisyksikköön palautetaan true.
     *
     * @param hirvio Antaa viitteen käsiteltävään hirviöön.
     * @param x Kertoo tarkasteltavan paikan sijainnin x -akselilla.
     * @param y Kertoo tarkasteltavan paikan sijainnin y -akselilla.
     * @return Palauttaa true jos törmää johonkin ja palauttaa false jos ei.
     */
    private boolean tormaako(Hirvio hirvio, int x, int y) {

        for (Yksikko ch : party.palautaHahmot()) {
            if (x == ch.getX() && y == ch.getY()) {
//                System.out.println("Die infidel!");
                ch.vahennaHp(hirvio.getVahinko());
//                System.out.println(ch);
                if (!ch.getIsAlive()) {
                    party.poistaHahmo(ch);
                }
                if (party.isEmpty()) {
                    break;
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

    /**
     * Tarkistaa annetun paikan tormaako metodilta ja liikkuu jossei mihinkään
     * törmätä.
     *
     * @param m Antaa viitteen käsiteltävään hirviö olioon.
     * @param y Kertoo tarkasteltavan paikan sijainnin y -akselilla.
     * @param x Kertoo tarkasteltavan paikan sijainnin x -akselilla.
     */
    private void liikuJosValidi(Hirvio m, int y, int x) {
        if (tormaako(m, x, y)) {
        } else {
            m.setX(x);
            m.setY(y);
        }
    }

    /**
     * Apumetodi jonka tehtävänä on kutsua kaikki mahdolliset tavat liikkua. AI
     * siirtää hirviötä siihen suuntaan missä sijaitsee lähin pelaajan yksikkö.
     * Kun se on löydetty kutsutaan liiku jos validi metodia.
     *
     * @param lahinX Kertoo lähimmän yksikön x akselilla.
     * @param lahinY Kertoo lähimmän yksikön y akselilla.
     * @param lahin Kertoo lähimmän Yksikko olion.
     * @param m kertoo käsiteltävän Hirvio olion.
     */
    private void tarkistaLiikkuminen(int lahinX, int lahinY, Yksikko lahin, Hirvio m) {
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
            liikuJosValidi(m, m.getY() - 25, m.getX());
        } else if (lahinX > lahinY && lahin.getX() > m.getX()) {
            liikuJosValidi(m, m.getY(), m.getX() + 25);
        } else if (lahinX > lahinY && lahin.getX() < m.getX()) {
            liikuJosValidi(m, m.getY(), m.getX() - 25);
        }
    }
}

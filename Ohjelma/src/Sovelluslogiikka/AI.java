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

    /**
     * hirviot sisältää viitteen Hirvioita sisältävään olio sailioon.
     *
     * ryhma sisältää viitteen pelaajan yksiköitä sisältävään olio sailioon.
     */
    Ryhma ryhma;
    HirvioRyhma hirviot;

    /**
     * Konstruktori, luo uuden tekoäly olion, jolle annetaan tieto pelaajan
     * yksiköistä ja hirviöyksiköistä.
     *
     * @param ryhma Sisältää viitteen pelaajan yksiköt sisältävään oliosäiliöön.
     * @param hirvioRyhma Sisältää viitteet hirviöt sisältävään oliosäiliöön.
     */
    public AI(Ryhma ryhma, HirvioRyhma hirvioRyhma) {
        this.ryhma = ryhma;
        this.hirviot = hirvioRyhma;
    }

    /**
     * Metodin avulla lasketaan jokaiselle monsterille lähin hahmo ja liikutaan
     * sitä kohti. Aloittaa lähimpää kohtaan liikkumisen käymällä yksitellen
     * jokaisen hirviön läpi ja kutsuu etsiLahin metodia, joka etsii lähimmän
     * pelaajan yksikön ja kutsuu omaa liikkumismetodiaan.
     */
    public void liikuKohtiLahinta() {

        for (Hirvio m : hirviot.palautaMosat()) {
            if (etsiLahin(m)) {
                return;
            }
        }
    }

    /**
     * Metodi jonka tehtävänä on etsiä annetulle hirviölle lähin pelaajan
     * yksikkö. Kun pelaajan yksikkö on löytynyt kutsutaan tarkistaLiikkuminen
     * metodia jonka tehtävänä on tarkistaa puolestaan pystyykö hirviö
     * liikkumaan tähän suuntaan vai törmääkö se johonkin.
     *
     * @param m Antaa viitteen käsiteltävään hirviöön.
     * @return palauttaa true jos pelaajaryhmä onkin tyhjä, false jos jos ei.
     */
    private boolean etsiLahin(Hirvio m) {

        Yksikko lahin = null;
        int lahinP = Integer.MAX_VALUE;
        int lahinX = Integer.MAX_VALUE;
        int lahinY = Integer.MAX_VALUE;

        for (Yksikko c : ryhma.palautaHahmot()) {
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
        if (ryhma.palautaHahmot().isEmpty()) {
            return true;
        }
        tarkistaLiikkuminen(lahinX, lahinY, lahin, m);
        return false;
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

        for (Yksikko ch : ryhma.palautaHahmot()) {
            if (x == ch.getX() && y == ch.getY()) {
//                System.out.println("Die infidel!");
                ch.vahennaHp(hirvio.getVahinko());
//                System.out.println(ch);
                if (!ch.getIsAlive()) {
                    ryhma.poistaHahmo(ch);
                }
                if (ryhma.isEmpty()) {
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
}

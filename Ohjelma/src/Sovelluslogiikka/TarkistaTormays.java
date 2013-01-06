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

    /**
     * Konstruktori.
     *
     * @param Ryhma Antaa viitteen pelaajan oliot sisältävään oliosäiliöön.
     * @param vihollisRyhma Antaa viitteen hirviöt sisältävään oliosäiliöön.
     */
    public TarkistaTormays(Ryhma Ryhma, HirvioRyhma vihollisRyhma) {
        this.ryhma = Ryhma;
        this.vihollisRyhma = vihollisRyhma;
    }

    /**
     * Metodi jolla tarkistetaan törmääkö annetussa sijainnissa mihinkään. Jos
     * törmää hirviöön, vähennetään hirviön osumapisteitä. Jos osumapisteet
     * laskevat nollaan tai alle merkitään hirviö kuolleeksi ja poistetaan.
     *
     * @param x Kertoo tarkasteltavan paikan sijainnin x -akselilla.
     * @param y Kertoo tarkasteltavan paikan sijainnin y -akselilla.
     * @param vahinko Kertoo vahingon jota pelaajan yksikkö aiheuttaa jos törmää
     * viholliseen.
     * @return Palauttaa true jos törmää johonkin, false jos ei törmää.
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
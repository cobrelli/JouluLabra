package Sovelluslogiikka;

import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Yksikko;

/**
 * Järjestää kaikki vihollisyksiköt ja pelaajan yksiköt vierekkäin ruutuihin.
 *
 * @author vito
 */
public class JarjestaOliot {

    /**
     * hirviot sisältää viitteen Hirvioita sisältävään olio sailioon.
     *
     * ryhma sisältää viitteen pelaajan yksiköitä sisältävään olio sailioon.
     */
    HirvioRyhma hirviot;
    Ryhma ryhma;

    /**
     * Luo uuden järjestäjä olion, jolle annetaan pelaajan yksiköt ja hirviö
     * yksiköt sisältävät oliosäiliöt.
     *
     * @param hirviot Antaa viitteen hirviö oliot sisältävään säiliöön.
     * @param ryhma Antaa viitteen pelaajan yksiköt sisältävään säiliöön.
     */
    public JarjestaOliot(HirvioRyhma hirviot, Ryhma ryhma) {
        this.hirviot = hirviot;
        this.ryhma = ryhma;
    }

    /**
     * Järjestää kaikki pelaajan yksiköt vasempaan laitaan ja hirviö yksiköt
     * oikeaan laitaan.
     */
    public void jarjesta() {
        jarjestaPelaajanRyhma();
        jarjestaHirviot();
    }

    /**
     * Jarjestaa pelaajan yksiköt vasempaan laitaan alkaen kohdasta (101),(101).
     */
    private void jarjestaPelaajanRyhma() {
        int x = 101;
        int y = 101;

        for (Yksikko yks : ryhma.palautaHahmot()) {
            if (y > 475) {
                x += 25;
                y = 101;
            }
            yks.setX(x);
            yks.setY(y);
            y += 25;
        }
    }

    /**
     * Jarjestaa hirviöt oikeaan laitaan alkaen kohdasta (451),(101).
     */
    private void jarjestaHirviot() {
        int x = 451;
        int y = 101;

        for (Hirvio h : hirviot.palautaMosat()) {
            if (y > 475) {
                x -= 25;
                y = 101;
            }
            h.setX(x);
            h.setY(y);
            y += 25;
        }
    }
}

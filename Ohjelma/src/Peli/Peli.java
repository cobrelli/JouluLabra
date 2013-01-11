package Peli;

import GUI.GUI;
import Viholliset.Hiisi;
import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Viholliset.Rotta;
import Yksikot.Nostovaki;
import Yksikot.Ryhma;

/**
 * Luokka pelin keskeisimpien operaatioiden hoitamiseen ja hallintaan. Sisältää
 * pelin käynnistämismetodin, tason vaihtometodin ym.
 *
 * @author vito
 */
public class Peli {

    /**
     * taso sisältää tiedon sen nykyisestä peli tasosta.
     *
     * hirviot sisältää viitteen Hirvioita sisältävään olio sailioon.
     *
     * ryhma sisältää viitteen pelaajan yksiköitä sisältävään olioi sailioon.
     *
     * gui sisältää viitteen käytössä olevaan GUI:hin, josta kutsutaan
     * esimerkiksi kaupparuutuun siirtymistä silloin kun taso vaihtuu.
     */
    private int taso;
    private HirvioRyhma hirviot;
    private Ryhma ryhma;
    GUI gui;

    /**
     * Konstruktori, luo uuden peliolion tasolle 1.
     */
    public Peli() {
        this.taso = 1;
    }

    /**
     * Getteri
     *
     * @return Palauttaa tämänhetkisen tason.
     */
    public int getTaso() {
        return this.taso;
    }

    /**
     * Metodi tasolta seuraavalle siirtymiseen. Kasvattaa taso int attribuuttia
     * yhdellä, palauttaa kaikkien HP:n takaisin HpMax arvioon, tyhjentää
     * alustan ja kutsuu uuden kaupan luomis metodia.
     */
    public void seuraavaTaso() {
        this.taso += 1;
        ryhma.alustaKaikkienHP();
        gui.getFrame().getContentPane().removeAll();
        gui.getFrame().invalidate();
        gui.luoKauppa(gui.getFrame().getContentPane());
        gui.getFrame().validate();
    }

    /**
     * Metodi pelin käynnistämistä varten. Asettaa uuden hirvioryhmän ja uuden
     * pelaajan yksiköt sisältävän ryhmän, sekä luo ensimmäisen aloitusyksikön
     * ryhmään. Lopuksi luo uuden GUI:n ja kutsuu sen käynnistämetodia.
     */
    public void kaynnista() {

        this.hirviot = new HirvioRyhma();
        ryhma = new Ryhma();
        ryhma.lisaaHahmo(new Nostovaki(""));
        gui = new GUI(hirviot, ryhma, this);
        gui.run();

    }

    /**
     * Metodi uuden hirvioryhmän generoimiseen tason mukaan.
     *
     * @return Palauttaa uuden luodun ryhmän hirviöitä.
     */
    public HirvioRyhma palautaUudetViholliset() {

        int maara = 2;

        int luku = (taso % 10);

        int hirviotaso = taso / 10;

        if (luku == 0) {
            return luoBoss();
        }

        for (int i = 0; i < (maara + luku); i++) {
            if (taso < 10) {
                hirviot.lisaaMosa(new Rotta("Rotta"));
            } else if (taso > 10 && taso < 20) {
                hirviot.lisaaMosa(new Hiisi("Hiisi"));
            } else if (taso > 20) {
                Hiisi hiisi = new Hiisi("Hiisi");
                hiisi.setHpMax(hiisi.getHpMax() + (taso / 2));
                hiisi.setVahinko(hiisi.getVahinko() + (hirviotaso));
                hirviot.lisaaMosa(hiisi);
            }
        }

        return hirviot;
    }

    /**
     * Vielä implementoimaton metodi hirviön palauttamiseen tason mukaan.
     *
     * @return
     */
    public Hirvio annaHirvioTasonMukaan() {


        return null;
    }

    /**
     * Metodi uuden tulosRuudun luomiseen. Tyhjentää alustan ja kutsuu
     * huipputulosten luomismetodia.
     */
    public void tulosRuutu() {
        gui.getFrame().getContentPane().removeAll();
        gui.getFrame().invalidate();
        gui.luoHuippuTulokset(gui.getFrame().getContentPane());
        gui.getFrame().validate();
    }

    private HirvioRyhma luoBoss() {
        Hiisi hiisiboss = new Hiisi("Boss");
        hiisiboss.setPalkkio(30);
        hiisiboss.setHpMax(taso * 15);
        hiisiboss.setVahinko(hiisiboss.getVahinko() + (taso / 10));
        hirviot.lisaaMosa(hiisiboss);
        return hirviot;
    }
}

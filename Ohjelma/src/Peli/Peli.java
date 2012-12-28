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

        //ei implementoitu vielä
        int hirviotaso = taso / 10;

        for (int i = 0; i < (maara + luku); i++) {
            if (taso > 9) {
                hirviot.lisaaMosa(new Hiisi("Hiisi"));
            } else {
                hirviot.lisaaMosa(new Rotta("Rotta"));
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
}

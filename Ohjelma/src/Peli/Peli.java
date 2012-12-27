/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Peli;

import GUI.GUI;
import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Viholliset.Rotta;
import Yksikot.Nostovaki;
import Yksikot.Ryhma;

/**
 *
 * @author vito
 */
public class Peli {

    private int taso;
    private HirvioRyhma hirviot;
    private Ryhma ryhma;
    GUI gui;
    
    public Peli() {
        this.taso = 1;
    }

    public int getTaso() {
        return this.taso;
    }

    public void seuraavaTaso() {
        this.taso += 1;
        ryhma.alustaKaikkienHP();
        gui.getFrame().getContentPane().removeAll();
        gui.getFrame().invalidate();
        gui.luoKauppa(gui.getFrame().getContentPane());
        gui.getFrame().validate();
    }

    public void kaynnista() {

        this.hirviot = new HirvioRyhma();
        ryhma = new Ryhma();
        ryhma.lisaaHahmo(new Nostovaki(""));
//        palautaUudetViholliset();
        gui = new GUI(hirviot, ryhma, this);
        gui.run();

    }

    public HirvioRyhma palautaUudetViholliset() {

        int maara = 2;

        int luku = (taso % 10);

        //ei implementoitu vielä
        int hirviotaso = taso / 10;

        for (int i = 0; i < (maara + luku); i++) {
            hirviot.lisaaMosa(new Rotta("Rotta"));
        }

        return hirviot;
    }
    
    public Hirvio annaHirvioTasonMukaan(){
        
        
        return null;
    }
}

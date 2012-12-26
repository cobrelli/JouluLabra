/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Peli;

import GUI.GUI;
import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Viholliset.Rotta;
import Yksikot.Ryhma;
import Yksikot.Soturi;

/**
 *
 * @author vito
 */
public class Peli {

    private int pisteet;
    private int taso;
    private HirvioRyhma hirviot;
    private Ryhma ryhma;
    GUI gui;
    
    public Peli() {
        this.pisteet = 0;
        this.taso = 1;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public void lisaaPisteita(int maara) {
        this.pisteet += maara;
    }

    public void vahennaPisteita(int maara) {
        this.pisteet -= maara;
    }

    public boolean riittaako(int maara) {
        return this.pisteet - maara >= 0;
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
        ryhma.lisaaHahmo(new Soturi(""));
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

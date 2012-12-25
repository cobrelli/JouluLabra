/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Peli;

import GUI.GUI;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Soturi;

/**
 *
 * @author vito
 */
public class Peli {
    
    private int pisteet;
    private int taso;
    
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
    
    public int getTaso(){
        return this.taso;
    }
    
    public void seuraavaTaso(){
        this.taso += 1;
    }
    
    public void kaynnista() {
        
        HirvioRyhma hirviot = new HirvioRyhma();
        Ryhma ryhma = new Ryhma();
        ryhma.lisaaHahmo(new Soturi(""));
        GUI gui = new GUI(hirviot, ryhma);
        gui.run();
        
    }
}

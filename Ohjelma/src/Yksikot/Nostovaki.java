/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Yksikot;

/**
 *
 * @author vito
 */
public class Nostovaki extends Yksikko{
    public Nostovaki(String nimi){
        super(nimi);
        setHpMax(30);
        setVahinko(5);
        setCharClassID("Nostoväki");
        alustaStatsit();
    }
    
}

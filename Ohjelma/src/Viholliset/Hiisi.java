/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viholliset;

/**
 *
 * @author vito
 */
public class Hiisi extends Hirvio{
    public Hiisi(String nimi){
        super(nimi);
        setHpMax(25);
        setMonsterClassID("Hiisi");
        alustaStatsit();
        setPalkkio(3);
        setVahinko(10);
    }
}

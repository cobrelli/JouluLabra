package Viholliset;

import java.util.ArrayList;

/**
 * Luokka jonka tehtävänä on tallentaa ja hallinnoida kaikkia lisättyjä Monster
 * olioita.
 * @author Cobrelli
 */
public class HirvioRyhma {

    private ArrayList<Hirvio> mash;
    
    /**
     * Konstruktori alustaa tyhjän ArrayListin monster olioiden lisäämistä varten.
     */
    public HirvioRyhma(){
        this.mash = new ArrayList<>();
    }
    
    /**
     * Lisää luokan sisältämään ArrayListiin uuden monster olion.
     * @param mosa      Parametrinä annettu monster olio lisätään arraylistiin.
     */
    public void lisaaMosa(Hirvio mosa){
        this.mash.add(mosa);
    }

    /**
     * Poistaa halutun monster olion ArrayLististä.
     * @param mosa      Parametrinä annettu monster poistetaan Arraylististä.
     */
    public void poistaMosa(Hirvio mosa){
        this.mash.remove(mosa);
    }
    
    /**
     * Palauttaa luokan sisältämän ArrayListin.
     * @return      Palauttaa viitteen ArrayListiin.
     */
    public ArrayList<Hirvio> palautaMosat(){
        return this.mash;
    }
    
    /**
     * Tulostaa kaikki luokan sisältämät monster oliot.
     */
    public void tulostaMosat(){
        for (Hirvio m : mash) {
            System.out.println(m);
        }
    }
    
}
package HuippuTulokset;

import java.io.Serializable;

/**
 *
 * @author vito
 */
public class Piste implements Serializable, Comparable<Piste> {

    private String nimi;
    private int pisteet;
    
    public Piste(String nimi, int pisteet){
        this.nimi = nimi;
        this.pisteet = pisteet;
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    @Override
    public int compareTo(Piste p) {
        return ((Integer)p.getPisteet()).compareTo(getPisteet());
    }
    
}

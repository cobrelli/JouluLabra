package CharClass;

import java.util.ArrayList;

/**
 *
 * @author Cobrelli
 */
public class CharParty {

    private String partyNimi;
    
    private ArrayList<CharClass> party;
    
    /**
     *
     */
    public CharParty(){
        this.party = new ArrayList<>();
        this.partyNimi = "";
    }
    
    /**
     *
     * @return
     */
    public String getNimi(){
        return this.partyNimi;
    }
    
    /**
     *
     * @param nimi
     */
    public void setNimi(String nimi){
        this.partyNimi = nimi;
    }
    
    /**
     *
     * @param hahmo
     */
    public void lisaaHahmo(CharClass hahmo){
        this.party.add(hahmo);
    }

    /**
     *
     * @param hahmo
     */
    public void poistaHahmo(CharClass hahmo){
        this.party.remove(hahmo);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<CharClass> palautaHahmot(){
        return this.party;
    }
    
    /**
     *
     */
    public void tulostaHahmot(){
        for (CharClass c : party) {
            System.out.println(c);
        }
    }
    /**
     *
     * @return
     */
    public boolean isEmpty(){
        if(party.isEmpty()){
            return true;
        }
        return false;
    }
}

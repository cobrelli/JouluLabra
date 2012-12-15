package Monster;

import java.util.ArrayList;

public class MonsterMash {

    private ArrayList<Monster> mash;
    
    public MonsterMash(){
        this.mash = new ArrayList<>();
    }
    
    public void lisaaMosa(Monster mosa){
        this.mash.add(mosa);
    }

    public void poistaMosa(Monster mosa){
        this.mash.remove(mosa);
    }
    
    public ArrayList<Monster> palautaMosat(){
        return this.mash;
    }
    
    public void tulostaMosat(){
        for (Monster m : mash) {
            System.out.println(m);
        }
    }
    
}

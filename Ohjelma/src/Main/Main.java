
package Main;

import CharClass.CharParty;
import CharClass.Fighter;

/**
 *
 * @author Cobrelli
 */
public class Main {

    public static void main(String[] args) {

        Fighter eka = new Fighter("eka");
        Fighter toka = new Fighter("toka");
        
        CharParty p = new CharParty();
        
        p.lisaaHahmo(eka);
        p.lisaaHahmo(toka);
    }
}

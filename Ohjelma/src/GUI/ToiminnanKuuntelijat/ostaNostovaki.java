package GUI.ToiminnanKuuntelijat;

import Yksikot.Nostovaki;
import Yksikot.Ryhma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author vito
 */
public class ostaNostovaki implements ActionListener{

    Ryhma ryhma;
    JTextArea teksti;
    
    public ostaNostovaki(Ryhma ryhma, JTextArea teksti){
        this.ryhma = ryhma;
        this.teksti = teksti;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int hinta = 10;
        
        if(ryhma.riittaako(hinta)){
            ryhma.vahennaPisteita(hinta);
            ryhma.lisaaHahmo(new Nostovaki(""));
            teksti.setText("Pisteitä jäljellä: " + ryhma.getPisteet());
        }
    }

    
}

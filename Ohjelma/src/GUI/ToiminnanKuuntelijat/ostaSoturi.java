package GUI.ToiminnanKuuntelijat;

import Yksikot.Ryhma;
import Yksikot.Soturi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author vito
 */
public class ostaSoturi implements ActionListener {

    Ryhma ryhma;
    JTextArea teksti;
    
    public ostaSoturi(Ryhma ryhma, JTextArea teksti){
        this.ryhma = ryhma;
        this.teksti = teksti;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int hinta = 20;
        
        if(ryhma.riittaako(hinta)){
            ryhma.vahennaPisteita(hinta);
            ryhma.lisaaHahmo(new Soturi(""));
            teksti.setText("Pisteitä jäljellä: " + ryhma.getPisteet());
        }
    }
    
}
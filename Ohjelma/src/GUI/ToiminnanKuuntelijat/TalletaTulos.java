package GUI.ToiminnanKuuntelijat;

import HuippuTulokset.Tulokset;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author vito
 */
public class TalletaTulos implements ActionListener{

    private String nimi;
    private Tulokset tulokset;
    private JPanel paneeli;
    private int tulos;
    
    public TalletaTulos(JTextArea luettava, Tulokset tulokset, JPanel paneeli, 
            int tulos){
        this.nimi = luettava.getText();
        this.tulokset = tulokset;
        this.paneeli = paneeli;
        this.tulos = tulos;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

//        paneeli.invalidate();
        paneeli.removeAll();
        
        tulokset.lisaaPiste(nimi, tulos);
        String pisteet = tulokset.getPisteetStringina();
        JTextPane tekstialue = new JTextPane();
        tekstialue.setText(pisteet);
        tekstialue.setVisible(true);
        paneeli.add(tekstialue);
        paneeli.repaint();
        paneeli.validate();
    }
    
}

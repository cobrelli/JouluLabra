package GUI;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Cobrelli
 */
public class PiirtoalustaTaistelu extends JPanel implements Paivitettava{

    public PiirtoalustaTaistelu(){
        super.setBackground(Color.white);
    }
    
    @Override
    public void paivita() {
        repaint();
    }
    
}

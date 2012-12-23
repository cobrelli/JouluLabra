package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author vito
 */
public class PiirtoalustaKauppa extends JPanel implements Paivitettava {

    public PiirtoalustaKauppa(){
        super.setBackground(Color.white);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    @Override
    public void paivita() {
        repaint();
    }
    
}

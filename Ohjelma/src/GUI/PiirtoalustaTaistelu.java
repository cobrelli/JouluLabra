package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Cobrelli
 */
public class PiirtoalustaTaistelu extends JPanel implements Paivitettava {

    public PiirtoalustaTaistelu() {
        super.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        piirraRuudukko(g);
    }
    
        private void piirraRuudukko(Graphics g) {
        g.setColor(Color.black);

        for (int i = 100; i < 500; i += 25) {
            g.fillRect(100, i, 376, 1);
            g.fillRect(i, 100, 1, 376);
        }

    }

    @Override
    public void paivita() {
        repaint();
    }
}

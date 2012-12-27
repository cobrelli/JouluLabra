/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author vito
 */
public class Piirtoalusta extends JPanel implements Paivitettava {

    public Piirtoalusta(){
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

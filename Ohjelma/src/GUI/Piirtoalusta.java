package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Piirtoalusta, joka hoitaa uuden alustan piirtämisen ja johon lisätään kaikki
 * käyttöliittymäkomponentit.
 * @author vito
 */
public class Piirtoalusta extends JPanel {

    /**
     * Konstruktori. Asettaa taustaväriksi valkoisen.
     */
    public Piirtoalusta(){
        super.setBackground(Color.white);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

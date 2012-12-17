package GUI;

import CharClass.CharClass;
import CharClass.CharParty;
import Monster.Monster;
import Monster.MonsterMash;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Cobrelli
 */
public class PiirtoalustaTaistelu extends JPanel implements Paivitettava {

    private MonsterMash mash;
    private CharParty party;
    
    public PiirtoalustaTaistelu(MonsterMash m, CharParty p) {
        super.setBackground(Color.white);
        this.mash = m;
        this.party = p;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        piirraRuudukko(g);
        piirraHahmot(g);
        piirraMosat(g);
        
    }

    private void piirraRuudukko(Graphics g) {
        g.setColor(Color.black);

        for (int i = 100; i < 500; i += 25) {
            g.fillRect(100, i, 376, 1);
            g.fillRect(i, 100, 1, 376);
        }

    }

    private void piirraHahmot(Graphics g) {

        for (CharClass c : this.party.palautaHahmot()) {
            if (c.getIsAlive()) {
                g.setColor(Color.red);
                g.fillOval(c.getX(), c.getY(), 23, 23);
            }
        }
    }

    private void piirraMosat(Graphics g) {

        for (Monster m : this.mash.palautaMosat()) {
            if (m.isAlive()) {
                g.setColor(Color.black);
                g.fillOval(m.getX(), m.getY(), 23, 23);
            }
        }

    }

    @Override
    public void paivita() {
        repaint();
    }
}

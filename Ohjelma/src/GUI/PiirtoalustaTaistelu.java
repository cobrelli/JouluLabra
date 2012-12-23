package GUI;

import Sovelluslogiikka.Vuoro;
import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Yksikko;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Cobrelli
 */
public class PiirtoalustaTaistelu extends JPanel implements Paivitettava {

    private HirvioRyhma mash;
    private Ryhma party;
    Vuoro vuoro;

    public PiirtoalustaTaistelu(HirvioRyhma m, Ryhma p, Vuoro vuoro) {
        super.setBackground(Color.white);
        this.mash = m;
        this.party = p;
        this.vuoro = vuoro;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        piirraVuoro(g, vuoro.getVuoro().getX(), vuoro.getVuoro().getY());
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

        for (Yksikko c : this.party.palautaHahmot()) {
            if (c.getIsAlive()) {
                g.setColor(Color.red);
                g.fillOval(c.getX(), c.getY(), 23, 23);
            }
        }
    }

    private void piirraMosat(Graphics g) {

        for (Hirvio m : this.mash.palautaMosat()) {
            if (m.isAlive()) {
                g.setColor(Color.black);
                g.fillOval(m.getX(), m.getY(), 23, 23);
            }
        }

    }

    public void piirraVuoro(Graphics g, int x, int y) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, 23, 23);
    }

    @Override
    public void paivita() {
        repaint();
    }
}

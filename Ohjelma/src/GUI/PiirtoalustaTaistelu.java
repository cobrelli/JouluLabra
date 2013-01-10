package GUI;

import Sovelluslogiikka.Vuoro;
import Viholliset.Hirvio;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import Yksikot.Yksikko;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Piirtoalusta, joka hoitaa kaikkien tärkeimpien asioiden piirtämisen.
 *
 * @author Cobrelli
 */
public class PiirtoalustaTaistelu extends JPanel {

    private HirvioRyhma mash;
    private Ryhma party;
    Vuoro vuoro;

    /**
     * Konstruktori. Luo uuden piirtoalustan ja kutsuu piirtotoiminnallisuudet
     * sille annettujen parametrien mukaisesti.
     *
     * @param m Antaa viitteen hirviot sisältävään oliosäiliöön.
     * @param p Antaa viitteen pelaajan yksiköt sisältävään oliosäiliöön.
     * @param vuoro Antaa viitteen vuoro-olioon joka määrää kunkin hetken
     * vuoron.
     */
    public PiirtoalustaTaistelu(HirvioRyhma m, Ryhma p, Vuoro vuoro) {
        super.setBackground(Color.white);
        this.mash = m;
        this.party = p;
        this.vuoro = vuoro;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        piirraTausta(g);
        piirraVuoro(g, vuoro.getVuoro().getX(), vuoro.getVuoro().getY());
        piirraRuudukko(g);
        piirraHahmot(g);
        piirraMosat(g);
    }

    private void piirraTausta(Graphics g) {
        g.setColor(Color.green);

        g.fillRect(100, 100, 375, 375);
    }

    /**
     * Piirtää pelissä näkyvän ruudukon.
     *
     * @param g Antaa viitteen grafiikkaolioon.
     */
    private void piirraRuudukko(Graphics g) {
        g.setColor(Color.black);

        for (int i = 100; i < 500; i += 25) {
            g.fillRect(100, i, 376, 1);
            g.fillRect(i, 100, 1, 376);
        }

    }

    /**
     * Piirtaa kaikki pelaajan yksiköiden oliosäiliössä olevat hahmot.
     *
     * @param g Antaa viitteen grafiikkaolioon.
     */
    private void piirraHahmot(Graphics g) {

        for (Yksikko c : this.party.palautaHahmot()) {
            if (c.getIsAlive()) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(getClass().getResource(c.getKuvanSijainti()));
                } catch (IOException e) {
                } catch (IllegalArgumentException e) {
                    System.out.println("[Kuvan Lataus] Varoitus - Kuvaa ei löytynyt");
                }
                g.drawImage(img, c.getX(), c.getY(), null);
            }
        }
    }

    /**
     * Piirtää kaikki vihollisyksiköiden oliosäiliön sisältämät viholliset
     * ruudulle.
     *
     * @param g Antaa viitteen grafiikkaolioon.
     */
    private void piirraMosat(Graphics g) {

        for (Hirvio m : this.mash.palautaMosat()) {
            if (m.isAlive()) {
                BufferedImage img = null;
                try {
                    img = ImageIO.read(getClass().getResource(m.getKuvanSijainti()));
                } catch (IOException e) {
                } catch (IllegalArgumentException e) {
                    System.out.println("[Kuvan Lataus] Varoitus - Kuvaa ei löytynyt");
                }
                g.drawImage(img, m.getX(), m.getY(), null);
            }
        }
    }

    /**
     * Piirtää sen hetkisen vuoron omaavan pelaajan taakse harmaan alueen
     * indikoimaan vuoroa.
     *
     * @param g Antaa viitteen grafiikkaolioon.
     * @param x Kertoo piirrettävän paikan kohdan x -akselilla.
     * @param y Kertoo piirrettävän paikan kohdan y -akselilla.
     */
    private void piirraVuoro(Graphics g, int x, int y) {
//        g.setColor(Color.LIGHT_GRAY);
        g.setColor(Color.darkGray);
        g.fillRect(x, y, 24, 24);
    }
}
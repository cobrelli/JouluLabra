package GUI.Nappaimistonkuuntelija;

import Sovelluslogiikka.TarkistaTormays;
import Sovelluslogiikka.Vuoro;
import Yksikot.Yksikko;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 * Luokka jonka tehtävänä on kuunnella näppäimistöä ja pelaajan yksiköille
 * antamia käskyjä. Ja toteuttaa liikkeet sallittujen määräysten mukaisesti.
 *
 * @author Cobrelli
 */
public class Nappaimistonkuuntelija extends JPanel implements KeyListener {

    JPanel paneeli;
    Yksikko c;
    TarkistaTormays tormays;
    Vuoro vuoro;

    /**
     * Konstruktori. Luo uuden näppäimistönkuuntelija olion ja alustaa
     * tarvittavat oliot.
     *
     * @param paneeli
     * @param tormays
     * @param vuoro
     */
    public Nappaimistonkuuntelija(JPanel paneeli, TarkistaTormays tormays,
            Vuoro vuoro) {
        this.paneeli = paneeli;
        this.tormays = tormays;
        this.vuoro = vuoro;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        c = vuoro.getVuoro();

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            liikuJosValidi(c.getY() - 25, c.getX());

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            liikuJosValidi(c.getY() + 25, c.getX());

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            liikuJosValidi(c.getY(), c.getX() - 25);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            liikuJosValidi(c.getY(), c.getX() + 25);

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
            liikuJosValidi(c.getY() - 25, c.getX() - 25);

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
            liikuJosValidi(c.getY() - 25, c.getX());

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            liikuJosValidi(c.getY() - 25, c.getX() + 25);

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            liikuJosValidi(c.getY(), c.getX() - 25);

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
            paneeli.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            liikuJosValidi(c.getY(), c.getX() + 25);

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            liikuJosValidi(c.getY() + 25, c.getX() - 25);

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            liikuJosValidi(c.getY() + 25, c.getX());

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            liikuJosValidi(c.getY() + 25, c.getX() + 25);

        }
        vuoro.seuraavaVuoro();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     *
     * @param y
     * @param x
     */
    public void liikuJosValidi(int y, int x) {

        if (y > 475 || y < 100 || x < 100 || x > 475
                || tormays.tarkistaTormaako(x, y, c.getVahinko())) {
            paneeli.repaint();
            return;
        }

        c.setY(y);
        c.setX(x);
        paneeli.repaint();
    }
}

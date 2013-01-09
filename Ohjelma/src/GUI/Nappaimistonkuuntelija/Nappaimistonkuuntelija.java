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
     * @param paneeli Antaa viitteen JPanel olioon.
     * @param tormays Antaa viitteen törmäysten tarkistusta hoitavaan olioon.
     * @param vuoro Antaa viitteen vuorojen jakamista hoitavaan olioon.
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

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                liikuJosValidi(c.getY() - 25, c.getX());
                break;
            case KeyEvent.VK_DOWN:
                liikuJosValidi(c.getY() + 25, c.getX());
                break;
            case KeyEvent.VK_LEFT:
                liikuJosValidi(c.getY(), c.getX() - 25);
                break;
            case KeyEvent.VK_RIGHT:
                liikuJosValidi(c.getY(), c.getX() + 25);
                break;
            case KeyEvent.VK_NUMPAD7:
                liikuJosValidi(c.getY() - 25, c.getX() - 25);
                break;
            case KeyEvent.VK_NUMPAD8:
                liikuJosValidi(c.getY() - 25, c.getX());
                break;
            case KeyEvent.VK_NUMPAD9:
                liikuJosValidi(c.getY() - 25, c.getX() + 25);
                break;
            case KeyEvent.VK_NUMPAD4:
                liikuJosValidi(c.getY(), c.getX() - 25);
                break;
            case KeyEvent.VK_NUMPAD5:
                paneeli.repaint();
                break;
            case KeyEvent.VK_NUMPAD6:
                liikuJosValidi(c.getY(), c.getX() + 25);
                break;
            case KeyEvent.VK_NUMPAD1:
                liikuJosValidi(c.getY() + 25, c.getX() - 25);
                break;
            case KeyEvent.VK_NUMPAD2:
                liikuJosValidi(c.getY() + 25, c.getX());
                break;
            case KeyEvent.VK_NUMPAD3:
                liikuJosValidi(c.getY() + 25, c.getX() + 25);
                break;
            default:
                return;
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
     * Tarkistaa onko liike sallituissa rajoissa ja jos on kysyy törmäysten
     * tarkistajalta törmääkö yksikkö mihinkään. Jos ei törmää ja liike on
     * sallittu niin päivitetään olion sijainti ja kutsutaan paneelin repaint
     * metodia.
     *
     * @param y Antaa viitteen tutkittavan paikan y -koordinaattiin.
     * @param x Antaa viitteen tutkittavan paikan x -koordinaattiin.
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

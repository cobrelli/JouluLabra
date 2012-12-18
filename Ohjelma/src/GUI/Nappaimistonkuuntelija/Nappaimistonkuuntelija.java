package GUI.Nappaimistonkuuntelija;

import CharClass.CharClass;
import GUI.Paivitettava;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Cobrelli
 */
public class Nappaimistonkuuntelija extends JPanel implements KeyListener {

    JPanel paivitettava;
    CharClass c;
    
    public Nappaimistonkuuntelija(JPanel paivitettava, CharClass c){
        this.paivitettava = paivitettava;
        this.c = c;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("blabal");
            if (c.getY() - 25 < 100) {
                return;
            }
            c.setY(c.getY() - 25);
            System.out.println("lkj");

            paivitettava.repaint();
            
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (c.getY() + 25 > 475) {
                return;
            }
            
            c.setY(c.getY() + 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (c.getX() - 25 < 100) {
                return;
            }
            
            c.setX(c.getX() - 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (c.getX() + 25 > 475) {
                return;
            }
            
            c.setX(c.getX() + 25);
            paivitettava.repaint();
            
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
            if (c.getY() - 25 < 100 || c.getX() - 25 < 100) {
                return;
            }
            
            c.setY(c.getY() - 25);
            c.setX(c.getX() - 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
            if (c.getY() - 25 < 100) {
                return;
            }
            
            c.setY(c.getY() - 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            if (c.getY() - 25 < 100 || c.getX() + 25 > 475) {
                return;
            }
            
            c.setY(c.getY() - 25);
            c.setX(c.getX() + 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            if (c.getX() - 25 < 100) {
                return;
            }
            
            c.setX(c.getX() - 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            if (c.getX() + 25 > 475) {
                return;
            }
            
            c.setX(c.getX() + 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            if (c.getY() + 25 > 475 || c.getX() - 25 < 100) {
                return;
            }
            
            c.setY(c.getY() + 25);
            c.setX(c.getX() - 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            if (c.getY() + 25 > 475) {
                return;
            }
            
            c.setY(c.getY() + 25);
            paivitettava.repaint();

        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            if (c.getY() + 25 > 475 || c.getX() + 25 > 475) {
                return;
            }
            
            c.setY(c.getY() + 25);
            c.setX(c.getX() + 25);
            paivitettava.repaint();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
}

package GUI.ToiminnanKuuntelijat;

import GUI.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Toiminnankuuntelija, jonka tarkoituksena on luoda uusi taisteluruutu kun
 * kaupparuudussa painetaan painiketta.
 *
 * @author vito
 */
public class luoTaisteluruutu implements ActionListener {

    JFrame frame;
    GUI gui;

    /**
     * Konstruktori, alustaa kaikki tarvittavat oliot.
     *
     * @param frame Antaa viitteen muokattavaan JFrame olioon.
     * @param gui Antaa viitteen GUI olioon, jonka luoTaisteluRuutu -metodia
     * kutsutaan.
     */
    public luoTaisteluruutu(JFrame frame, GUI gui) {
        this.frame = frame;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        if (frame.getContentPane().getKeyListeners().length > 0) {
            frame.getContentPane().removeKeyListener(frame.getContentPane().getKeyListeners()[0]);
        }

        frame.invalidate();
        gui.luoTaisteluruutu(frame.getContentPane());
        frame.validate();
    }
}

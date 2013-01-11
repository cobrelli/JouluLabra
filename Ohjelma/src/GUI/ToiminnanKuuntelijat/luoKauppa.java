package GUI.ToiminnanKuuntelijat;

import GUI.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Toiminnankuuntelija, jonka tarkoitus on luoda uusi kaupparuutu kun
 * aloitusruudussa painetaan nappulaa.
 *
 * @author vito
 */
public class luoKauppa implements ActionListener {

    /**
     * frame kertoo käytettävän JFramen, johon talletetaan eri alustoja.
     *
     * gui antaa viitteen GUI olioon, jolla hoidetaan GUI:n hallinta.
     */
    JFrame frame;
    GUI gui;

    /**
     * Konstruktori, alustaa kaikki tarvittavat oliot kaupan luomista varten.
     *
     * @param frame Antaa viitteen muokattavaan JFrame olioon.
     * @param gui Antaa viitteen GUI olioon, josta luoKauppa metodia kutsutaan.
     */
    public luoKauppa(JFrame frame, GUI gui) {
        this.frame = frame;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.invalidate();
        gui.luoKauppa(frame.getContentPane());
        frame.validate();
    }
}

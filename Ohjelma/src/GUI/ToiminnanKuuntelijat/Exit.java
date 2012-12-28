package GUI.ToiminnanKuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Toiminnankuuntelija, jonka tarkoitus on poistua pelistä jos poistumisnappulaa
 * painetaan.
 *
 * @author vito
 */
public class Exit implements ActionListener {

    /**
     * Konstruktori, alustaa uuden poistumis toiminnankuuntelijan.
     */
    public Exit() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

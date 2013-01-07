package GUI.ToiminnanKuuntelijat;

import Yksikot.Ryhma;
import Yksikot.Soturi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 * Toiminnankuuntelija, jonka tarkoitus on kuunnella kun kaupparuudussa
 * painetaan osta soturi painiketta ja tämän jälkeen kysyä ryhmä oliolta
 * riittävätkö pelaajan rahat ja jos riittävät lisätä siihen uusi soturi olio ja
 * vähentää pisteitä.
 *
 * @author vito
 */
public class ostaSoturi implements ActionListener {

    Ryhma ryhma;
    JTextArea teksti;

    /**
     * Konstruktori, alustaa kaikki toiminnankuuntelijan tarvitsemat oliot.
     *
     * @param ryhma Antaa viitteen ryhmä olioon, jolta asioita kysellään ja jota
     * päivitetään.
     * @param teksti Antaa viitteen kaupparuudussa pelaajan rahat ilmoittavaan
     * JTextArea komponenttiin.
     */
    public ostaSoturi(Ryhma ryhma, JTextArea teksti) {
        this.ryhma = ryhma;
        this.teksti = teksti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int hinta = 20;

        if (ryhma.riittaako(hinta) && ryhma.palautaHahmot().size()<105) {
            ryhma.vahennaPisteita(hinta);
            ryhma.lisaaHahmo(new Soturi(""));
            teksti.setText("Pisteitä jäljellä: " + ryhma.getPisteet());
        }
    }
}

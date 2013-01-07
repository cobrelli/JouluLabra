package GUI.ToiminnanKuuntelijat;

import Yksikot.Nostovaki;
import Yksikot.Ryhma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 * Toiminnankuuntelija, jonka tarkoitus on kuunnella kun osta nostoväki nappulaa
 * painetaan ja kysyä ryhmä oliosäiliöltä riittävätkö pelaajan rahat ja jos
 * riittävät lisätä tähän uusi ja vähentää pisteitä.
 *
 * @author vito
 */
public class ostaNostovaki implements ActionListener {

    Ryhma ryhma;
    JTextArea teksti;

    /**
     * Konstruktori, alustaa toiminnankuuntelijan tarvitsevat oliot.
     *
     * @param ryhma Antaa viitteen pelaajan yksiköt sisältävään oliosäiliöön.
     * @param teksti Antaa viitteen kaupparuudussa jäljellä olevat pisteet
     * kertovaan JTextArea komponenttiin.
     */
    public ostaNostovaki(Ryhma ryhma, JTextArea teksti) {
        this.ryhma = ryhma;
        this.teksti = teksti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int hinta = 10;

        if (ryhma.riittaako(hinta) && ryhma.palautaHahmot().size()<105) {
            ryhma.vahennaPisteita(hinta);
            ryhma.lisaaHahmo(new Nostovaki(""));
            teksti.setText("Pisteitä jäljellä: " + ryhma.getPisteet());
        }
    }
}

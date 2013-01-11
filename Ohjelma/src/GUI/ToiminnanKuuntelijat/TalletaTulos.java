package GUI.ToiminnanKuuntelijat;

import HuippuTulokset.Tulokset;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * Toiminnankuuntelija, joka kuuntelee parhaiden pisteiden talletuksessa
 * käytettävää nappulaa. Pelaajalta kysytään nimeä ja kun talleta nappulaa
 * painetaan kopioidaan nimi kentästä teksti ja lisätään annetaan tuloksia
 * hallinnoivalle luokalle ja piirretään tulokset.
 *
 * @author vito
 */
public class TalletaTulos implements ActionListener {

    /**
     * nimi sisältää tiedon pelaajan nimestä.
     *
     * tulokset kertoo viitteen tulokset olioon, jonka avulla talletetaan tulos.
     *
     * paneeli sisältää viitteen käytössä olevaan JPaneliin, johon piirretään
     * näytettävät tulokset tallentamisen jälkeen.
     *
     * luettava sisältää viitteen JTextAreaan, johon on kirjoitettu pelaajan
     * nimi, joka luetaan ja talletetaan.
     */
    private String nimi;
    private Tulokset tulokset;
    private JPanel paneeli;
    private int tulos;
    private JTextArea luettava;

    /**
     * Konstruktori, alustaa uuden toiminnankuuntelijan ja sen tarvitsemat oliot
     * ja attribuutit.
     *
     * @param luettava Antaa viitteen tekstiolioon, josta luetaan pelaajan nimi.
     * @param tulokset Antaa viitteen tuloksiin.
     * @param paneeli Antaa viitteen paneeliin, johon piirretään komponentteja.
     * @param tulos Kertoo pelaajan tuloksen.
     */
    public TalletaTulos(JTextArea luettava, Tulokset tulokset, JPanel paneeli,
            int tulos) {
        this.luettava = luettava;
        this.tulokset = tulokset;
        this.paneeli = paneeli;
        this.tulos = tulos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.nimi = luettava.getText();
        paneeli.removeAll();

        tulokset.lisaaPiste(nimi, tulos);
        String pisteet = tulokset.palautaPisteetStringina();
        JTextPane tekstialue = new JTextPane();
        tekstialue.setText(pisteet);
        tekstialue.setVisible(true);
        paneeli.add(tekstialue);
        paneeli.repaint();
        paneeli.validate();
    }
}

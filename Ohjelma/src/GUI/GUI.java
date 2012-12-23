package GUI;

import Yksikot.Ryhma;
import GUI.Nappaimistonkuuntelija.Nappaimistonkuuntelija;
import Viholliset.HirvioRyhma;
import Sovelluslogiikka.TarkistaTormays;
import Sovelluslogiikka.Vuoro;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Cobrelli
 */
public class GUI implements Runnable {

    JFrame frame;
    private JPanel alusta;
    private HirvioRyhma mash;
    private Ryhma party;

    public GUI(HirvioRyhma m, Ryhma p) {
        this.mash = m;
        this.party = p;
    }

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {

        container.setLayout(new BorderLayout());

        this.alusta = new PiirtoalustaTaistelu(mash, party);

        container.add(this.alusta, BorderLayout.CENTER);

        Vuoro vuoro = new Vuoro(party, mash);

        TarkistaTormays tormays = new TarkistaTormays(party, mash, vuoro);

        container.addKeyListener(new Nappaimistonkuuntelija(this.alusta, 
                tormays, vuoro));

        container.setFocusable(true);

    }

    public JFrame getFrame() {
        return frame;
    }
}

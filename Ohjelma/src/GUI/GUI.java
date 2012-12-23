package GUI;

import CharClass.CharParty;
import GUI.Nappaimistonkuuntelija.Nappaimistonkuuntelija;
import Monster.MonsterMash;
import Sovelluslogiikka.TarkistaTormays;
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
    private MonsterMash mash;
    private CharParty party;

    public GUI(MonsterMash m, CharParty p) {
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

        TarkistaTormays tormays = new TarkistaTormays(party, mash);
        
        container.addKeyListener(new Nappaimistonkuuntelija(this.alusta, party.palautaHahmot().get(0), tormays));

        container.setFocusable(true);
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
}

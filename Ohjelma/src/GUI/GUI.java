package GUI;

import GUI.Nappaimistonkuuntelija.Nappaimistonkuuntelija;
import GUI.ToiminnanKuuntelijat.Exit;
import GUI.ToiminnanKuuntelijat.luoKauppa;
import GUI.ToiminnanKuuntelijat.luoTaisteluruutu;
import Peli.Peli;
import Sovelluslogiikka.JarjestaOliot;
import Sovelluslogiikka.TarkistaTormays;
import Sovelluslogiikka.Vuoro;
import Viholliset.HirvioRyhma;
import Yksikot.Ryhma;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
    private Peli peli;

    public GUI(HirvioRyhma m, Ryhma p, Peli peli) {
        this.mash = m;
        this.party = p;
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoAloitusruutu(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoAloitusruutu(Container container) {
        this.alusta = new PiirtoalustaAloitus();
        container.add(alusta);

        alusta.setLayout(new GridBagLayout());
//        alusta.setBackground(Color.darkGray);
//        container.setBackground(Color.darkGray);
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 60;
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 0;

        Font font = new Font("Verdana", Font.BOLD, 30);

        JTextArea Teksti1 = new JTextArea("The Battle");
        Teksti1.setForeground(Color.red);
        Teksti1.setBackground(Color.darkGray);
        Teksti1.setEditable(false);
        Teksti1.setFont(font);

        alusta.add(Teksti1, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 0;
        c.ipady = 20;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;

        JButton button1 = new JButton("Aloita");
        alusta.add(button1, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 0;
        c.ipady = 20;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;

        button1.addActionListener(new luoKauppa(frame, this));

        JButton button2 = new JButton("Lopeta");
        alusta.add(button2, c);
        button2.addActionListener(new Exit());
    }

    public void luoTaisteluruutu(Container container) {

        container.setLayout(new BorderLayout());

        this.mash = peli.palautaUudetViholliset();
        
        Vuoro vuoro = new Vuoro(party, mash, peli);

        JarjestaOliot j = new JarjestaOliot(mash, party);
        j.jarjesta();

        this.alusta = new PiirtoalustaTaistelu(mash, party, vuoro);

        container.add(this.alusta, BorderLayout.CENTER);

        TarkistaTormays tormays = new TarkistaTormays(party, mash, vuoro);

        container.addKeyListener(new Nappaimistonkuuntelija(this.alusta,
                tormays, vuoro));

        container.setFocusable(true);
        container.requestFocusInWindow();
    }

    public void luoKauppa(Container container) {

        this.alusta = new PiirtoalustaKauppa();
        container.add(alusta);

        alusta.setLayout(new BorderLayout(10, 10));

        Font font = new Font("Verdana", Font.BOLD, 30);

        JPanel otsikko = new JPanel(new GridLayout(1, 3));
        otsikko.setBackground(Color.white);
        alusta.add(otsikko, BorderLayout.NORTH);

        JTextArea Teksti1 = new JTextArea("Kauppa");
        Teksti1.setForeground(Color.black);
        Teksti1.setEditable(false);
        Teksti1.setFont(font);

        otsikko.add(new JLabel());
        otsikko.add(Teksti1);
        otsikko.add(new JLabel());

        JPanel kaupanPainikkeet = new JPanel(new GridBagLayout());
        kaupanPainikkeet.setBackground(Color.white);
        alusta.add(kaupanPainikkeet, BorderLayout.CENTER);

        JButton ostaNostovaki = new JButton("Nostoväki");
        ostaNostovaki.setPreferredSize(new Dimension(130, 80));
        JButton ostaSoturi = new JButton("Soturi");
        ostaSoturi.setPreferredSize(new Dimension(130, 80));

        kaupanPainikkeet.add(ostaNostovaki);
        kaupanPainikkeet.add(ostaSoturi);

        JPanel hallintaNappulat = new JPanel(new GridBagLayout());
        hallintaNappulat.setBackground(Color.white);
        JButton aloita = new JButton("Taisteluun");
        aloita.addActionListener(new luoTaisteluruutu(frame, this));
        alusta.add(hallintaNappulat, BorderLayout.WEST);
        hallintaNappulat.setPreferredSize(new Dimension(130, 80));
        hallintaNappulat.add(aloita);

        JPanel pisteet = new JPanel(new GridLayout(1, 3));
        pisteet.setBackground(Color.white);
        JTextArea pisteLaskuri = new JTextArea("Pisteitä jäljellä: ");
        pisteLaskuri.setForeground(Color.black);
        pisteLaskuri.setEditable(false);
        pisteLaskuri.setFont(font);
        pisteLaskuri.setFont(new Font("Verdana", Font.BOLD, 12));

        alusta.add(pisteet, BorderLayout.SOUTH);
        pisteet.add(new JLabel());
        pisteet.add(pisteLaskuri, BorderLayout.SOUTH);
        pisteet.add(new JLabel());
    }

    public JFrame getFrame() {
        return frame;
    }
}
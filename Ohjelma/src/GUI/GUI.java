package GUI;

import GUI.Nappaimistonkuuntelija.Nappaimistonkuuntelija;
import GUI.ToiminnanKuuntelijat.Exit;
import GUI.ToiminnanKuuntelijat.TalletaTulos;
import GUI.ToiminnanKuuntelijat.luoKauppa;
import GUI.ToiminnanKuuntelijat.luoTaisteluruutu;
import GUI.ToiminnanKuuntelijat.ostaNostovaki;
import GUI.ToiminnanKuuntelijat.ostaSoturi;
import HuippuTulokset.Piste;
import HuippuTulokset.Tulokset;
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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Cobrelli
 */
public class GUI implements Runnable {

    JFrame frame;
    private JPanel alusta;
    private HirvioRyhma hirvioRyhma;
    private Ryhma ryhma;
    private Peli peli;

    public GUI(HirvioRyhma m, Ryhma p, Peli peli) {
        this.hirvioRyhma = m;
        this.ryhma = p;
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
        this.alusta = new Piirtoalusta();
        container.add(alusta);

        alusta.setLayout(new GridBagLayout());
        alusta.setBackground(Color.darkGray);
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

        this.hirvioRyhma = peli.palautaUudetViholliset();

        Vuoro vuoro = new Vuoro(ryhma, hirvioRyhma, peli);

        JarjestaOliot j = new JarjestaOliot(hirvioRyhma, ryhma);
        j.jarjesta();

        this.alusta = new PiirtoalustaTaistelu(hirvioRyhma, ryhma, vuoro);

        container.add(this.alusta, BorderLayout.CENTER);

        TarkistaTormays tormays = new TarkistaTormays(ryhma, hirvioRyhma, vuoro);

        container.addKeyListener(new Nappaimistonkuuntelija(this.alusta,
                tormays, vuoro));

        container.setFocusable(true);
        container.requestFocusInWindow();
    }

    public void luoKauppa(Container container) {

        this.alusta = new Piirtoalusta();
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
        JTextArea pisteLaskuri = new JTextArea("Pisteitä jäljellä: "
                + ryhma.getPisteet());
        pisteLaskuri.setForeground(Color.black);
        pisteLaskuri.setEditable(false);
        pisteLaskuri.setFont(font);
        pisteLaskuri.setFont(new Font("Verdana", Font.BOLD, 12));

        alusta.add(pisteet, BorderLayout.SOUTH);
        pisteet.add(new JLabel());
        pisteet.add(pisteLaskuri, BorderLayout.SOUTH);
        pisteet.add(new JLabel());

        ostaNostovaki.addActionListener(new ostaNostovaki(ryhma, pisteLaskuri));
        ostaSoturi.addActionListener(new ostaSoturi(ryhma, pisteLaskuri));
    }

    public void luoHuippuTulokset(Container container) {
        this.alusta = new Piirtoalusta();
        container.add(alusta);

        alusta.setLayout(new BorderLayout(10, 10));

        Font font = new Font("Verdana", Font.BOLD, 30);

        JPanel otsikko = new JPanel(new GridLayout(1, 3));
        otsikko.setBackground(Color.white);
//        otsikko.setPreferredSize(new Dimension(900, 150));
        alusta.add(otsikko, BorderLayout.NORTH);

        JTextArea huippuTulostenOtsikko = new JTextArea("  Peli loppui - Huipputulokset");
        huippuTulostenOtsikko.setForeground(Color.black);
        huippuTulostenOtsikko.setEditable(false);
        huippuTulostenOtsikko.setFont(font);

//        otsikko.add(new JLabel());
        otsikko.add(huippuTulostenOtsikko);
//        otsikko.add(new JLabel());

        JPanel tulostenNaytto = new JPanel(new GridBagLayout());
        alusta.add(tulostenNaytto, BorderLayout.WEST);
        
        JTextPane tuloksetTekstina = new JTextPane();
        
        Tulokset tulokset = new Tulokset();
        ArrayList<Piste> pisteet = tulokset.getPisteet();
        int indeksi = 10;

//        tulokset.lisaaPiste("testi", 0);
        
//        tuloksetTekstina.setText(tulokset.getPisteetStringina());
//        tulostenNaytto.add(tuloksetTekstina);
        JTextArea nimi = new JTextArea("Anna nimesi");
        nimi.setPreferredSize(new Dimension(100, 50));
        tulostenNaytto.add(nimi);
        JButton talleta = new JButton("Talleta");
        talleta.addActionListener(new TalletaTulos(nimi, tulokset, tulostenNaytto, 
                ryhma.getKokonaisPisteet()));
        talleta.setPreferredSize(new Dimension(100, 50));
        tulostenNaytto.add(talleta);
        
        if(pisteet.size()<11){
            
        }
//        if (!pisteet.isEmpty()) {
//            if (pisteet.size() < 11) {
////                tulokset.lisaaPiste(null, indeksi);
//                
//            }else if (pisteet.get(indeksi).getPisteet() < ryhma.getKokonaisPisteet()) {
//                
//            }
//            
//        }

    }

    public JFrame getFrame() {
        return frame;
    }
}
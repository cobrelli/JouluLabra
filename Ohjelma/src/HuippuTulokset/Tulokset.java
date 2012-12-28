package HuippuTulokset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka sisältää tulosten tallentamiseen, järjestämiseen ja lataamiseen
 * tarkoitettuja metodeja.
 *
 * @author vito
 */
public class Tulokset {

    private ArrayList<Piste> pisteet;
    /**
     * Tiedosto, johon tulokset talletetaan ja josta ne ladataan.
     */
    public static final String pisteTiedosto = "pisteet.dat";
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    /**
     * Konstruktori, alustaa uuden pisteet listan, jossa tuloksia säilytetään.
     */
    public Tulokset() {
        this.pisteet = new ArrayList<>();
    }

    /**
     * Palauttaa viitteen pisteet ArrayListiin, suorittamalla ensin lataa
     * metodin ja sen jälkeen järjestää tulokset ja palauttaa ArrayListin.
     *
     * @return Palauttaa viitteen tulokset sisältävään arraylistiin.
     */
    public ArrayList<Piste> palautaPisteet() {
        lataaPisteet();
        Collections.sort(pisteet);
        return pisteet;
    }

    /**
     * Metodi pisteiden lisäämiseen listalle. Käyttää lataaPisteet metodia
     * pisteiden lautaukseen. Lisää ladatulle listalle uuden piste olion ja
     * tallentaa .dat tiedostoon tulokset.
     *
     * @param nimi Kertoo lisättävän pelaajan nimen.
     * @param piste Kertoo lisättävän pelaajan pistemäärän.
     */
    public void lisaaPiste(String nimi, int piste) {
        lataaPisteet();
        pisteet.add(new Piste(nimi, piste));
        paivitaPisteet();
    }

    /**
     * Yrittää ladata annetusta tiedostosta pistetilanteen ja lukee sen
     * ArrayListille. Ottaa huomioon tyypillisimpiä ongelmia latausmetodin
     * käsittelyn suhteen.
     */
    public void lataaPisteet() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(pisteTiedosto));
            pisteet = (ArrayList<Piste>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Lataus] FileNotFound Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Lataus] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Lataus] ClassNotFound Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Lataus] IO Error: " + e.getMessage());
            }
        }
    }

    /**
     * Yrittää ladata tiedostoon ArrayListiltä tiedot talteen ja ottaa huomioon
     * muutamia tyypillisimpiä virhetilanteita.
     */
    public void paivitaPisteet() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(pisteTiedosto));
            outputStream.writeObject(pisteet);
        } catch (FileNotFoundException e) {
            System.out.println("[Päivitys] FileNotFound Error: " + e.getMessage() + ", ohjelma yrittää luoda uuden tiedoston.");
        } catch (IOException e) {
            System.out.println("[Päivitys] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Päivitys] Error: " + e.getMessage());
            }
        }
    }

    /**
     * Rakentaa 10 korkeimman pistetuloksen tilanteesta String -olion
     * annettavaksi tulostusta varten.
     *
     * @return
     */
    public String palautaPisteetStringina() {
        String pisteetStringina = "";
        int maara = 10;

        ArrayList<Piste> scores;
        pisteet = palautaPisteet();

        int i = 0;
        int x = pisteet.size();
        if (x > maara) {
            x = maara;
        }

        while (i < x) {
            pisteetStringina += (i + 1) + ".\t" + pisteet.get(i).getNimi()
                    + "\t\t" + pisteet.get(i).getPisteet() + "\n";
            i++;
        }
        return pisteetStringina;
    }
}

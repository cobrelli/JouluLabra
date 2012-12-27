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
 *
 * @author vito
 */
public class Tulokset {

    private ArrayList<Piste> pisteet;
    public static final String pisteTiedosto = "pisteet.dat";
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public Tulokset() {
        this.pisteet = new ArrayList<>();
    }

    public ArrayList<Piste> getPisteet() {
        lataaPisteet();
        Collections.sort(pisteet);
        return pisteet;
    }

    public void lisaaPiste(String nimi, int piste) {
        lataaPisteet();
        pisteet.add(new Piste(nimi, piste));
        paivitaPisteet();
    }

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
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }

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

    public String getPisteetStringina() {
        String pisteetStringina = "";
        int maara = 10;

        ArrayList<Piste> scores;
        pisteet = getPisteet();

        int i = 0;
        int x = pisteet.size();
        if (x > maara) {
            x = maara;
        }
        
        while (i < x) {
            pisteetStringina += (i + 1) + ".\t" + pisteet.get(i).getNimi() + 
                    "\t\t" + pisteet.get(i).getPisteet() + "\n";
            i++;
        }
        return pisteetStringina;
    }
}

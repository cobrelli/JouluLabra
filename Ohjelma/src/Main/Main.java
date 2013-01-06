package Main;

import Peli.Peli;

/**
 * Main luokka joka sisältää käynnistyksen yhteydessä ajettavan main metodin.
 *
 * @author Cobrelli
 */
public class Main {

    /**
     * Main metodi joka hoitaa pelin luomisen ja käynnistämisen
     *
     * @param args
     */
    public static void main(String[] args) {

        Peli peli = new Peli();
        peli.kaynnista();
    }
}

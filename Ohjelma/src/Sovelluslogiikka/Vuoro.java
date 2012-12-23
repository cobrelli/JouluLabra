/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Yksikot.Yksikko;
import Yksikot.Ryhma;
import Viholliset.HirvioRyhma;

/**
 *
 * @author vito
 */
public class Vuoro {

    private Ryhma party;
    private int indeksi;
    private Yksikko nykyinen;
    private AI ai;
    private HirvioRyhma mash;

    public Vuoro(Ryhma party, HirvioRyhma mash) {
        this.party = party;
        this.indeksi = 0;
        this.nykyinen = party.palautaHahmot().get(this.indeksi);
        this.mash = mash;
        this.ai = new AI(party, mash);
    }

    public Yksikko getVuoro() {
        return this.nykyinen;
    }

    public int getIndeksi() {
        return this.indeksi;
    }

    public int getKoko() {
        return this.party.palautaHahmot().size();
    }

    public void seuraavaVuoro() {
        if (party.isEmpty()) {
            System.out.println("GAME OVER");
            System.exit(0);
            return;
        }

//        if (this.indeksi > getKoko() - 1) {
//            //implementoi vuoron vaihto monstereille tähän, nyt testimielessä nollaa laskurin
//            System.out.println("vaihto");
//            ai.liikuKohtiLahinta();
//            this.indeksi = 0;
//        }

        this.indeksi++;

        if (this.indeksi > getKoko() - 1) {
            //implementoi vuoron vaihto monstereille tähän, nyt testimielessä nollaa laskurin
            System.out.println("vaihto");
            ai.liikuKohtiLahinta();
            this.indeksi = 0;
        }
        if (party.isEmpty()) {
            System.out.println("GAME OVER");
            System.exit(0);
            return;
        }

        nykyinen = this.party.palautaHahmot().get(this.indeksi);

    }
}

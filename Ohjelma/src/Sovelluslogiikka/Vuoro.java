/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Peli.Peli;
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
    Peli peli;

    public Vuoro(Ryhma party, HirvioRyhma mash, Peli peli) {
        this.party = party;
        this.indeksi = 0;
        this.nykyinen = party.palautaHahmot().get(this.indeksi);
        this.mash = mash;
        this.ai = new AI(party, mash);
        this.peli = peli;
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
            peli.tulosRuutu();
            return;
        }

        if (mash.palautaMosat().isEmpty()) {
            peli.seuraavaTaso();
            return;
        }

        this.indeksi++;

        if (this.indeksi > getKoko() - 1) {
            System.out.println("vaihto");
            ai.liikuKohtiLahinta();
            this.indeksi = 0;
        }
        if (party.isEmpty()) {
            peli.tulosRuutu();
            return;
        }

        nykyinen = this.party.palautaHahmot().get(this.indeksi);
    }
}

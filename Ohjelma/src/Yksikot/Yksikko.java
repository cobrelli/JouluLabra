package Yksikot;

/**
 * Abstrakti yläluokka muille hahmoluokille. Sisältää keskeiset komennot
 * aliluokkia, kuten Fighter:a varten.
 *
 * @author Cobrelli
 */
public abstract class Yksikko {

    /**
     * Hp kertoo yksikön nykyiset osumapisteet. Kun ne vähenevät nollaan pelaaja
     * merkitään kuolleeksi.
     *
     * HpMax kertoo yksikön suurimmat mahdolliset osumapisteet.
     *
     * elossa kertoo yksikön sen hetkisen tilan. Jos yksikkö on elossa arvo on
     * True, jos kuollut False.
     *
     * nimi kertoo yksikön nimen.
     *
     * charClassID kertoo yksikön tunnisteen.
     *
     * x kertoo yksikön sijainnin ruudulla x -akselin mukaisesti.
     *
     * y kertoo yksikön sijainnin ruudulla y -akselin mukaisesti.
     *
     * vahinko kertoo paljon yksikkö aiheuttaa vahinkoa törmätessään hirviöön.
     *
     * kuvanSijainti kertoo missä yksikköä kuvaava kuva sijaitsee.
     */
    private int Hp;
    private int HpMax;
    private boolean elossa;
    private String nimi;
    private String charClassID;
    private int x;
    private int y;
    private int vahinko;
    String kuvanSijainti;

    /**
     * Luokan konstruktori, jolla luodaan uusi hahmo halutulla nimellä
     * varustettuna.
     *
     * @param nimi Hahmolle annettu nimi talletetaan oliolle.
     */
    public Yksikko(String nimi) {

        this.nimi = nimi;
        this.elossa = true;
        this.charClassID = "";

    }

    /**
     * Asettaa hahmon paikan x -akselilla.
     *
     * @param x Paikka x -akselilla kenttä matriisissa.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Asettaa hahmon paikan y -akselilla.
     *
     * @param y Paikka y -akselilla kenttä matriisissa.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Palauttaa hahmon paikan x -akselilla.
     *
     * @return Paikka x -akselillä kenttä matriisissa.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Palauttaa hahmon paikan y -akselilla.
     *
     * @return Paikka x -akselillä kenttä matriisissa.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Alustaa täysiksi statseiksi max statsit.
     */
    public void alustaStatsit() {
        this.Hp = HpMax;
    }

    /**
     * Hahmoluokan ID:n getteri
     *
     * @return Palauttaa hahmoluokan CharClassID:n
     */
    public String getCharClassID() {
        return this.charClassID;
    }

    /**
     * Hahmoluokan ID:n setteri
     *
     * @param ID Asettaa CharClassID:lle uuden määritellyn Stringin.
     */
    public void setCharClassID(String ID) {
        this.charClassID = ID;
    }

    /**
     * Kasvattaa tämänhetkistä Hp määrää.
     *
     * @param maara Asennettu parametri lisätään Hp attribuuttiin.
     */
    public void lisaaHp(int maara) {

        if (!elossa) {
            return;
        }

        if (this.Hp + maara > this.HpMax) {
            this.Hp = this.HpMax;
        } else {
            this.Hp += maara;
        }
    }

    /**
     * Vahentaa nykyisen Hp:n määrää.
     *
     * @param maara Hp:ta vähennetään maara:n verran
     */
    public void vahennaHp(int maara) {
        if (!elossa) {
            return;
        }
        if (this.Hp - maara < 1) {
            this.elossa = false;
            this.Hp = -1;
        } else {
            this.Hp -= maara;
        }
    }

    /**
     * Nykyisen Hp määrän getteri
     *
     * @return Palauttaa nykyisen Hp määrän
     */
    public int getHp() {
        return this.Hp;
    }

    /**
     * HpMax Setteri
     *
     * @param uusi Asettaa HpMaxin tähän arvoon.
     */
    public void setHpMax(int uusi) {
        this.HpMax = uusi;
    }

    /**
     * HpMax getteri
     *
     * @return Palauttaa HpMax.
     */
    public int getHpMax() {
        return this.HpMax;
    }

    /**
     * getteri booleanille, joka kertoo onko kyseinen yksikkö elossa.
     *
     * @return Palauttaa booleanin elossa
     */
    public boolean getIsAlive() {
        return elossa;
    }

    /**
     * Käytetään elossaolon tulostukseen esim toStringissä.
     *
     * @return Palauttaa tyhjää jos elossa, R.I.P, jos kuollut.
     */
    public String onkoElossa() {
        if (elossa) {
            return "";
        }
        return "R.I.P";
    }

    /**
     * Getteri
     *
     * @return Palauttaa yksikön vahinkoarvon.
     */
    public int getVahinko() {
        return this.vahinko;
    }

    /**
     * Setteri
     *
     * @param uusi Kertoo uuden asetettavan vahingon arvon.
     */
    public void setVahinko(int uusi) {
        this.vahinko = uusi;
    }

    /**
     * Getteri
     *
     * @return Palauttaa stringinä polun kuvaan.
     */
    public String getKuvanSijainti() {
        return this.kuvanSijainti;
    }

    /**
     * Setteri
     *
     * @param sijainti Yksikön kuvan uusi sijainti.
     */
    public void setKuvanSijainti(String sijainti) {
        this.kuvanSijainti = sijainti;
    }

    @Override
    public String toString() {
        return this.nimi + " " + this.charClassID + " HP: (" + getHp() + "/"
                + getHpMax() + ") " + onkoElossa();
    }
}
package Viholliset;

/**
 * Yliluokka Monster, jonka aliluokkia ovat erilaiset vihollisyksiköt.
 *
 * @author Cobrelli
 */
public abstract class Hirvio {

    private int Hp;
    private int HpMax;
    private boolean elossa;
    private String nimi;
    private String monsterClassID;
    private int x;
    private int y;
    private int palkkio;
    private int vahinko;

    /**
     * Luokan konstruktori, joka luo uuden olion halutulla nimellä ja alustaa
     * sen attribuutit.
     *
     * @param nimi Olion nimi.
     */
    public Hirvio(String nimi) {

        this.nimi = nimi;
        this.elossa = true;
        this.monsterClassID = "";

    }

    /**
     * Asettaa olion paikan x akselilla.
     *
     * @param x Määrää mihin paikkaan x akselia olio sijoittuu matriisissa.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Asettaa olion paikan y akselilla.
     *
     * @param y Määrää mihin paikkaan y akselia olio sijoittuu matriisissa.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Olion paikan x akselin getteri.
     *
     * @return Palauttaa olion paikan x akselilla.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Olion paikan y akselin getteri.
     *
     * @return Palauttaa olion paikan y akselilla.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Alustaa vihollisyksikön nykyisen hp arvon olemaan sama kuin sen HpMax
     * arvo.
     */
    public void alustaStatsit() {
        this.Hp = HpMax;
    }

    /**
     * Asettaa vihollisyksikön ID:n halutuksia.
     *
     * @param ID Asettaa parametrina annetun Stringin olion ID:ksi.
     */
    public void setMonsterClassID(String ID) {
        this.monsterClassID = ID;
    }

    /**
     * Monsterin ID:n getteri.
     *
     * @return Palauttaa ID:n Stringinä.
     */
    public String getMonsterClassID() {
        return this.monsterClassID;
    }

    /**
     * Lisää hp:ta halutulla määrällä. Tarkistaa onko hirviö elossa, jos on niin
     * hp:ta ei kasvateta. Hp kasvaa maksimissaan HpMax arvoon asti.
     *
     * @param maara kertoo arvon jolla Hp:ta kasvatetaan.
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
     * Vähentää monsterin hp:ta halutulla määrällä. Jos yksikkö ei elossa, ei
     * tehdä mitään. Jos laskee alle nollan asetetaan olio kuolleeksi ja hp
     * -1:ksi.
     *
     * @param maara Kertoo määrän jolla Hp:ta vähennetään.
     */
    public void vahennaHp(int maara) {
        if (!elossa) {
            return;
        }
        if (this.Hp - maara <= 0) {
            this.elossa = false;
            this.Hp = -1;
        } else {
            this.Hp -= maara;
        }
    }

    /**
     * Hp attribuutin getteri.
     *
     * @return Palauttaa nykyisen hp:n.
     */
    public int getHp() {
        return this.Hp;
    }

    /**
     * HpMax attribuutin getteri.
     *
     * @return Palauttaa maksimi hp:n.
     */
    public int getHpMax() {
        return this.HpMax;
    }

    /**
     * HpMax attribuutin setteri.
     *
     * @param uusi Asettaa HpMax arvoksi arvon uusi.
     */
    public void setHpMax(int uusi) {
        this.HpMax = uusi;
        this.Hp = HpMax;
    }

    /**
     * Kertoo onko yksikkö elossa.
     *
     * @return Palauttaa elossa attribuutin arvon.
     */
    public boolean isAlive() {
        return elossa;
    }

    /**
     * Palauttaa esimerkiksi toStringiä varten hengissäolotilanteen mukaisesti
     * tekstin
     *
     * @return Jos elossa palattaa tyhjän, jos ei ole elossa palauttaa R.I.P.
     */
    public String onkoElossa() {
        if (elossa) {
            return "";
        }
        return "R.I.P";
    }

    /**
     * Setteri
     *
     * @param palkkio Arvo joka asetetaan hirviön palkkioattribuutiksi.
     */
    public void setPalkkio(int palkkio) {
        this.palkkio = palkkio;
    }

    /**
     * Getteri
     *
     * @return Palauttaa hirviön palkkio attribuutin.
     */
    public int getPalkkio() {
        return this.palkkio;
    }

    @Override
    public String toString() {
        return this.nimi + " " + this.monsterClassID + " HP: (" + getHp()
                + "/" + getHpMax() + ") " + onkoElossa();
    }

    /**
     * Getteri
     *
     * @return Palauttaa hirviön vahinkoattribuutin.
     */
    public int getVahinko() {
        return this.vahinko;
    }

    /**
     * Setteri
     *
     * @param vahinko Kertoo uuden asetettavan hirviön vahinkoattribuutin arvon.
     */
    public void setVahinko(int vahinko) {
        this.vahinko = vahinko;
    }
}

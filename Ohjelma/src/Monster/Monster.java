package Monster;

/**
 * Yliluokka Monster, jonka aliluokkia ovat erilaiset vihollisyksiköt.
 * @author Cobrelli
 */
public abstract class Monster {

    private int Hp;
    private int HpMax;
    private boolean elossa;
    private String nimi;
    private String monsterClassID;
    private int x;
    private int y;

    /**
     * Luokan konstruktori, joka luo uuden olion halutulla nimellä ja alustaa
     * sen attribuutit.
     * @param nimi      Olion nimi. 
     */
    public Monster(String nimi) {

        this.nimi = nimi;
        this.elossa = true;
        this.monsterClassID = "";

    }

    /**
     * Asettaa olion paikan x akselilla.
     * @param x     Määrää mihin paikkaan x akselia olio sijoittuu matriisissa.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Asettaa olion paikan y akselilla.
     * @param y     Määrää mihin paikkaan y akselia olio sijoittuu matriisissa.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Olion paikan x akselin getteri.
     * @return      Palauttaa olion paikan x akselilla.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Olion paikan y akselin getteri.
     * @return      Palauttaa olion paikan y akselilla.
     */
    public int getY() {
        return this.y;
    }

    /**
     *
     */
    public void alustaStatsit() {
        this.Hp = HpMax;
    }

    /**
     *
     * @param ID
     */
    public void setMonsterClassID(String ID) {
        this.monsterClassID = ID;
    }

    /**
     *
     * @return
     */
    public String getMonsterClassID(){
        return this.monsterClassID;
    }
    
    /**
     *
     * @param maara
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
     *
     * @param maara
     */
    public void vahennaHp(int maara) {
        if (!elossa) {
            return;
        }
        if (this.Hp - maara < 0) {
            this.elossa = false;
            this.Hp = -1;
        } else {
            this.Hp -= maara;
        }
    }

    /**
     *
     * @return
     */
    public int getHp() {
        return this.Hp;
    }
    
    /**
     *
     * @return
     */
    public int getHpMax(){
        return this.HpMax;
    }

    /**
     *
     * @param uusi
     */
    public void setHpMax(int uusi) {
        this.HpMax = uusi;
        this.Hp = HpMax;
    }

    /**
     *
     * @return
     */
    public boolean isAlive() {
        return elossa;
    }

    /**
     *
     * @return
     */
    public String onkoElossa() {
        if (elossa) {
            return "";
        }
        return "R.I.P";
    }

    @Override
    public String toString() {
        return this.nimi + " " + this.monsterClassID + " HP: (" + getHp() 
                + "/" + getHpMax() + ") " +onkoElossa();
    }
}

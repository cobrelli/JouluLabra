package CharClass;

/**
 * Abstrakti yläluokka muille hahmoluokille. Sisältää keskeiset komennot aliluokkia,
 * kuten Fighter:a varten.
 * 
 * @author Cobrelli
 */
public abstract class CharClass {

    private int Hp;
    private int HpMax;
    private int Mp;
    private int MpMax;
    private boolean elossa;
    private String nimi;
    private String charClassID;
    private int x;
    private int y;
    
    /**
     * Luokan konstruktori, jolla luodaan uusi hahmo halutulla nimellä 
     * varustettuna.
     * 
     * @param nimi      Hahmolle annettu nimi talletetaan oliolle.
     */
    public CharClass(String nimi) {

        this.nimi = nimi;
        this.elossa = true;
        this.charClassID = "";
        
    }

    /**
     * Asettaa hahmon paikan x -akselilla.
     * @param x     Paikka x -akselilla kenttä matriisissa.
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * Asettaa hahmon paikan y -akselilla.
     * @param y     Paikka y -akselilla kenttä matriisissa.
     */
    public void setY(int y){
        this.y = y;
    }
    
    /**
     * Palauttaa hahmon paikan x -akselilla.
     * @return      Paikka x -akselillä kenttä matriisissa.
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Palauttaa hahmon paikan y -akselilla.
     * @return      Paikka x -akselillä kenttä matriisissa.
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Alustaa täysiksi statseiksi max statsit.
     */
    public void alustaStatsit(){
        this.Hp = HpMax;
        this.Mp = MpMax;
    }
    
    /**
     * Hahmoluokan ID:n getteri
     * @return      Palauttaa hahmoluokan CharClassID:n
     */
    public String getCharClassID(){
        return this.charClassID;
    }
    
    /**
     * Hahmoluokan ID:n setteri
     * @param ID    Asettaa CharClassID:lle uuden määritellyn Stringin.
     */
    public void setCharClassID(String ID){
        this.charClassID = ID;
    }
    
    /**
     * Kasvattaa tämänhetkistä Hp määrää.
     * @param maara     Asennettu parametri lisätään Hp attribuuttiin.
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
     * @param maara     Hp:ta vähennetään maara:n verran
     */
    public void vahennaHp(int maara) {
        if (!elossa) {
            return;
        }
        if (this.Hp - maara < 1) {
            this.elossa = false;
            this.Hp = -1;
        }else{
            this.Hp -= maara;
        }
    }

    /**
     * Nykyisen Hp määrän getteri
     * @return      Palauttaa nykyisen Hp määrän
     */
    public int getHp() {
        return this.Hp;
    }
    
    /**
     * HpMax Setteri
     * @param uusi      Asettaa HpMaxin tähän arvoon.
     */
    public void setHpMax(int uusi){
        this.HpMax = uusi;
    }
    
    /**
     * MpMax setteri
     * @param uusi      Asettaa MpMaxin tähän arvoon.
     */
    public void setMpMax(int uusi){
        this.MpMax = uusi;
    }
    
    /**
     * HpMax getteri
     * @return      Palauttaa HpMax.
     */
    public int getHpMax(){
        return this.HpMax;
    }
    
    /**
     * MpMax getteri
     * @return      Palauttaa MpMax.
     */
    public int getMpMax(){
        return this.MpMax;
    }
    
    /**
     * Lisää Mp attribuuttia maaran verran ja tarkistaa ettei ylitä maksimia
     * @param maara     Lisataan nykyisiin Mp
     */
    public void lisaaMp(int maara) {

        if (this.Mp + maara > this.MpMax) {
            this.Mp = this.MpMax;
        } else {
            this.Mp += maara;
        }
    }

    /**
     * Vähentää Mp attribuuttia maaran verran ja tarkistaa ettei ylitä maksimia
     * @param maara     Vähennetään nykyisiin Mp
     */
    public void vahennaMp(int maara) {
        
        if (this.Mp - maara < 0) {
            this.Mp = 0;
        }else{
            this.Mp -= maara;
        }
    }

    /**
     * Mp attribuutin getteri
     * @return      Palauttaa Mp
     */
    public int getMp() {
        return this.Mp;
    }
    
    /**
     * getteri booleanille, joka kertoo onko kyseinen yksikkö elossa.
     * @return      Palauttaa booleanin elossa
     */
    public boolean getIsAlive(){
        return elossa;
    }
    
    /**
     *
     * @return
     */
    public String onkoElossa(){
        if(elossa){
            return "";
        }
        return "R.I.P";
    }
    
    @Override
    public String toString(){
        return this.nimi + " " + this.charClassID + " HP: (" + getHp() + ") MP: (" + getMp() + ") " 
                + onkoElossa();
    }
    
}

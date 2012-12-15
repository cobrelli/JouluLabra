package Monster;

public abstract class Monster {

    private int Hp;
    private int HpMax;
    private boolean elossa;
    private String nimi;
    private String monsterClassID;
    private int x;
    private int y;

    public Monster(String nimi) {

        this.nimi = nimi;
        this.elossa = true;
        this.monsterClassID = "";

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void alustaStatsit() {
        this.Hp = HpMax;
    }

    public void setMonsterClassID(String ID) {
        this.monsterClassID = ID;
    }

    public String getMonsterClassID(){
        return this.monsterClassID;
    }
    
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

    public int getHp() {
        return this.Hp;
    }
    
    public int getHpMax(){
        return this.HpMax;
    }

    public void setHpMax(int uusi) {
        this.HpMax = uusi;
        this.Hp = HpMax;
    }

    public boolean isAlive() {
        return elossa;
    }

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

package Models;

public class Pokemon {

    String name;
    String dexNum;
    String type;
    String attack;
    String defense;
    String speed;
    String spdef;
    String spatk;
    String hp;
    
    /*In the Pokemon games, each Pokemon has a name, A Dex Number (Fixed Position on the Pokedex), and stats that include:
    HP (Health Points)
    Attack (The amount of physical damage it can do)
    Defense (The amount of physical damage it can resist)
    Special Attack (The amount of non physical damage it can do)
    Special Defense (The amount of non physical damage it can take)
    Speed (How fast it is, this determines who moves first)
    */
    public Pokemon(String name, String dexNum, String type, String hp, String attack, String defense, String spdef, String spatk, String speed) {
        this.name = name;
        this.dexNum = dexNum;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.spdef = spdef;
        this.spatk = spatk;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDexNum() {
        return dexNum;
    }

    public void setDexNum(String dexNum) {
        this.dexNum = dexNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSpdef() {
        return spdef;
    }

    public void setSpdef(String spdef) {
        this.spdef = spdef;
    }

    public String getSpatk() {
        return spatk;
    }

    public void setSpatk(String spatk) {
        this.spatk = spatk;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
    
    
}

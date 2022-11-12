// Monster class which is used to create monsters
// extends the Creature class
public class Monster extends Creature{
    private int damage;
    private int defense;
    private double dodgeChance;
    private int type;

    Monster(){

    }
    Monster(int damage, int defense, String name, int level, int dodgeChance, int type){
        super(name, level);
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName(){
        return super.name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public double getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void normalize(){
        damage = damage/level;
        defense = defense/level;
        level = 1;
    }

    public void scaleWithLevel(int heroLevel){
        if(this.type==1){
            hitPoints = heroLevel*100;
            level = heroLevel;
            defense = defense + (5*heroLevel);
            dodgeChance = dodgeChance*0.1;
            damage = damage + (3*heroLevel);
        } else if (this.type==2) {
            hitPoints = heroLevel*100;
            level = heroLevel;
            defense = defense + (3*heroLevel);
            dodgeChance = dodgeChance*0.1;
            damage = damage + (5*heroLevel);
        }
        else {
            hitPoints = heroLevel*100;
            level = heroLevel;
            defense = defense + (3*heroLevel);
            dodgeChance = dodgeChance*0.3;
            damage = damage + (3*heroLevel);
        }
    }
}

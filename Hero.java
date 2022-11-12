import java.util.ArrayList;
// Hero class which extends the creature class
public class Hero extends Creature{
    private int mana;
    private double strength;
    private double agility;
    private double dexterity;
    private int Money;
    private int Experience;
    private ArrayList<Item> items;
    private ArrayList<Weapon> Weapons;
    private ArrayList<Potion> Potions;
    private ArrayList<Spell> Spells;
    private ArrayList<Armor> Armor;
    private int type;

    Hero(){

    }

    Hero(int mana, int strength, int agility, int dexterity, int startingMoney, int startingExperience, String name, int level,ArrayList<Item> items, int type){
        super(name, level);
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.Money = startingMoney;
        this.Experience = startingExperience;
        this.type=type;
        this.items = new ArrayList<>();
        this.Weapons = new ArrayList<>();
        this.Potions = new ArrayList<>();
        this.Spells = new ArrayList<>();
        this.Armor = new ArrayList<>();
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public double getStrength() {
        return strength;
    }
    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getAgility() {
        return agility;
    }
    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getDexterity() {
        return dexterity;
    }
    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }
    public int getMoney() {
        return Money;
    }

    public void setMoney(int val){
        this.Money = val;
    }

    public int getExperience() {
        return Experience;
    }

    public ArrayList<Item> getItems() {
        return items;

    }
    public ArrayList<Armor> getArmors() {
        return Armor;

    }

    public void setHitPoints(double hp){
        super.hitPoints = hp;
    }
    public void setExperience(int exp){
        Experience = exp;
    }
    public ArrayList<Weapon> getWeapons() {
        return Weapons;
    }
    public ArrayList<Potion> getPotions() {
        return Potions;
    }
    public ArrayList<Spell> getSpells() {
        return Spells;
    }

    public int getLevel(){
        return super.level;
    }

    public String getName(){return super.name;}

    public int getType(){
        return type;
    }
}

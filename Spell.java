//spell class which extends the Item class
public class Spell extends Item{
    private int damage;
    private int manaCost;
    private int type;
    Spell(int damage, int manaCost, String name, double cost, int requiredLevel, int type){
            super(name,cost,requiredLevel);
            this.damage = damage;
            this.manaCost = manaCost;
            this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public int getType() {
        return type;
    }

    public int getManaCost() {
        return manaCost;
    }
}

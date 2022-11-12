// Weapon class which extends the Item class
public class Weapon extends Item{
    private int damage;
    private int requiredHands;
    Weapon(int damage, int requiredHands, String name, double cost, int requiredLevel){
        super(name,cost,requiredLevel);
        this.damage = damage;
        this.requiredHands = requiredHands;
    }

    public int getDamage() {
        return damage;
    }

    public int getRequiredHands(){
        return requiredHands;
    }
}

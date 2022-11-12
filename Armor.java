//Armor class for creating armors in the RPG
public class Armor extends Item{
    private int damageReduction;
    //Armor class constructor
    Armor(int damageReduction, String name, double cost, int requiredLevel){
        super(name,cost,requiredLevel);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }
}
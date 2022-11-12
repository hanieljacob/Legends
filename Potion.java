// Potion class which extends the Item class
public class Potion extends Item{
    private int attributeIncrease;
    private String attributeAffected;
    Potion(String name, double cost, int requiredLevel, int attributeIncrease, String attributeAffected){
        super(name, cost, requiredLevel);
        this.attributeAffected = attributeAffected;
        this.attributeIncrease = attributeIncrease;
    }

    public int getAttributeIncrease() {
        return attributeIncrease;
    }

    public String getAttributeAffected() {
        return attributeAffected;
    }
}

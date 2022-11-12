// Item class which is used to create Armors, Weapons, Spells and Potions
public class Item {
    private String name;
    private double cost;
    private int requiredLevel;
    Item(String name, double cost, int requiredLevel){
        this.name = name;
        this.cost = cost;
        this.requiredLevel = requiredLevel;
    }

    public String getName(){
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    public int getRequiredLevel(){
        return this.requiredLevel;
    }
}

// Creature super class which is common to both heroes and monsters
public class Creature {
    protected String name;
    protected int level;
    protected double hitPoints;
    public Creature(){

    }
    public Creature(String name, int level){
        this.name = name;
        this.level = level;
        this.hitPoints = 100.0 * level;
    }
}

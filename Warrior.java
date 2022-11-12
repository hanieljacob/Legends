import java.util.ArrayList;
// Warrior class which extends the Hero class
public class Warrior extends Hero{
    public Warrior(int mana, int strength, int agility, int dexterity, int Money, int Experience, String name, int level, ArrayList<Item> items){
        super(mana,strength,agility,dexterity,Money,Experience,name,level, items,1);
    }
}

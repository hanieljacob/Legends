import java.util.ArrayList;
// Sorcerer class which extends the Hero class
public class Sorcerer extends Hero{
        public Sorcerer(int mana, int strength, int agility, int dexterity, int startingMoney, int startingExperience, String name, int level, ArrayList<Item> items){
            super(mana,strength,agility,dexterity,startingMoney,startingExperience,name,level, items,2);
        }
}

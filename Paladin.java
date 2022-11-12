import java.util.ArrayList;
// Paladin class which extends the Hero class
public class Paladin extends Hero{
        public Paladin(int mana, int strength, int agility, int dexterity, int startingMoney, int startingExperience, String name, int level, ArrayList<Item> items){
            super(mana,strength,agility,dexterity,startingMoney,startingExperience,name,level, items,3);
        }
}

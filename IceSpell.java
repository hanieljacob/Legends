//Ice spell class which is a type of Spell
public class IceSpell extends Spell{
    int type;
    IceSpell(int damage, int manaCost, String name, double cost, int requiredLevel){
        super(damage, manaCost, name, cost, requiredLevel,1);
        type=2;
    }
}

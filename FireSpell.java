// FireSpell class which extends the Spell class
// The type attribute passed to the super class is to identify the type of spell (fire spell)
public class FireSpell extends Spell{
    int type;
    FireSpell(int damage, int manaCost, String name, double cost, int requiredLevel){
        super(damage, manaCost, name, cost, requiredLevel,2);
        type=1;
    }
}

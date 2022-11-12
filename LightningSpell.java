// Lightning spell class which extends the spell super class
public class LightningSpell extends Spell{
    LightningSpell(int damage, int manaCost, String name, double cost, int requiredLevel){
        super(damage, manaCost, name, cost, requiredLevel,3);
    }
}

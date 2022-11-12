// Exoskeleton class which extends the Monster class
// The type attribute passed to the super class is to identify the type of monster (Exoskeleton)
public class Exoskeleton extends Monster{
    Exoskeleton(int damage, int defense, String name, int level, int dodgeChance) {
        super(damage, defense, name, level, dodgeChance,1);
    }
}

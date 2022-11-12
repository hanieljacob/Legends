// Dragon class which extends the Monster class
// The type attribute passed to the super class is to identify the type of monster (dragon)
public class Dragon extends Monster{
    Dragon(int damage, int defense, String name, int level, int dodgeChance) {
        super(damage,defense,name,level,dodgeChance,2);
    }
}
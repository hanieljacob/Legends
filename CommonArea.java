import java.util.ArrayList;
import java.util.Scanner;

// Class which is used to handle monster fights
public class CommonArea {
    int monsterNum;
    ArrayList<Hero> party;
    ArrayList<Hero> aliveParty;
    Monster currentMonster;
    Hero currentHero;
    int iteration;
    Scanner scan;

    CommonArea() {
        monsterNum = 0;
        party = new ArrayList<>();
        aliveParty = new ArrayList<>();
        currentMonster = new Monster();
        iteration = 0;
        scan = new Scanner(System.in);
    }

    //Method which spawns a monster 50% of the time
    void Enter(int highestHeroLevel, Monsters monsters) {
        monsterNum = Randomizer.Randomize(1, 6);
        if (monsterNum <= 3) {
                party = new Party().getTeam();
                aliveParty.addAll(party);
                for (iteration = 0; iteration < party.size(); iteration++) {
                    spawnMonster(highestHeroLevel, monsters);
                }
        }
    }

    //Method to spawn the monster, normalize and scale the attributes of the monster based on the hero's level
    void spawnMonster(int highestHeroLevel, Monsters monsters) {
        System.out.println("Monster encountered!");
        if (monsterNum == 1)
            currentMonster = monsters.getExoskeletonList().get(Randomizer.Randomize(0, monsters.getExoskeletonList().size() - 1));
        else if (monsterNum == 2)
            currentMonster = monsters.getDragonList().get(Randomizer.Randomize(0, monsters.getDragonList().size() - 1));
        else
            currentMonster = monsters.getSpiritList().get(Randomizer.Randomize(0, monsters.getSpiritList().size() - 1));
        currentMonster.normalize();
        currentMonster.scaleWithLevel(highestHeroLevel);
        currentHero = party.get(iteration);
        battleMonster();
    }

    //Method to battle a monster
    void battleMonster() {
        int choice;
        showStats();
        while (true) {
            // hero actions
            System.out.println("What will " + currentHero.getName() + " do?");
            System.out.println("1. Attack");
            System.out.println("2. Cast a spell");
            System.out.println("3. Use a potion");
            System.out.println("4. Change armor");
            System.out.println("5. Change weapon");
            System.out.println("6. Quit game");
            choice = Validator.Validate();
            // Attacking with the hero's default weapon
            if (choice == 1) {
                if(Randomizer.Randomize(1,100) < currentMonster.getDodgeChance())
                    System.out.println(currentMonster.getName() + " dodged the attack from " + currentHero.getName());
                else {
                    if (!currentHero.getWeapons().isEmpty()) {
                        System.out.println(currentHero.getName() + " inflicted " + (currentHero.getStrength() +
                                currentHero.getWeapons().get(0).getDamage() * 0.005)
                                + " damage to " + currentMonster.getName() + " using " + currentHero.getWeapons().get(0).getName());
                        currentMonster.hitPoints -= ((currentHero.getStrength() + currentHero.getWeapons().get(0).getDamage() * 0.005));
                    }
                    else{
                        System.out.println(currentHero.getName() + " inflicted " + (currentHero.getStrength()* 0.1 *currentHero.getLevel())
                                + " damage to " + currentMonster.getName());
                        currentMonster.hitPoints -= currentHero.getStrength()* 0.1 *currentHero.getLevel();
                    }
                    if (currentMonster.hitPoints <= 0) {
                        monsterDefeated();
                        break;
                    }
                }
                        if (Randomizer.Randomize(1, 100) < currentHero.getAgility() * 0.002)
                            System.out.println(currentHero.getName() + " dodged the attack from " + currentMonster.getName());
                            else{
                            System.out.println("Monster inflicted " + currentMonster.getDamage() + " damage to " + currentHero.getName());
                            currentHero.hitPoints -= currentMonster.getDamage();
                            if (currentHero.hitPoints <= 0) {
                                heroDefeated();
                            }
                        }
            }
            // Casting a spell
            else if (choice==2){
                Spell spell;
                System.out.println("Which spell would you like to cast?");
                if(currentHero.getSpells().isEmpty()) {
                    System.out.println("No spells in inventory!");
                    continue;
                }
                displaySpells();
                spell = chooseSpell();
                if(currentHero.getMana()>= spell.getManaCost()) {
                    useSpell(spell);
                    break;
                }
            }
            // Using a potion
            else if(choice==3){
                Potion potion;
                System.out.println("Which potion would you like to use?");
                if(currentHero.getPotions().isEmpty()) {
                    System.out.println("No potions in inventory!");
                    continue;
                }
                displayPotions();
                potion = choosePotion();
                usePotion(potion);
            }
            // Switch equipped armor
            else if (choice==4) {
                if(currentHero.getArmors().isEmpty()) {
                    System.out.println("No armors in inventory!");
                    continue;
                }
                displayArmors();
                chooseArmor();
            }
            // Switch equipped weapon
            else if (choice==5) {
                if(currentHero.getWeapons().isEmpty()) {
                    System.out.println("No weapons in inventory!");
                    continue;
                }
                displayWeapons();
                chooseWeapon();
            }
            // Exiting current game
            else if (choice==6) {
                char choice2;
                System.out.println("Do you want to play again?(Y/N)");
                choice2 = scan.next().charAt(0);
                if(choice2 == 'y' || choice2 == 'Y')
                    new Start().startGame();
                else
                    System.exit(0);
            }
            else
                System.out.println("Invalid choice");
        }
    }

    // Function to show battle stats for current monster and current hero
    void showStats(){
        System.out.println("Battle Phase");
        System.out.println(currentMonster.getName() + ":");
        System.out.println("level: " + currentMonster.level);
        System.out.println("hit points: " + currentMonster.hitPoints);
        System.out.println("defense: " + currentMonster.getDefense());
        System.out.println();
        System.out.println(currentHero.name + ":");
        System.out.println("level: " + currentHero.level);
        System.out.println("hit points: " + currentHero.hitPoints);
        System.out.println("Mana: " + currentHero.getMana());
        System.out.println();
    }

    // Function to display spell names
    void displaySpells(){
            int num=0;
            for(Item item: currentHero.getSpells()){
                num++;
                System.out.println(num + ". " + item.getName());
            }
    }

    // Function to choose a spell from the hero's inventory
    Spell chooseSpell(){
        int choice;
        Spell spell;
        while (true) {
            choice = Validator.Validate();
            if (choice >= 1 && choice <= currentHero.getSpells().size()) {
                spell = currentHero.getSpells().get(choice-1);
                break;
            } else {
                System.out.println("Invalid choice! choose again");
            }
        }
        return spell;
    }

    // Function to use the chosen spell
    void useSpell(Spell spell){
        currentHero.setMana(currentHero.getMana() - spell.getManaCost());
        System.out.println(currentHero.getName() + " used " + spell.getName());
        currentHero.getSpells().remove(spell);
        if(Randomizer.Randomize(1,100) < currentMonster.getDodgeChance())
            System.out.println(currentMonster.getName() + " dodged the attack");
        else {
            // Ice spells reduce the target's damage
            if (spell.getType() == 1) {
                System.out.println(currentMonster.getName() + "'s damage reduced to " + currentMonster.getDamage() * 0.9);
                currentMonster.setDamage((int) (currentMonster.getDamage() * 0.9));
            }
            // Fire spells reduce the defense of the target
            else if (spell.getType() == 2) {
                System.out.println(currentMonster.getName() + "'s defense reduced to " + currentMonster.getDefense() * 0.9);
                currentMonster.setDefense((int) (currentMonster.getDefense() * 0.9));
            }
            // Lightning spells reduce the dodge chance of the target
            else {
                System.out.println(currentMonster.getName() + "'s dodge chance reduced to " + currentMonster.getDodgeChance() * 0.9);
                currentMonster.setDodgeChance((int) (currentMonster.getDodgeChance() * 0.9));
            }
            //Calculating spell's damage
            System.out.println(currentMonster.getName() + " took " + (spell.getDamage() +
                    ((currentHero.getDexterity()/10000)*spell.getDamage())) + " damage");
            currentMonster.hitPoints -= spell.getDamage() +
                    ((currentHero.getDexterity()/10000)*spell.getDamage());
            if (currentMonster.hitPoints <= 0) {
                monsterDefeated();
                return;
            }
        }
        //Calculating monster's damage
            if(Randomizer.Randomize(1,100) < currentHero.getAgility()*0.002)
                System.out.println(currentMonster.getName() + " dodged the attack from " + currentHero.getName());
            else {
                System.out.println(currentMonster.getName() + " inflicted " + currentMonster.getDamage() + " damage to " + currentHero.getName());
                currentHero.hitPoints -= currentMonster.getDamage();
                if (currentHero.hitPoints <= 0) {
                    heroDefeated();
                }
            }
        }

        // Function to display potions
    void displayPotions(){
        int num=0;
        for(Item item: currentHero.getPotions()){
            num++;
            System.out.println(num + ". " + item.getName());
        }
    }

    // Function to choose a potion from the hero's inventory
    Potion choosePotion(){
        int choice;
        Potion potion;
        while (true) {
            choice = Validator.Validate();
            if (choice >= 1 && choice <= currentHero.getPotions().size()) {
                potion = currentHero.getPotions().get(choice-1);
                break;
            } else {
                System.out.println("Invalid choice! choose again");
            }
        }
        return potion;
    }

    // Function to use a potion
    void usePotion(Potion potion){
        System.out.println(currentHero.getName() + " used " + potion.getName());
        currentHero.getPotions().remove(potion);
        for(String attribute: potion.getAttributeAffected().split("/")){
            if(attribute.equalsIgnoreCase("Health")) {
                currentHero.setHitPoints(currentHero.hitPoints + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " hit points!");
            }
            else if(attribute.equalsIgnoreCase("Strength")) {
                currentHero.setStrength(currentHero.getStrength() + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " strength!");
            }
            else if(attribute.equalsIgnoreCase("Mana")) {
                currentHero.setMana(currentHero.getMana() + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " mana!");
            }
            else if(attribute.equalsIgnoreCase("Agility")) {
                currentHero.setAgility(currentHero.getAgility() + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " agility!");
            }
            else if(attribute.equalsIgnoreCase("Dexterity")) {
                currentHero.setDexterity(currentHero.getDexterity() + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " dexterity!");
            }
            else if(attribute.equalsIgnoreCase("Defense")) {
                currentHero.setHitPoints(currentHero.hitPoints + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " hit points!");
            }
            else {
                currentHero.setHitPoints(currentHero.hitPoints + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " hit points!");
                currentHero.setStrength(currentHero.getStrength() + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " strength!");
                currentHero.setMana(currentHero.getMana() + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " mana!");
                currentHero.setAgility(currentHero.getAgility() + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " agility!");
                currentHero.setDexterity(currentHero.getDexterity() + potion.getAttributeIncrease());
                System.out.println(currentHero.getName() + " gained " + potion.getAttributeIncrease() + " dexterity!");
            }
        }
        System.out.println(currentMonster.getName() + " inflicted " + currentMonster.getDamage() + " damage to" + currentHero.getName());
        currentHero.hitPoints -= currentMonster.getDamage();
            if (currentHero.hitPoints <= 0) {
                heroDefeated();
            }
        }

        // Function to display armors
    void displayArmors(){
        int num=0;
        for(Item item: currentHero.getArmors()){
            num++;
            System.out.println(num + ". " + item.getName());
        }
    }

    // Function to equip the armor from the hero's inventory
    void chooseArmor(){
        int choice;
        Armor armor;
        while (true) {
            choice = Validator.Validate();
            if(choice==1) {
                System.out.println("The Hero has already equipped " + currentHero.getArmors().get(0).getName());
                break;
            }
            else if (choice >= 2 && choice <= currentHero.getArmors().size()) {
                System.out.println("Armor Changed!");
                armor = currentHero.getArmors().get(choice-1);
                currentHero.getArmors().remove(choice-1);
                currentHero.getArmors().add(0,armor);
                break;
            } else {
                System.out.println("Invalid choice! choose again");
            }
        }
    }

    // Function to display the weapons in a hero's inventory
    void displayWeapons(){
        int num=0;
        for(Item item: currentHero.getWeapons()){
            num++;
            System.out.println(num + ". " + item.getName());
        }
    }

    // Function to equip a weapon from a user's inventory
    void chooseWeapon(){
        int choice;
        Weapon weapon;
        while (true) {
            choice = Validator.Validate();
            if(choice==1) {
                System.out.println("The Hero has already equipped " + currentHero.getWeapons().get(0).getName());
                break;
            }
            else if (choice >= 2 && choice <= currentHero.getWeapons().size()) {
                System.out.println("Weapon Changed!");
                weapon = currentHero.getWeapons().get(choice-1);
                currentHero.getWeapons().remove(choice-1);
                currentHero.getWeapons().add(0,weapon);
                break;
            } else {
                System.out.println("Invalid choice! choose again");
            }
        }
    }


    //Function called when a monster is defeated
    void monsterDefeated(){
        System.out.println(currentMonster.getName()+" fainted");
        // Hero gains gold and experience
        System.out.println(currentHero.getName() + " earned " + currentMonster.level*100 + " Gold!");
        currentHero.setMoney(currentHero.getMoney()+currentMonster.level*100);
        System.out.println(currentHero.getName()+" gained " + currentMonster.level + " experience point(s)");
        // Hero levels up when condition is met
        if(currentHero.getExperience()+currentMonster.level>=currentHero.getLevel()*10){
            System.out.println(currentHero.getName()+ " leveled up!");
            currentHero.level++;
            currentHero.setExperience((currentHero.getLevel()*10)-(currentHero.getExperience()+currentMonster.level));
            currentHero.hitPoints = currentHero.level * 100;
            currentHero.setMana((int)(currentHero.getMana() * 1.1));
            if(currentHero.getType()==1) {
                currentHero.setStrength(currentHero.getStrength() + 0.1 * currentHero.getStrength());
                currentHero.setAgility(currentHero.getAgility() + 0.1 * currentHero.getAgility());
                currentHero.setDexterity(currentHero.getDexterity() + 0.05 * currentHero.getDexterity());
            } else if (currentHero.getType()==2) {
                currentHero.setStrength(currentHero.getStrength() + 0.05 * currentHero.getStrength());
                currentHero.setAgility(currentHero.getAgility() + 0.1 * currentHero.getAgility());
                currentHero.setDexterity(currentHero.getDexterity() + 0.1 * currentHero.getDexterity());
            }
            else{
                currentHero.setStrength(currentHero.getStrength() + 0.1 * currentHero.getStrength());
                currentHero.setAgility(currentHero.getAgility() + 0.05 * currentHero.getAgility());
                currentHero.setDexterity(currentHero.getDexterity() + 0.1 * currentHero.getDexterity());
            }
        }
        else
            currentHero.setExperience(currentHero.getExperience()+currentMonster.level);
    }

    // Function called when a hero is defeated
    void heroDefeated(){
        char choice;
        System.out.println(currentHero.getName()+ " fainted");
        aliveParty.remove(currentHero);
        currentHero.setHitPoints(0.5*currentHero.level*100);
        currentHero.setMana((int)(0.5*currentHero.getMana()));
        // When all the heroes in the party are defeated
        if(aliveParty.isEmpty()) {
            System.out.println("GAME OVER! Thanks for Playing\n");
            System.out.println("Play again?(Y/N)");
            choice = scan.nextLine().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                party.clear();
                aliveParty.clear();
                new Start().startGame();
            } else
                System.exit(0);
        }
        else {
            currentHero = aliveParty.get(0);
            battleMonster();
        }

    }

}

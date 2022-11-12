import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Class to create lists of Heroes
public class Heroes{
    private ArrayList<Hero> warriorHeroList;
    private ArrayList<Hero> paladinHeroList;
    private ArrayList<Hero> sorcererHeroList;
    Scanner scan;
    Party party;
    Heroes(){
        warriorHeroList = new ArrayList<>();
        paladinHeroList = new ArrayList<>();
        sorcererHeroList = new ArrayList<>();
        scan = new Scanner(System.in);
        party = new Party();
    }

    // Get the list of heroes from the file and store in different arrayLists based on the type of hero
    public void getHeroes(int type){
        String name;
        String path;
        int mana;
        int strength;
        int agility;
        int dexterity;
        int startingMoney;
        int startingExpereince;
        String[] parts;
        if(type == 1)
            path = "./Warriors.txt";
        else if(type == 2)
            path = "./Paladins.txt";
        else
            path = "./Sorcerers.txt";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine() ) {
                String data = myReader.nextLine();
                parts = data.split("\\s+");
                name = parts[0];
                mana = Integer.parseInt(parts[1]);
                strength = Integer.parseInt(parts[2]);
                agility = Integer.parseInt(parts[3]);
                dexterity = Integer.parseInt(parts[4]);
                startingMoney = Integer.parseInt(parts[5]);
                startingExpereince = Integer.parseInt(parts[6]);
                if(type==1)
                    warriorHeroList.add(new Warrior(mana,strength,agility,dexterity,startingMoney,startingExpereince,name,1, new ArrayList<Item>()));
                else if (type==2)
                    paladinHeroList.add(new Paladin(mana,strength,agility,dexterity,startingMoney,startingExpereince,name,1, new ArrayList<Item>()));
                else
                    sorcererHeroList.add(new Sorcerer(mana,strength,agility,dexterity,startingMoney,startingExpereince,name,1, new ArrayList<Item>()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Display the heroes based on hero type
    void displayHeroes(int type){
        int i=1;
        System.out.println("   Name                     Mana     Strength    Agility    Dexterity" +
                "    Money    Experience    HitPoints");
        if(type == 1)
            for(Hero hero: warriorHeroList) {
                printHeroStats(hero, i);
                i++;
            }
        else if(type == 2) {
            for (Hero hero : paladinHeroList) {
                printHeroStats(hero, i);
                i++;
            }
        }
        else
            for(Hero hero: sorcererHeroList) {
                printHeroStats(hero, i);
                i++;
            }
    }

    // Print hero stats
    void printHeroStats(Hero hero, int heroNum){
        System.out.print(heroNum + ". "+hero.name);
        for(int j=0;j<25-hero.name.length();j++)
            System.out.print(" ");
        System.out.println(hero.getLevel() + "    " + hero.getMana() + "     " + hero.getStrength() + "       " + hero.getAgility() + "       " +
                hero.getDexterity() + "      " + hero.getMoney() + "          " + hero.getExperience() + "          " +
                hero.hitPoints);
        System.out.println();
        if(!hero.getArmors().isEmpty()) {
            System.out.println("Armors:");
            for (Armor armor : hero.getArmors())
                System.out.println("Name: " + armor.getName() + ", Damage Reduction: " + armor.getDamageReduction() + ", Cost: " + armor.getCost());
        }
        if(!hero.getWeapons().isEmpty()) {
            System.out.println("Weapons:");
            for (Weapon weapon : hero.getWeapons())
                System.out.println("Name: " + weapon.getName() + ", Damage: " + weapon.getDamage() + ", Cost: " + weapon.getCost());
        }
        if(!hero.getSpells().isEmpty()) {
            System.out.println("Spells:");
            for (Spell spell : hero.getSpells())
                System.out.println(" Name: " + spell.getName() + ", Damage: " + spell.getDamage() +
                        ", Mana cost: " + spell.getManaCost() + ", Type: " + ((spell.getType() == 1) ? "Ice" :
                        ((spell.getType() == 2) ? "Fire" : "Lightning")) + ", Cost: " + spell.getCost());
        }
        if(!hero.getPotions().isEmpty()) {
            System.out.println("Potions:");
            for (Potion potion : hero.getPotions())
                System.out.println("Name: " + potion.getName() + ", Attribute increase: " +
                        potion.getAttributeIncrease() + ", Attribute(s) Affected: " +
                        potion.getAttributeAffected() + ", Cost: " + potion.getCost());
            System.out.println();
        }
    }

    // Print the items of each hero
    void printHeroItems(Hero hero, int heroNum){
        ArrayList<String> items = new ArrayList<>();
        System.out.print(heroNum + ". "+hero.name);
        for(int j=0;j<25-hero.name.length();j++)
            System.out.print(" ");
        for(Item item: hero.getArmors())
            items.add(item.getName());
        for(Item item: hero.getWeapons())
            items.add(item.getName());
        for(Item item: hero.getSpells())
            items.add(item.getName());
        for(Item item: hero.getPotions())
            items.add(item.getName());
        System.out.println(hero.getMoney() + "   " + items);
    }

    // add the hero to the party of heroes
    void addParty(int heroType){
        int choice;
        while (true) {
            System.out.println("Choose your character");
            displayHeroes(heroType);
            choice = Validator.Validate();
            if(heroType==1){
                if (choice >= 1 && choice <= warriorHeroList.size()) {
                    party.addToParty(warriorHeroList.get(choice - 1));
                    warriorHeroList.remove(choice - 1);
                        break;
            }
                else
                    System.out.println("Invalid choice. Please choose again");
            }
            else if(heroType ==2) {
                if (choice >= 1 && choice <= paladinHeroList.size()) {
                    party.addToParty(paladinHeroList.get(choice - 1));
                    paladinHeroList.remove(choice - 1);
                        break;
            }
                else
                    System.out.println("Invalid choice. Please choose again");
        }
        else{
            if (choice >= 1 && choice <= sorcererHeroList.size()) {
                party.addToParty(sorcererHeroList.get(choice - 1));
                sorcererHeroList.remove(choice - 1);
                break;
            }
            else
                System.out.println("Invalid choice. PLease choose again");
        }
    }
    }

    // display the heroes in the party
    void displayPartyMembers(){
        System.out.println("Your party is:");
        party.displayPartyStats();
    }


}


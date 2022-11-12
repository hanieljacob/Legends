import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Class which helps set up the market
public class Market{
    private static ArrayList<Armor> armorList;
    private static ArrayList<Weapon> weaponList;
    private static ArrayList<Potion> potionList;
    private static ArrayList<Spell> spellList;
    Party party;
    Scanner scan;

    Market() {
        armorList = new ArrayList<>();
        weaponList = new ArrayList<>();
        potionList = new ArrayList<>();
        spellList = new ArrayList<>();
        party = new Party();
        scan = new Scanner(System.in);
    }

    // getting the items for the market from text files
    public void getItems(int type) {
        String name;
        String path;
        double cost;
        int requiredLevel;
        int damageReduction;
        int damage;
        int requiredHands;
        int attributeIncrease;
        int manaCost;
        String attributeAffected;
        String[] parts;
        if (type == 1)
            path = "./Armory.txt";
        else if (type == 2)
            path = "./Weaponry.txt";
        else if (type == 3)
            path = "./Potions.txt";
        else if (type == 4)
            path = "./FireSpells.txt";
        else if (type == 5)
            path = "./IceSpells.txt";
        else
            path = "./LightningSpells.txt";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                parts = data.split("\\s+");
                name = parts[0];
                cost = Double.parseDouble(parts[1]);
                requiredLevel = Integer.parseInt(parts[2]);
                if (type == 1) {
                    damageReduction = Integer.parseInt(parts[3]);
                    armorList.add(new Armor(damageReduction, name, cost, requiredLevel));
                } else if (type == 2) {
                    damage = Integer.parseInt(parts[3]);
                    requiredHands = Integer.parseInt(parts[4]);
                    weaponList.add(new Weapon(damage, requiredHands, name, cost, requiredLevel));
                } else if (type == 3) {
                    attributeIncrease = Integer.parseInt(parts[3]);
                    attributeAffected = parts[4];
                    potionList.add(new Potion(name, cost, requiredLevel, attributeIncrease, attributeAffected));
                } else if (type == 4) {
                    damage = Integer.parseInt(parts[3]);
                    manaCost = Integer.parseInt(parts[4]);
                    spellList.add(new FireSpell(damage, manaCost, name, cost, requiredLevel));
                } else if (type == 5) {
                    damage = Integer.parseInt(parts[3]);
                    manaCost = Integer.parseInt(parts[4]);
                    spellList.add(new IceSpell(damage, manaCost, name, cost, requiredLevel));
                } else {
                    damage = Integer.parseInt(parts[3]);
                    manaCost = Integer.parseInt(parts[4]);
                    spellList.add(new LightningSpell(damage, manaCost, name, cost, requiredLevel));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // displaying, buying and selling items from the market
    void displayItems() {
        int choice;
        int choice2;
        int choice3;
        int choice4;
        int num = 0;
        ArrayList<Hero> team;
        team = party.getTeam();
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Buy armor");
            System.out.println("2. Buy weapons");
            System.out.println("3. Buy potions");
            System.out.println("4. Buy spells");
            System.out.println("5. sell items");
            System.out.println("6. Exit");
            choice = Validator.Validate();
            if (choice == 1) {
                System.out.println("   Name              Cost  Required level  Damage Reduction");
                for (Armor armor : armorList) {
                    num++;
                    System.out.print(num + ". " + armor.getName());
                    for (int j = 0; j < 20 - armor.getName().length(); j++)
                        System.out.print(" ");
                    System.out.println(armor.getCost() + "       " + armor.getRequiredLevel() + "       " + armor.getDamageReduction());
                }
                num=0;
                System.out.println("Enter the corresponding number to buy your armor or enter -1 to go back");
                choice2 = Validator.Validate();
                if (choice2 >= 1 && choice2 <= armorList.size()) {
                    System.out.println("Who wants to buy this armor?");
                    party.displayPartyItems();
                    choice3 = Validator.Validate();
                    if(choice3 <= party.getSize() && choice3>=1){
                        if(team.get(choice3-1).getMoney() >= armorList.get(choice2 - 1).getCost()
                                && team.get(choice3-1).getLevel() >= armorList.get(choice2 - 1).getRequiredLevel()) {
                            team.get(choice3-1).setMoney(team.get(choice3-1).getMoney() - (int)armorList.get(choice2 - 1).getCost());
                            team.get(choice3 - 1).getItems().add(armorList.get(choice2 - 1));
                            team.get(choice3 - 1).getArmors().add(armorList.get(choice2 - 1));
                            System.out.println("Item has been purchased!");
                        }
                        else
                            System.out.println("Cannot purchase this item due to insufficient balance or level");
                    }
                    else{
                        System.out.println("Invalid selection. Returning to previous menu");
                    }
                }
            } else if (choice==2) {
                System.out.println("   Name              Cost  Required level  Damage  Required Hands");
                for (Weapon weapon : weaponList) {
                    num++;
                    System.out.print(num + ". " + weapon.getName());
                    for (int j = 0; j < 20 - weapon.getName().length(); j++)
                        System.out.print(" ");
                    System.out.println(weapon.getCost() + "       " + weapon.getRequiredLevel() + "       " +
                            weapon.getDamage() + "       " + weapon.getRequiredHands());
                }
                num=0;
                System.out.println("Enter the corresponding number to buy your weapon or enter -1 to go back");
                choice2 = Validator.Validate();
                if (choice2 >= 1 && choice2 <= weaponList.size()) {
                    System.out.println("Who wants to buy this weapon?");
                    party.displayPartyItems();
                    choice3 = Validator.Validate();
                    if(choice3 <= party.getSize() && choice3>=1){
                        if(team.get(choice3-1).getMoney() >= weaponList.get(choice2 - 1).getCost()
                                && team.get(choice3-1).getLevel() >= weaponList.get(choice2 - 1).getRequiredLevel()) {
                            team.get(choice3-1).setMoney(team.get(choice3-1).getMoney() - (int)weaponList.get(choice2 - 1).getCost());
                            team.get(choice3 - 1).getItems().add(weaponList.get(choice2 - 1));
                            team.get(choice3 - 1).getWeapons().add(weaponList.get(choice2 - 1));
                            System.out.println("Item has been purchased!");
                        }
                        else
                            System.out.println("Cannot purchase this item due to insufficient balance or level");
                    }
                }
                else{
                    System.out.println("Invalid selection. Returning to previous menu");
                }
            } else if (choice==3) {
                System.out.println("   Name              Cost  Required level  Attribute increase  Attribute affected");
                for (Potion potion : potionList) {
                    num++;
                    System.out.print(num + ". " + potion.getName());
                    for (int j = 0; j < 20 - potion.getName().length(); j++)
                        System.out.print(" ");
                    System.out.println(potion.getCost() + "       " + potion.getRequiredLevel() + "       " +
                            potion.getAttributeIncrease() + "       " + potion.getAttributeAffected());
                }
                num = 0;
                System.out.println("Enter the corresponding number to buy your potion or enter -1 to go back");
                choice2 = Validator.Validate();
                if (choice2 >= 1 && choice2 <= potionList.size()) {
                    System.out.println("Who wants to buy this Potion?");
                    party.displayPartyItems();
                    choice3 = Validator.Validate();
                    if (choice3 <= party.getSize() && choice3 >= 1) {
                        if (team.get(choice3 - 1).getMoney() >= potionList.get(choice2 - 1).getCost()
                                && team.get(choice3-1).getLevel() >= potionList.get(choice2 - 1).getRequiredLevel()) {
                            team.get(choice3 - 1).setMoney(team.get(choice3 - 1).getMoney() - (int) potionList.get(choice2 - 1).getCost());
                            team.get(choice3 - 1).getItems().add(potionList.get(choice2 - 1));
                            team.get(choice3 - 1).getPotions().add(potionList.get(choice2 - 1));
                            System.out.println("Item has been purchased!");
                        } else
                            System.out.println("Cannot purchase this item due to insufficient balance or level");
                    }
                    else{
                        System.out.println("Invalid selection. Returning to previous menu");
                    }
                }
            }else if (choice == 4) {
                    System.out.println("   Name              Cost  Required level  Damage  Mana cost");
                    for (Spell spell : spellList) {
                        num++;
                        System.out.print(num + ". " + spell.getName());
                        for (int j = 0; j < 20 - spell.getName().length(); j++)
                            System.out.print(" ");
                        System.out.println(spell.getCost() + "       " + spell.getRequiredLevel() + "       " +
                                spell.getDamage() + "       " + spell.getManaCost());
                    }
                    num=0;
                    System.out.println("Enter the corresponding number to buy your spell or enter -1 to go back");
                    choice2 = Validator.Validate();
                    if (choice2 >= 1 && choice2 <= spellList.size()) {
                        System.out.println("Who wants to buy this Spell?");
                        party.displayPartyItems();
                        choice3 = Validator.Validate();
                        if(choice3 <= party.getSize() && choice3>=1){
                            if(team.get(choice3-1).getMoney() >= spellList.get(choice2 - 1).getCost()
                                    && team.get(choice3-1).getLevel() >= spellList.get(choice2 - 1).getRequiredLevel()) {
                                team.get(choice3-1).setMoney(team.get(choice3-1).getMoney() - (int)spellList.get(choice2 - 1).getCost());
                                team.get(choice3 - 1).getItems().add(spellList.get(choice2 - 1));
                                team.get(choice3 - 1).getSpells().add(spellList.get(choice2 - 1));
                                System.out.println("Item has been purchased!");
                            }
                            else
                                System.out.println("Cannot purchase this item due to insufficient balance or level");
                        }
                }
                    else
                        System.out.println("Invalid selection. Returning to previous menu");

            } else if(choice==5){
                num=0;
                System.out.println("Who wants to sell?");
                party.displayPartyItems();
                choice3 = Validator.Validate();
                if(choice3 <= party.getSize() && choice3>=1){
                    if(team.get(choice3-1).getItems().size() > 0){
                        System.out.println("What do you want to sell?");
                        System.out.println("1. Armor");
                        System.out.println("2. Weapon");
                        System.out.println("3. Spell");
                        System.out.println("4. Potion");
                        choice4 = Validator.Validate();
                        if(choice4==1) {
                            if (!team.get(choice3 - 1).getArmors().isEmpty()) {
                                System.out.println("Which armor do you want to sell?");
                                for (Armor armor : team.get(choice3 - 1).getArmors()) {
                                    num++;
                                    System.out.println(num + ". " + armor.getName());
                                }
                            }
                            else {
                                System.out.println("You do not have any armors to sell");
                                break;
                            }
                            choice4 = Validator.Validate();
                            if (choice4>=1 && choice4<= armorList.size()){
                                System.out.println(team.get(choice3-1).getArmors().get(choice4-1).getName() + " was sold!");
                                team.get(choice3-1).setMoney(team.get(choice3-1).getMoney() +
                                        (int)(0.5*team.get(choice3-1).getArmors().get(choice4-1).getCost()));
                                team.get(choice3-1).getArmors().remove(choice4-1);
                            }
                            else{
                                System.out.println("Invalid option. Returning to previous menu");
                                break;
                            }
                        }
                        else if(choice4==2) {
                            if (!team.get(choice3 - 1).getWeapons().isEmpty()) {
                                System.out.println("Which weapon do you want to sell?");
                                for (Weapon weapon : team.get(choice3 - 1).getWeapons()) {
                                    num++;
                                    System.out.println(num + ". " + weapon.getName());
                                }
                            }
                            else {
                                System.out.println("You do not have any weapons to sell");
                                break;
                            }
                            choice4 = Validator.Validate();
                            if (choice4>=1 && choice4<= weaponList.size()){
                                System.out.println(team.get(choice3-1).getWeapons().get(choice4-1).getName() + " was sold!");
                                team.get(choice3-1).setMoney(team.get(choice3-1).getMoney() +
                                        (int)(0.5*team.get(choice3-1).getWeapons().get(choice4-1).getCost()));
                                team.get(choice3-1).getWeapons().remove(choice4-1);
                            }
                            else{
                                System.out.println("Invalid option. Returning to previous menu");
                                break;
                            }
                        }
                        else if(choice4==3) {
                            if (!team.get(choice3 - 1).getSpells().isEmpty()) {
                                System.out.println("Which spell do you want to sell?");
                                for (Spell spell : team.get(choice3 - 1).getSpells()) {
                                    num++;
                                    System.out.println(num + ". " + spell.getName());
                                }
                            }
                            else {
                                System.out.println("You do not have any spells to sell");
                                break;
                            }
                            choice4 = Validator.Validate();
                            if (choice4>=1 && choice4<= spellList.size()){
                                System.out.println(team.get(choice3-1).getSpells().get(choice4-1).getName() + " was sold!");
                                team.get(choice3-1).setMoney(team.get(choice3-1).getMoney() +
                                        (int)(0.5*team.get(choice3-1).getSpells().get(choice4-1).getCost()));
                                team.get(choice3-1).getSpells().remove(choice4-1);
                            }
                            else{
                                System.out.println("Invalid option. Returning to previous menu");
                                break;
                            }
                        }
                        else if(choice4==4) {
                            if (!team.get(choice3 - 1).getPotions().isEmpty()) {
                                System.out.println("Which potion do you want to sell?");
                                for (Potion potion : team.get(choice3 - 1).getPotions()) {
                                    num++;
                                    System.out.println(num + ". " + potion.getName());
                                }
                            }
                            else {
                                System.out.println("You do not have any potions to sell");
                                break;
                            }
                            choice4 = Validator.Validate();
                            if (choice4>=1 && choice4<= potionList.size()){
                                System.out.println(team.get(choice3-1).getPotions().get(choice4-1).getName() + " was sold!");
                                team.get(choice3-1).setMoney(team.get(choice3-1).getMoney() +
                                        (int)(0.5*team.get(choice3-1).getPotions().get(choice4-1).getCost()));
                                team.get(choice3-1).getPotions().remove(choice4-1);
                            }
                            else{
                                System.out.println("Invalid option. Returning to previous menu");
                                break;
                            }
                        }
                        else {
                            System.out.println("Invalid option. Returning to previous menu");
                            break;
                        }

                    }
                    else
                        System.out.println("This player has no items to sell!");
                }
                else
                    System.out.println("Invalid selection. Returning to previous menu");

            }
            else if (choice==6) {
                System.out.println("Exiting Market");
                break;
            }
            else {
                System.out.println("Invalid selection. Returning to previous menu");
                break;
            }
        }
    }
}


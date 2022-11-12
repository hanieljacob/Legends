import java.util.ArrayList;
// Class which manages the party     (player chosen heroes)
public class Party {
    public static ArrayList<Hero> Team = new ArrayList<>();
    Party(){
    }

    // Adds a hero to the party
    public void addToParty(Hero hero){
        Team.add(hero);
    }
    // Displays the statistics for every hero in the party
    public void displayPartyStats(){
        Heroes h = new Heroes();
        int i=1;
        System.out.println("   Name                     Level    Mana    Strength    Agility    Dexterity    Money" +
                "    Experience    Hit Points");
            for(Hero hero: Team) {
                h.printHeroStats(hero, i);
                i++;
            }
    }

    //Displays the items for every hero in the party
    public void displayPartyItems(){
        Heroes h = new Heroes();
        int i=1;
        System.out.println("   Name                      Money items");
        for(Hero hero: Team) {
            h.printHeroItems(hero, i);
            i++;
        }
    }

    // Gets the highest hero level in the party
    public int getHighestHeroLevel(){
        int highestLevel=0;
        for(Hero hero: Team) {
            if(hero.getLevel()>highestLevel)
                highestLevel = hero.getLevel();
        }
        return highestLevel;
    }

    // Returns the size of the party
    public int getSize(){
        return Team.size();
    }

    // Returns the party
    public ArrayList<Hero> getTeam(){
        return Team;
    }

}

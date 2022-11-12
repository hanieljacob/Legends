import java.util.Scanner;
//Class to perform operations of the game
public class Legends extends Heroes{
    private int numHero;
    private final Scanner scan;
    private final Heroes hero;
    public int row;
    public int column;

    public
    Legends(){
        numHero = 0;
        scan = new Scanner(System.in);
        hero = new Heroes();
    }
    // Welcomes the user and displays rules of the game
    public void startingMenu(){
        System.out.println("Welcome to Legends: Monsters and Heroes");
        System.out.println("Instructions:");
        System.out.println("1. Each party consists of 1-3 heroes");
        System.out.println("2. A world representing grid of size (row x column) is created. This is where moves and decisions need to be made.");
        System.out.println("3. There are three different spaces which are Inaccessible spaces, Common spaces and Market spaces");
        System.out.println("4. Use the w,a,s,d keys to move from one space to another");
        System.out.println("5. The party can only move to market and common spaces");
        System.out.println("6. When the party lands on a market space each Hero in the party will be able to buy Armors, Weapons, Potions or Spells");
        System.out.println("7. The first weapon the Hero purchases is set as the default weapon. This can be changed during battle");
        System.out.println("8. A Hero needs to be at least equal to the required hero level of the item and must have sufficient balance to purchase an item");
        System.out.println("9. When selling an item to the market the item will be bought back for 50% of the price it was bought for");
        System.out.println("10. The hero begins at position(0,0) and will have an adjacent market which can be visited");
        System.out.println("11. When the party visits a common space there is a 50% chance for them to encounter monsters");
        System.out.println("12. Heroes are also defeated if their hit points reaches 0 or goes below 0");
        System.out.println("13. Defeated heroes will be revived after the battle if at least one member in the party survives");
        System.out.println("14. Monsters are defeated if their hit points reaches 0 or goes below 0");
        System.out.println("15. If a hero defeats a monster the hero obtains gold and experience points");
        System.out.println("16. The hero will level up and become stronger when enough experience points have been obtained.");
        System.out.println("17. The attributes which are enhanced for a hero depends on the type of hero");
        System.out.println("18. If all party members are defeated the game ends");

    }
    // create a party of heroes
    public void createParty(){
        int heroType;
        for(int i=1;i<=3;i++)
            hero.getHeroes(i);
        System.out.println("\nHow many Heroes would you like to have in your party?(1-3)");
        numHero = Validator.Validate();
        if(numHero>3 || numHero<1)
            numHero=1;
        for(int i=0; i<numHero;i++) {
            System.out.println("Enter type of hero " + (i + 1));
            System.out.println("1. Warrior");
            System.out.println("2. Sorcerer");
            System.out.println("3. Paladin");
            heroType = Validator.Validate();
            if(heroType>3 || heroType<1)
                heroType=3;
            hero.addParty(heroType);
        }
        hero.displayPartyMembers();
    }

    //Create the game grid based on the number of rows and columns entered by the player
    public void createBoard(){
        while (true) {
            System.out.println("Enter number of rows the game should have (>3):");
            row = Validator.Validate();
            System.out.println("Enter number of columns the game should have (>3):");
            column = Validator.Validate();
            if (row <= 3 || column<=3)
                System.out.println("The number of rows and columns must be greater than 3");
            else
                break;
        }
        new LegendsBoard(row,column).createGameBoard();
    }

    // Start playing the game (Making choices)
    public void startPlayingGame(){
        new Play(row,column).startPlaying();
    }
}

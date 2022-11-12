import java.util.Scanner;

// Play class which controls player actions and movements in the grid
public class Play{
    GameTile[][] gameTiles;
    int previousTile;
    int currentX;
    int currentY;
    int turnNumber;
    int rows;
    int columns;
    Play(int row, int column){
        this.rows = row;
        this.columns = column;
        previousTile = 0;
        currentX = 0;
        currentY = 0;
        turnNumber = 0;
        gameTiles = new LegendsBoard(rows,columns).getTiles();
    }

    // Starts playing the game and moves the party
    public void startPlaying(){
        char ch;
        Market market = new Market();
        Monsters monsters = new Monsters();
        CommonArea commonArea = new CommonArea();
        for(int i=1;i<=3;i++)
            monsters.getMonsters(i);
        for(int i=1;i<=6;i++)
            market.getItems(i);
        char choice = ' ';
        previousTile = 0;
        while(choice!='q') {
            turnNumber++;
            System.out.println("\nTurn "+turnNumber+":");
            displayActions();
            Scanner scan = new Scanner(System.in);
            choice = scan.next().charAt(0);
            if (choice == 'm' && previousTile==1)
                market.displayItems();
            else if (choice == 'w')
                moveUpward();
            else if (choice == 'a')
                moveBackward();
            else if (choice == 's')
                moveDownward();
            else if (choice == 'd')
                moveForward();
            else if (choice == 'q') {
                System.out.println("Do you want to quit the current game and start a new game?(Y/N)");
                ch = scan.next().charAt(0);
                if(ch=='Y')
                    new Start().startGame();
                else
                    System.exit(0);
            }
            else if (choice=='i') {
                new Heroes().displayPartyMembers();
                turnNumber--;
            }
            else{
                System.out.println("Invalid choice enter again");
                turnNumber--;
                continue;
            }
            if(choice=='w' || choice =='a' || choice== 's' || choice =='d') {
                Grid.createGrid(gameTiles, rows, columns);
                if (previousTile == 0) {
                    commonArea.Enter(new Party().getHighestHeroLevel(), monsters);
                }
            }
        }
    }

    // Displays the list of possible actions
    void displayActions(){
        System.out.println("Enter w to move up");
        System.out.println("Enter a to move left");
        System.out.println("Enter s to move down");
        System.out.println("Enter d to move right");
        System.out.println("Enter q to quit game");
        System.out.println("Enter i to show information");
        if(previousTile==1)
            System.out.println("Enter m to enter market");
    }

    // Moves the party upward
    void moveUpward(){
        if(currentX-1<0 || gameTiles[currentX-1][currentY].getGameTileMarker().equals("X")) {
            System.out.println("Can't go here");
            turnNumber--;
            return;
        }
        if (previousTile == 1)
            gameTiles[currentX][currentY] = new MarketTile();
        else
            gameTiles[currentX][currentY] = new CommonTile();
        if(gameTiles[currentX-1][currentY].getGameTileMarker().equals("M"))
            previousTile = 1;
        else
            previousTile = 0;
        gameTiles[currentX-1][currentY] = new HeroTile();
        currentX--;
    }

    // Moves the party forward
    void moveForward(){
        if(currentY+1>columns-1 || gameTiles[currentX][currentY+1].getGameTileMarker().equals("X")) {
            System.out.println("Can't go here");
            turnNumber--;
            return;
        }
        if(turnNumber==1)
            gameTiles[currentX][currentY] = new CommonTile();
        else {
            if (previousTile == 1)
                gameTiles[currentX][currentY] = new MarketTile();
            else
                gameTiles[currentX][currentY] = new CommonTile();
        }
        if(gameTiles[currentX][currentY+1].getGameTileMarker().equals("M"))
            previousTile = 1;
        else
            previousTile = 0;
        gameTiles[currentX][currentY+1] = new HeroTile();
        currentY++;
    }

    // Moves the party downward
    void moveDownward(){
        if(currentX+1>rows-1 || gameTiles[currentX+1][currentY].getGameTileMarker().equals("X")) {
            System.out.println("Can't go here");
            turnNumber--;
            return;
        }
        if(turnNumber==1)
            gameTiles[currentX][currentY] = new CommonTile();
        else {
            if (previousTile == 1)
                gameTiles[currentX][currentY] = new MarketTile();
            else
                gameTiles[currentX][currentY] = new CommonTile();
        }
        if(gameTiles[currentX+1][currentY].getGameTileMarker().equals("M"))
            previousTile = 1;
        else
            previousTile = 0;
        gameTiles[currentX+1][currentY] = new HeroTile();
        currentX++;
    }

    // Moves the party backward
    void moveBackward(){
        if(currentY-1<0 || gameTiles[currentX][currentY-1].getGameTileMarker().equals("X")) {
            System.out.println("Can't go here");
            turnNumber--;
            return;
        }
        if (previousTile == 1)
            gameTiles[currentX][currentY] = new MarketTile();
        else
            gameTiles[currentX][currentY] = new CommonTile();
        if(gameTiles[currentX][currentY-1].getGameTileMarker().equals("M"))
            previousTile = 1;
        else
            previousTile = 2;
        gameTiles[currentX][currentY-1] = new HeroTile();
        currentY--;
    }

    }


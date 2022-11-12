import java.util.ArrayList;
// Legends board class which is used to create the game tiles and board
public class LegendsBoard extends BoardGame{
    private static GameTile[][] gameTiles;
    private ArrayList<Integer> remainingTiles;

    LegendsBoard(int rows, int columns){
        super(rows,columns);
    }

    // creating the game board
    void createGameBoard(){
        gameTiles = new GameTile[rows][columns];
        initializeGame();
        setMarketTiles();
        setInaccessibleTiles();
        System.out.println("\nA new board has been created!");
        System.out.println("Marker P: Party space");
        System.out.println("Marker M: Market space");
        System.out.println("Marker X: Inaccessible space");
        System.out.println("Empty space: Common space\n");
        Grid.createGrid(gameTiles,rows,columns);
    }

    // Initializing a new game with position(0,0) as the empty tile, one market tile and the remaining as common tiles
    void initializeGame(){
        remainingTiles = new ArrayList<>();
        int rand;
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++) {
                gameTiles[i][j] = new CommonTile();
                remainingTiles.add(getTileNumber(i,j));
            }
        gameTiles[0][0] = new HeroTile();
        remainingTiles.remove(Integer.valueOf(getTileNumber(0,0)));
        rand = Randomizer.Randomize(0,1);
        if(rand==1) {
            gameTiles[0][rand] = new MarketTile();
            remainingTiles.remove(Integer.valueOf(getTileNumber(0,rand)));
        }
        else {
            gameTiles[rand][1] = new MarketTile();
            remainingTiles.remove(Integer.valueOf(getTileNumber(rand,1)));
        }
    }

    //setting the market tiles
    void setMarketTiles(){
        setTiles(0.3);
    }

    //setting the inaccessible tiles
    void setInaccessibleTiles(){
        setTiles(0.2);
    }

    //getting the tile number from the tile's coordinates in the board
    int getTileNumber(int row, int column){
        return ((rows*row)+column+1);
    }

    //Method to randomly generate tiles
    void setTiles(double num){
        int rand;
        int tileNum;
        int numTiles = (int)(remainingTiles.size() *num);
        while (numTiles!=0){
            rand = Randomizer.Randomize(remainingTiles);
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    tileNum = getTileNumber(i,j);
                    if(tileNum==rand)
                        if(num==0.3)
                            gameTiles[i][j] = new MarketTile();
                        else
                            gameTiles[i][j] = new InaccessibleTile();
                }
            }
            remainingTiles.remove(Integer.valueOf(rand));
            numTiles--;
        }
    }

    //Method to get the game tiles
    GameTile[][] getTiles(){
        return gameTiles;
    }

}

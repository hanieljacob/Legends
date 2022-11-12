//class with a static method which displays a grid and gets a marker for each element in the grid
public class Grid{
    public static void createGrid(GameTile[][] elements,int rows, int columns){
        for(int i=0;i<rows;i++){
            System.out.print("|");
            for(int j=0;j<columns;j++){
                System.out.print(elements[i][j].getGameTileMarker()+" |");
            }
            System.out.println();
            for(int k=0;k<columns;k++)
                System.out.print("---");
            System.out.println("-");
        }
    }
}

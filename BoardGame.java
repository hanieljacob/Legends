// BoardGame super class which consists of 2 attributes rows and columns which are common to all board games
public class BoardGame {
    protected int rows;
    protected int columns;
    BoardGame(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
    }
}

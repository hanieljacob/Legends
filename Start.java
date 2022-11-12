// class which helps to modularize the code
public class Start{
    void startGame() {
        Legends l = new Legends();
        l.startingMenu();
        l.createParty();
        l.createBoard();
        l.startPlayingGame();
    }
}

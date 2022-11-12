// Super class GameTile
// The gameTileMarker attribute helps determine the type of tile
public class GameTile{
    private String gameTileMarker;
    GameTile(){
        gameTileMarker  = " ";
    }
    GameTile(String marker){
        gameTileMarker = marker;
    }

    public String getGameTileMarker(){
        return gameTileMarker;
    }
}

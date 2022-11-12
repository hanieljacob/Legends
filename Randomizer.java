import java.util.ArrayList;
import java.util.Collections;
//Class to randomize inputs
public class Randomizer{
    public static int Randomize(int a, int b){
        return (int)Math.floor(Math.random()*(b-a+1)+a);
    }
    public static int Randomize(ArrayList<Integer> tiles){
        Collections.shuffle(tiles);
        return tiles.get(0);
    }
}

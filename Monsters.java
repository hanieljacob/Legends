import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Class used to separate and use the different types of monsters
public class Monsters {
    public ArrayList<Monster> exoskeletonList;
    public ArrayList<Monster> dragonList;
    public ArrayList<Monster> spiritList;
    Scanner scan;
    Monsters(){
        exoskeletonList = new ArrayList<>();
        dragonList = new ArrayList<>();
        spiritList = new ArrayList<>();
        scan = new Scanner(System.in);
    }

    // gets the list of monsters and stores them in lists based on the type of monster
    public void getMonsters(int type){
        String name;
        String path;
        int level;
        int damage;
        int defense;
        int dodgeChance;
        String[] parts;
        if(type == 1)
            path = "./Exoskeletons.txt";
        else if(type == 2)
            path = "./Dragons.txt";
        else
            path = "./Spirits.txt";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine() ) {
                String data = myReader.nextLine();
                parts = data.split("\\s+");
                name = parts[0];
                level = Integer.parseInt(parts[1]);
                damage = Integer.parseInt(parts[2]);
                defense = Integer.parseInt(parts[3]);
                dodgeChance = Integer.parseInt(parts[4]);
                if(type==1)
                    exoskeletonList.add(new Exoskeleton(damage,defense,name,level,dodgeChance));
                else if (type==2)
                    dragonList.add(new Dragon(damage,defense,name,level,dodgeChance));
                else
                    spiritList.add(new Spirit(damage,defense,name,level,dodgeChance));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    // Method to return the list of exoskeletons
    ArrayList<Monster> getExoskeletonList(){
        return exoskeletonList;
    }
    // Method to return the list of dragons
    ArrayList<Monster> getDragonList(){
        return dragonList;
    }
    // Method to return the list of spirits
    ArrayList<Monster> getSpiritList(){
        return spiritList;
    }
}



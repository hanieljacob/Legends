import java.util.Scanner;
// Class to validate integers
public class Validator{
    public static int Validate() {
        int num;
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                num = scan.nextInt();
                break;
            }
             catch (Exception e) {
                System.out.println("Please enter an Integer:");
                scan.next();
            }
        }
        return num;
    }
}


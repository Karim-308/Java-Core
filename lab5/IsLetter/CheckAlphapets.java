package lab5.IsLetter;

import java.util.Scanner;
import java.util.function.Function;

public class CheckAlphapets  implements Function<String , Boolean>{
    
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String stirngToCheck = scanner.nextLine();
            CheckAlphapets checker = new CheckAlphapets();

            if (checker.apply(stirngToCheck)){
                System.out.println("The string you entered is all Alphapetical");
            }
            else {
                System.out.println("The string you entered is not all Alphapetical");
            }
            scanner.close();

    }
    
    @Override
    public Boolean apply(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }


}

package lab5.IsLetter;


import java.util.function.Function;

public class CheckAlphapets  implements Function<String , Boolean>{
    
    public static void main(String[] args) {
            String stirngToCheck = System.console().readLine("Enter a string: ");
            CheckAlphapets checker = new CheckAlphapets();

            if (checker.apply(stirngToCheck)){
                System.out.println("The string you entered is all Alphapetical");
            }
            else {
                System.out.println("The string you entered is not all Alphapetical");
            }

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





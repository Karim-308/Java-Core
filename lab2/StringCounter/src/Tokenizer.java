import java.util.StringTokenizer;

public class Tokenizer {
 
    public static void main(String[] args) throws Exception {
        String input = System.console().readLine("Enter a string to search in: ");
        String target = System.console().readLine("Enter a lookfor: ");
        StringTokenizer tokenizer = new StringTokenizer(input,target);
        System.out.println("The tokens of" + target + " are: " + (tokenizer.countTokens()));

        int numberOfTokens = tokenizer.countTokens();
        for (int i = 0; i < numberOfTokens; i++) {
            System.out.println("Token " + (i + 1) + ": " + tokenizer.nextToken());
        }

    }
}

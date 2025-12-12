public class StringEcho {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("No input provided as argument.");
            return;
        }
        else if (args.length == 1 ) {
             try {
                
                int number = Integer.parseInt(args[0]);

                if (number < 0) {
                    System.out.println("Error: Number must be non-negative");
                } else {
                    System.out.println("No String was provided");
                }
            } 
            catch (NumberFormatException e) {
                
                System.out.println("Error: First argument is not a number");
            }
        }
        else if (args.length == 2 ) {
            String enteredString = new String (args[1]);
            for ( int i = 0; i < Integer.parseInt(args[0]); i++ ) {
                System.out.println(enteredString.toString());
            }
           
        }
        else {
            System.out.println("Too many arguments provided.");
        }

    }
}

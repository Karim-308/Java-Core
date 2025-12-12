public class InputEcho {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            System.out.println(args[0]);
            return;
        }
        else {
            System.out.println("No input provided as argument.");
        }

    }
}

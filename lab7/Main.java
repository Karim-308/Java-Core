package lab7;

public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        dictionary.addWord("Apple");
        dictionary.addWord("angry");
        dictionary.addWord("bananna");
        dictionary.addWord("Book");
        dictionary.addWord("cycle");
        dictionary.addWord("Crosswalk");
        dictionary.addWord("DOLL");
        dictionary.addWord("essAy");
        dictionary.addWord("fog");
        dictionary.addWord("goblin");
        dictionary.addWord("gorund");
        dictionary.addWord("hall");
        dictionary.addWord("hold");
        dictionary.addWord("Ice");
        dictionary.addWord("Jog");

        System.out.println("Words starting with letter A:");
        dictionary.printWords('A');
        System.out.println();

        System.out.println("Words starting with letter C:");
        dictionary.printWords('C');
        System.out.println();

        System.out.println("The Whole dictionary:");
        dictionary.print();
    }
}

package lab5.betterstring;

import java.util.function.BiFunction;

public class BetterSring {
    public static void main(String[] args) {
        String first = System.console().readLine("Enter first string: ");
        String second = System.console().readLine("Enter second string: ");

        System.out.println( betterString(first, second, (s1, s2)->  System.out.println("Eng Alaa")));
        //System.out.println( betterString(first, second, (s1, s2)-> false));


    }

    public static void betterString(String a, String b, BiFunction<String, String, void> function) {
         function.apply(a, b) ;
    }
}

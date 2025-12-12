package lab5.betterstring;

import java.util.Scanner;
import java.util.function.BiPredicate;

public class BetterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = scanner.nextLine();
        System.out.print("Enter second string: ");
        String second = scanner.nextLine();

        String longer = betterString(first, second, (s1, s2) -> s1.length() >= s2.length());
        System.out.println("Better string: " + longer);

        scanner.close();
    }

    public static String betterString(String a, String b, BiPredicate<String, String> predicate) {
        return predicate.test(a, b) ? a : b;
    }
}

import java.util.*;

public class SimpleSearch {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[1000];
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);

        }
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > Max) {
                Max = arr[i];
            }
            if (arr[i] < Min) {
                Min = arr[i];
            }
        }

        System.out.println("Maximum value: " + Max);
        System.out.println("Minimum value: " + Min);
        System.out.println("Execution time: " + (System.currentTimeMillis() - startTime) + " milliseconds");

    }
}

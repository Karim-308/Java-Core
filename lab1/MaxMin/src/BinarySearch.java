import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[1000];
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }

        long startTime = System.currentTimeMillis();

        Arrays.sort(arr);

        long sortTime = System.currentTimeMillis();
        int maxIndex = binarySearch(arr, maxValue);
        int minIndex = binarySearch(arr, minValue);

        if (maxIndex == -1 || minIndex == -1) {
            System.out.println("Unable to locate max/min values using binary search");
        } else {
            System.out.println("Maximum value " + maxValue + " found at index: " + maxIndex);
            System.out.println("Minimum value " + minValue + " found at index: " + minIndex);
        }

        System.out.println("Sorting time: " + (sortTime - startTime) + " milliseconds");
        System.out.println("Execution time: " + (System.currentTimeMillis() - sortTime) + " milliseconds");
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}

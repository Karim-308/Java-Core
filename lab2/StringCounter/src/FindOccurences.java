public class FindOccurences {
    public static void main(String[] args) throws Exception {
        String input = System.console().readLine("Enter a string: ");
        String subString = System.console().readLine("Enter the substring to count: ");
        int count1 = countOccurrencesByIndexOf(input, subString);
        System.out.println("The word 'hello' occurs " + count1 + " times.");

        int count2 = countOccurrencesBySplit(input, subString);
        System.out.println("The word 'hello' occurs " + count2 + " times.");

    }

    public static int countOccurrencesByIndexOf(String str , String subString){
        int count = 0;
        int idx = 0;

        while ((idx = str.indexOf(subString, idx)) != -1) {
            count++;
            idx += subString.length();
        }

        return count;
    }

    public static int countOccurrencesBySplit(String str , String subString){
        if (subString.isEmpty()) {
            return 0;
        }
        String[] parts = str.split(subString, -1);
        return parts.length - 1;
    }

}

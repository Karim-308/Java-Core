public class IPaddress {
    // 250-255 
    // 200-249
    // 0-199
    static String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    public static void main(String[] args) throws Exception {
        String ip = System.console().readLine("Enter an IP address: ");
        if (isValidIP(ip)) {
            System.out.println(ip + " is a valid IP address.");
        } else {
            System.out.println(ip + " is not a valid IP address.");
        }
    }

    public static boolean isValidIP(String ip) {
        String ipRegex = "^" + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "$";
        return ip.matches(ipRegex);
    }
}

package lab3;
import java.util.Scanner;
import java.util.function.Function;

public class TempratureConverter {

    public static void main(String[] args) {

        Function<Double,Double> centiToFahr = var ->  var*(9/5) + 32 ;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a degree in centigrade: ");
        double degree = scanner.nextDouble();

        System.out.println("Degree in Fahrinheit = "  + centiToFahr.apply(degree));
        scanner.close();
    }

    
}
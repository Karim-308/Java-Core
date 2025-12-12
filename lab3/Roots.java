package lab3;

import java.util.Scanner;
import java.util.function.Function;

public class Roots implements Function<Roots, Double[]> {
    private
    double a;
    double b;
    double c;

    Roots (double a, double b , double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static void main(String[] args) {
        

        System.out.println("Enter a, b and c values");
        Scanner scanner = new Scanner(System.in);
        double aValue = scanner.nextDouble();
        double bValue = scanner.nextDouble();
        double cValue = scanner.nextDouble();

        Roots inputCoefficients  = new Roots(aValue,bValue,cValue);

        Double result [] = inputCoefficients.apply(inputCoefficients);
        if (result == null) System.out.println("No roots found"); 
        
        else {
        System.out.println("First Root =" + result[0]);
        System.out.println("Second Root =" + result[1]);
        }
            

        scanner.close();

    }


    public Double[] apply (Roots coefficients){
        if (coefficients.a == 0 ){
            System.out.println("Math Error: a cannot be 0. Not a quadratic equation.");
            return null;
        }

        double discriminant = (coefficients.b * coefficients.b) - (4 * coefficients.a * coefficients.c);

        if (discriminant <0) {
            System.out.println("Error: No real roots (discriminant is negative).");
            return null;
        }

        Double root1 = (-coefficients.b + Math.sqrt(discriminant)) / (2* coefficients.a);
        Double root2 = (-coefficients.b - Math.sqrt(discriminant) )/ (2 *coefficients.a);

        return new Double[] {root1 , root2};

        
    }
}


import java.util.Scanner;

/**
 * CSC320 Module 4 Critical Thinking - Option #1
 * Looping Construct with Floating Point Numbers
 * 
 * This program uses a while-loop to read five floating-point values
 * from user input and calculates total, average, maximum, minimum,
 * and interest on total at 20%.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class FloatingPointStats {

    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Declare and initialize variables
        double total = 0.0;
        double maximum = 0.0;
        double minimum = 0.0;
        double average = 0.0;
        double interest = 0.0;
        double value = 0.0;
        int count = 0;
        final int MAX_VALUES = 5;
        
        // Display program header
        System.out.println("===== Floating Point Statistics Calculator =====");
        System.out.println("Please enter 5 floating-point values.");
        System.out.println();
        
        // While-loop to read five floating-point values
        while (count < MAX_VALUES) {
            System.out.print("Enter value " + (count + 1) + ": ");
            
            // Input validation to prevent endless loop
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                
                // Add value to total
                total += value;
                
                // Determine maximum and minimum
                if (count == 0) {
                    maximum = value;
                    minimum = value;
                } else {
                    if (value > maximum) {
                        maximum = value;
                    }
                    if (value < minimum) {
                        minimum = value;
                    }
                }
                
                // Increment counter
                count++;
            } else {
                // Clear invalid input to prevent endless loop
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Consume the invalid input
            }
        }
        
        // Calculate average
        average = total / MAX_VALUES;
        
        // Calculate interest on total at 20%
        interest = total * 0.20;
        
        // Display results
        System.out.println();
        System.out.println("===== Results =====");
        System.out.printf("Total:                    %.2f%n", total);
        System.out.printf("Average:                  %.2f%n", average);
        System.out.printf("Maximum:                  %.2f%n", maximum);
        System.out.printf("Minimum:                  %.2f%n", minimum);
        System.out.printf("Interest on total at 20%%: %.2f%n", interest);
        
        // Close the scanner
        scanner.close();
    }
}


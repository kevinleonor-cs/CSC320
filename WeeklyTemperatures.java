
import java.util.ArrayList;
import java.util.Scanner;

/**
 * WeeklyTemperatures.java
 * 
 * This program stores daily average temperatures for one week using ArrayLists.
 * It allows the user to query temperatures by day or view the full weekly summary
 * with the weekly average temperature.
 * 
 * CSC320 - Module 5 Critical Thinking Assignment
 * Option #1: Get Weekly Temperatures
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class WeeklyTemperatures {

    public static void main(String[] args) {
        // Declare ArrayLists for days and temperatures
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();
        
        // Initialize the days ArrayList with days of the week
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Input Phase: Prompt user to enter temperatures for each day
        System.out.println("===========================================");
        System.out.println("   Weekly Temperature Data Entry System");
        System.out.println("===========================================");
        System.out.println();
        
        for (int i = 0; i < days.size(); i++) {
            System.out.print("Enter the average temperature for " + days.get(i) + " (°C): ");
            
            // Input validation loop
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value.");
                System.out.print("Enter the average temperature for " + days.get(i) + " (°C): ");
                scanner.next(); // Clear invalid input
            }
            
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }
        
        scanner.nextLine(); // Clear the newline character from buffer
        
        System.out.println();
        System.out.println("===========================================");
        System.out.println("   Temperature Data Entry Complete!");
        System.out.println("===========================================");
        System.out.println();
        
        // Query Phase: Allow user to look up temperatures by day or view weekly summary
        String userInput = "";
        
        while (!userInput.equals("quit")) {
            System.out.println("-------------------------------------------");
            System.out.print("Enter a day (Monday-Sunday), 'week' for weekly summary, or 'quit' to exit: ");
            userInput = scanner.nextLine().trim().toLowerCase();
            System.out.println();
            
            if (userInput.equals("quit")) {
                // Exit the program
                System.out.println("Thank you for using the Weekly Temperature System. Goodbye!");
                
            } else if (userInput.equals("week")) {
                // Display all days with temperatures and calculate weekly average
                System.out.println("===========================================");
                System.out.println("        Weekly Temperature Summary");
                System.out.println("===========================================");
                
                double sum = 0.0;
                
                for (int i = 0; i < days.size(); i++) {
                    System.out.printf("   %-12s: %.1f°C%n", days.get(i), temperatures.get(i));
                    sum += temperatures.get(i);
                }
                
                double average = sum / days.size();
                
                System.out.println("-------------------------------------------");
                System.out.printf("   Weekly Average: %.2f°C%n", average);
                System.out.println("===========================================");
                System.out.println();
                
            } else {
                // Search for the specific day entered by the user
                boolean found = false;
                
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).toLowerCase().equals(userInput)) {
                        System.out.println("===========================================");
                        System.out.printf("   %s: %.1f°C%n", days.get(i), temperatures.get(i));
                        System.out.println("===========================================");
                        System.out.println();
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    System.out.println("Invalid input. Please enter a valid day of the week,");
                    System.out.println("'week' for the weekly summary, or 'quit' to exit.");
                    System.out.println();
                }
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}


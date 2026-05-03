import java.util.Scanner;

public class GroceryBill {

    public static void main(String[] args) {

        // Declare a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Declare variables for coupon and weekly grocery bills
        double coupon;
        double week1, week2, week3, week4;

        // Declare variables for calculated totals and averages
        double monthlyTotal, weeklyAverage;
        double discountedTotal, discountedAverage;

        // Prompt user for coupon amount in decimal form
        System.out.print("Enter coupon discount as a decimal (e.g., 0.10 for 10%): ");
        coupon = scanner.nextDouble();

        // Validate coupon: default to 10% if out of valid range
        if (coupon <= 0 || coupon > 1) {
            System.out.println("Invalid coupon value. Defaulting to 10% (0.10).");
            coupon = 0.10;
        }

        // Prompt user for each week's grocery bill
        System.out.print("Enter grocery bill for Week 1: $");
        week1 = scanner.nextDouble();

        System.out.print("Enter grocery bill for Week 2: $");
        week2 = scanner.nextDouble();

        System.out.print("Enter grocery bill for Week 3: $");
        week3 = scanner.nextDouble();

        System.out.print("Enter grocery bill for Week 4: $");
        week4 = scanner.nextDouble();

        // Calculate monthly total and weekly average (without coupon)
        monthlyTotal = week1 + week2 + week3 + week4;
        weeklyAverage = monthlyTotal / 4;

        // Calculate discounted total and average (with coupon)
        discountedTotal = monthlyTotal - (monthlyTotal * coupon);
        discountedAverage = discountedTotal / 4;

        // Display results without coupon
        System.out.println();
        System.out.println("**** Results Without Coupon ****");
        System.out.printf("Monthly Total:   $%.2f%n", monthlyTotal);
        System.out.printf("Weekly Average:  $%.2f%n", weeklyAverage);

        // Display results with coupon
        System.out.println();
        System.out.printf("**** Results With %.0f%% Coupon ****%n", coupon * 100);
        System.out.printf("Monthly Total:   $%.2f%n", discountedTotal);
        System.out.printf("Weekly Average:  $%.2f%n", discountedAverage);

        // Close the scanner
        scanner.close();
    }
}

import java.util.Scanner;

public class RecursiveProduct {

    // Recursively calculates the product of all elements in the array
    public static long calculateProduct(long[] numbers, int index) {
        if (index == 0) {
            return numbers[0];
        }
        return numbers[index] * calculateProduct(numbers, index - 1);
    }

    // Gathers validated input from the user
    public static long[] gatherInput(Scanner scanner, int count) {
        long[] numbers = new long[count];

        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Enter number " + (i + 1) + ": ");
                if (scanner.hasNextLong()) {
                    numbers[i] = scanner.nextLong();
                    break;
                } else {
                    System.out.println("  Invalid input. Please enter a whole number.");
                    scanner.next(); // clear the bad input
                }
            }
        }
        return numbers;
    }

    // Builds and prints the formatted equation
    public static void displayResult(long[] numbers, long product) {
        System.out.println("\n--- Result ---");
        StringBuilder equation = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) {
                equation.append(" x ");
            }
            equation.append(numbers[i]);
        }
        equation.append(" = ").append(product);

        System.out.println("The product of " + equation);
    }

    // Checks whether the product may have overflowed
    public static boolean hasOverflow(long[] numbers) {
        long result = 1;
        for (long num : numbers) {
            if (num != 0 && Math.abs(result) > Long.MAX_VALUE / Math.abs(num)) {
                return true;
            }
            result *= num;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 5;

        System.out.println("=== Recursive Product Calculator ===");
        System.out.println("Enter " + count + " numbers to calculate their product:\n");

        long[] numbers = gatherInput(scanner, count);
        long product = calculateProduct(numbers, numbers.length - 1);

        if (hasOverflow(numbers)) {
            System.out.println("\nWarning: The result may be inaccurate due to number overflow.");
        }

        displayResult(numbers, product);
        scanner.close();
    }
}

import java.util.Locale;
import java.util.Scanner;

public class RecursiveProduct {

    public static long calculateProduct(long[] numbers, int index) {
        if (index == 0) {
            return numbers[0];
        }
        return numbers[index] * calculateProduct(numbers, index - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        long[] numbers = new long[5];

        System.out.println("=== Recursive Product Calculator ===");
        System.out.println("Enter 5 numbers to calculate their product:\n");

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextLong();
        }

        long product = calculateProduct(numbers, numbers.length - 1);

        System.out.println("\n--- Result ---");
        System.out.print("The product of ");
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) System.out.print(" x ");
            System.out.print(numbers[i]);
        }
        System.out.println(" = " + product);

        scanner.close();
    }
}

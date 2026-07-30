import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice = 0;

        System.out.println("Welcome to the Library System!");

        while (choice != 6) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book       3. Return Book     5. Print All Books");
            System.out.println("2. Borrow Book    4. Search by Title 6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addBook(scanner, inventory);
                        break;
                    case 2:
                        borrowBook(scanner, inventory);
                        break;
                    case 3:
                        returnBook(scanner, inventory);
                        break;
                    case 4:
                        searchByTitle(scanner, inventory);
                        break;
                    case 5:
                        inventory.printAll();
                        break;
                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        scanner.close();
    }

    // Handles the Add Book process
    private static void addBook(Scanner scanner, Inventory inventory) {
        try {
            System.out.print("Enter book ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            System.out.print("Enter ISBN number: ");
            String isbn = scanner.nextLine();

            System.out.print("Enter number of pages: ");
            int pages = Integer.parseInt(scanner.nextLine());

            inventory.addBook(id, title, author, isbn, pages);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID and number of pages must be whole numbers.");
        }
    }

    // Handles the Borrow Book process
    private static void borrowBook(Scanner scanner, Inventory inventory) {
        try {
            System.out.print("Enter the ID of the book to borrow: ");
            int id = Integer.parseInt(scanner.nextLine());
            inventory.borrowBook(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid book ID.");
        }
    }

    // Handles the Return Book process
    private static void returnBook(Scanner scanner, Inventory inventory) {
        try {
            System.out.print("Enter the ID of the book to return: ");
            int id = Integer.parseInt(scanner.nextLine());
            inventory.returnBook(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid book ID.");
        }
    }

    // Handles the Search by Title process
    private static void searchByTitle(Scanner scanner, Inventory inventory) {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        inventory.searchByTitle(title);
    }
}

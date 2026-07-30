import java.util.ArrayList;

public class Inventory {
    private ArrayList<Book> mainInventory;
    private ArrayList<Book> lendingInventory;

    public Inventory() {
        mainInventory = new ArrayList<>();
        lendingInventory = new ArrayList<>();
    }

    // Add a new book to the main inventory
    public void addBook(int id, String title, String author, String isbn, int numberOfPages) {
        Book newBook = new Book(id, title, author, isbn, numberOfPages);
        mainInventory.add(newBook);
        System.out.println("Book added to the library.");
    }

    // Borrow a book by moving it from main inventory to lending inventory
    public void borrowBook(int id) {
        for (int i = 0; i < mainInventory.size(); i++) {
            if (mainInventory.get(i).getId() == id) {
                Book book = mainInventory.remove(i);
                lendingInventory.add(book);
                System.out.println("Book successfully borrowed.");
                return;
            }
        }
        System.out.println("Book not found in the library or already borrowed.");
    }

    // Return a book by moving it from lending inventory back to main inventory
    public void returnBook(int id) {
        if (lendingInventory.isEmpty()) {
            System.out.println("No books are currently borrowed.");
            return;
        }

        for (int i = 0; i < lendingInventory.size(); i++) {
            if (lendingInventory.get(i).getId() == id) {
                Book book = lendingInventory.remove(i);
                mainInventory.add(book);
                System.out.println("Book successfully returned.");
                return;
            }
        }
        System.out.println("Book not found in the lending list.");
    }

    // Print all books in the main inventory
    public void printAll() {
        if (mainInventory.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("=== Books Available in Library ===");
        for (Book book : mainInventory) {
            book.printBookInfo();
        }
    }

    // Search books by title (case-insensitive, partial match)
    public void searchByTitle(String title) {
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : mainInventory) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No matching book found.");
        } else {
            System.out.println("=== Search Results ===");
            for (Book book : results) {
                book.printBookInfo();
            }
        }
    }

    // Helper method to get count of available books
    public int getMainInventoryCount() {
        return mainInventory.size();
    }
}

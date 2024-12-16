/*
 * This should be your main class where all your objects will be created
 */
package org.example;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        Library library = new Library("City Library");

        // Add books
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addBook(new Book("Nana Kwadwo", "Gallows of love", 2024)); // Fixed missing semicolon

        // Register patrons
        Patron patron1 = new Patron("P001", "John Doe", "john.doe@example.com");
        Patron patron2 = new Patron("P002", "Jane Smith", "jane.smith@example.com");
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        // Display initial state
        System.out.println("Initial Library State:");
        library.displayBooks();
        library.displayPatrons();

        // Borrow a book
        System.out.println("\nBorrowing a Book (1984 by P001):");
        if (library.borrowBook("P001", "1984")) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book borrowing failed!");
        }

        // Display updated state
        System.out.println("\nLibrary State After Borrowing:");
        library.displayBooks();
        System.out.println("Borrowed Books for Patron P001:");
        patron1.getBorrowedBooks().forEach(System.out::println);

        // Return a book
        System.out.println("\nReturning a Book (1984 by P001):");
        if (library.returnBook("P001", "1984")) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book return failed!");
        }

        // Display final state
        System.out.println("\nFinal Library State:");
        library.displayBooks();
        System.out.println("Borrowed Books for Patron P001:");
        patron1.getBorrowedBooks().forEach(System.out::println);
    }




}

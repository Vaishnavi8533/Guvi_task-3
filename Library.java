package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(int bookID, String title, String author, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    // Getters
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(int bookID) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }

    public Book searchBook(String searchTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                return book;
            }
        }
        return null;
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books in Library:");
            for (Book book : books) {
                System.out.println("Book ID: " + book.getBookID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add some initial books
        library.addBook(new Book(1, "The Lord of the Rings", "J.R.R. Tolkien", true));
        library.addBook(new Book(2, "Pride and Prejudice", "Jane Austen", true));
        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee", true));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Book functionality
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookID, title, author, true));
                    break;
                case 2:
                    // Remove Book functionality
                    System.out.print("Enter Book ID to remove: ");
                    bookID = scanner.nextInt();
                    library.removeBook(bookID);
                    break;
                case 3:
                    // Search Book functionality
                    System.out.print("Enter Title to search: ");
                    scanner.nextLine(); // Consume newline character
                    String searchTitle = scanner.nextLine();
                    Book book = library.searchBook(searchTitle);
                    if (book != null) {
                        System.out.println("Book Found:");
                        System.out.println("Book ID: " + book.getBookID());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    // Display Books functionality
                    library.displayBooks();
                    break;
                case 5:
                    // Exit functionality
                    System.out.println("Exiting Library Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

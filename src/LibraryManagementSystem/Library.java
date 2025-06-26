import java.util.ArrayList;
import java.util.List;

public class Library {
    private String libraryName;
    private List<Book> books;
    private List<User> users;

    // constructor
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // add book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // add user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getName());
    }

    // issue book
    public boolean issueBook(String isbn, String userId) {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);
        if (book == null) {
            System.out.println("Book not found with ISBN: " + isbn);
            return false;
        }
        if (user == null) {
            System.out.println("User not found with ID: " + userId);
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is not available: " + book.getTitle());
            return false;
        }
        if (!user.canBorrowMoreBooks()) {
            System.out.println("User has reached maximum borrowing limit: " + user.getName());
            return false;
        }
        if (user.borrowBook(book)) {
            System.out.println("Book issued successfully!");
            System.out.println("Book: " + book.getTitle() + " -> User: " + user.getName());
            return true;
        }
        return false;
    }

    // return book
    public boolean returnBook(String isbn, String userId) {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);
        if (book == null || user == null) {
            System.out.println("Book or User not found");
            return false;
        }
        if (user.returnBook(book)) {
            System.out.println("Book returned successfully!");
            System.out.println("Book: " + book.getTitle() + " <- User: " + user.getName());
            return true;
        } else {
            System.out.println("Return failed - book may not be borrowed by this user");
            return false;
        }
    }

    // find book by isbn
    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // find user by id
    private User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // display all books
    public void displayAllBooks() {
        System.out.println("\n=== ALL BOOKS IN " + libraryName.toUpperCase() + " ===");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // display available books
    public void displayAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        boolean hasAvailable = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                hasAvailable = true;
            }
        }
        if (!hasAvailable) {
            System.out.println("No books available.");
        }
    }

    // display all users
    public void displayAllUsers() {
        System.out.println("\n=== ALL USERS ===");
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    // display user's borrowed books
    public void displayUserBorrowedBooks(String userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found: " + userId);
            return;
        }
        System.out.println("\n=== BOOKS BORROWED BY " + user.getName().toUpperCase() + " ===");
        List<Book> borrowedBooks = user.getBorrowedBooks();
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }
}
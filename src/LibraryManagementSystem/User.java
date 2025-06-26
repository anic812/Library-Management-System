import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;
    private List<Book> borrowedBooks;
    private static final int MAX_BOOKS = 5;

    // constructor
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    // getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public int getBorrowedBooksCount() {
        return borrowedBooks.size();
    }

    // can borrow more books
    public boolean canBorrowMoreBooks() {
        return borrowedBooks.size() < MAX_BOOKS;
    }

    // borrow book
    public boolean borrowBook(Book book) {
        if (canBorrowMoreBooks() && book.borrowBook(userId)) {
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    // return book
    public boolean returnBook(Book book) {
        if (borrowedBooks.contains(book) && book.returnBook()) {
            borrowedBooks.remove(book);
            return true;
        }
        return false;
    }

    // toString
    @Override
    public String toString() {
        return String.format("User: %s (%s) - %d books borrowed", name, userId, borrowedBooks.size());
    }
}
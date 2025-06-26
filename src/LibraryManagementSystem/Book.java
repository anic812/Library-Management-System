public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private String borrowedBy;

    // constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.borrowedBy = null;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    // borrow book
    public boolean borrowBook(String userId) {
        if (isAvailable) {
            this.isAvailable = false;
            this.borrowedBy = userId;
            return true; // successful borrowing
        }
        return false;
    }

    public boolean returnBook() {
        if (!isAvailable) {
            this.isAvailable = true;
            this.borrowedBy = null;
            return true; // successful return
        }
        return false; // book wasn't borrowed
    }

    // Override toString for better display
    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Borrowed by " + borrowedBy;
        return String.format("Book: %s by %s (ISBN: %s) - %s",
                title, author, isbn, status);
    }
}

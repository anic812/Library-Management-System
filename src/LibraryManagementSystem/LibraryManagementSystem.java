
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // create library
        Library library = new Library("Central City Library");

        System.out.println("=== LIBRARY MANAGEMENT SYSTEM DEMO ===\n");

        // add books
        System.out.println("1. Adding Books to Library:");
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4"));
        library.addBook(new Book("1984", "George Orwell", "978-0-452-28423-4"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0"));

        // add users
        System.out.println("\n2. Registering Users:");
        library.addUser(new User("U001", "Alice Johnson", "alice@email.com"));
        library.addUser(new User("U002", "Bob Smith", "bob@email.com"));
        library.addUser(new User("U003", "Carol Davis", "carol@email.com"));

        // show all books and users
        library.displayAllBooks();
        library.displayAllUsers();

        // borrow books
        System.out.println("\n3. Book Borrowing Operations:");
        library.issueBook("978-0-7432-7356-5", "U001");
        library.issueBook("978-0-06-112008-4", "U001");
        library.issueBook("978-0-452-28423-4", "U002");

        // try to borrow already borrowed book
        System.out.println("\n4. Attempting to borrow already borrowed book:");
        library.issueBook("978-0-7432-7356-5", "U002");

        // show status
        library.displayAllBooks();
        library.displayAvailableBooks();
        library.displayUserBorrowedBooks("U001");

        // return book
        System.out.println("\n5. Book Return Operations:");
        library.returnBook("978-0-7432-7356-5", "U001");

        // show final status
        library.displayAllBooks();
        library.displayAvailableBooks();
        library.displayUserBorrowedBooks("U001");

        // error handling
        System.out.println("\n6. Error Handling Examples:");
        library.issueBook("978-0-000-00000-0", "U001");
        library.issueBook("978-0-14-143951-8", "U999");
        library.returnBook("978-0-06-112008-4", "U002");

       
    }
}
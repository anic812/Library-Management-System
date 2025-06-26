# Library Management System

A simple Java-based Library Management System for managing books and users, allowing book borrowing and returning operations.

## Features

- Add and display books
- Register and display users
- Issue (borrow) books to users
- Return books
- Display available books
- Show books borrowed by a user
- Basic error handling for invalid operations

## Project Structure

- `src/LibraryManagementSystem/Book.java` - Book entity
- `src/LibraryManagementSystem/User.java` - User entity
- `src/LibraryManagementSystem/Library.java` - Library logic
- `src/LibraryManagementSystem/LibraryManagementSystem.java` - Main demo class

## How to Run

1. Compile all Java files in the `src/LibraryManagementSystem` directory.
2. Run the `LibraryManagementSystem` main class.

Example (from project root):

```sh
javac -d bin src/LibraryManagementSystem/*.java
java -cp bin LibraryManagementSystem.LibraryManagementSystem
```

## Requirements

- Java 8 or above

---

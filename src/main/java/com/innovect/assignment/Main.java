package main.java.com.innovect.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Library library = Library.getInstance();
    private String title;
    private String language;
    private List<Author> authors;
    private String category;

    public static void main(String[] args) {

        new Main().Start();

    }


    public void Start() {

        while (true) {
            System.out.println("********************************************");
            System.out.println("  Welcome to Library Management System ");
            System.out.println("********************************************");
            System.out.println("--- Please select you option to take action --- ");
            System.out.println("Press 1 to Add Book");
            System.out.println("Press 2 to Delete a book");
            System.out.println("Press 3 to Search book by title");
            System.out.println("Press 4 to Search book by author");
            System.out.println("Press 5 to Issue book");
            System.out.println("Press 6 to View book list");
            System.out.println("Press 7 to View book list by author");
            System.out.println("Press 8 to View all issued books");
            System.out.println("Press 9 to exit");
            int choice = scanner.nextInt() - 1;
            scanner.nextLine();

            SwitchOperations userChoice = SwitchOperations.values()[choice];
            switch (userChoice) {
                case ADD_BOOK:
                    this.addBook();
                    break;
                case DELETE_BOOK:
                    this.deleteBook();
                    break;
                case SEARCH_BY_TITLE:
                    this.searchByTitle();

                    break;
                case SEARCH_BY_AUTHOR:
                    this.searchByAuthors();
                    break;
                case VIEW_ALL_BOOKS:
                    this.viewAllBooks();
                    break;
                case ISSUE_BOOK:
                    this.searchByTitle();
                    break;

                case VIEW_BY_CATEGORY:
                    this.viewBookByCategory();
                    break;
                case ISSUED_BOOKS:
                    Map<String, List<Book>> allissuedBooks = library.viewIssuedBooks();
                    for (Map.Entry<String, List<Book>> entry : allissuedBooks.entrySet()) {
                        System.out.println("user = " + entry.getKey());
                        List<Book> currentUserBooks = entry.getValue();
                        currentUserBooks.stream().forEach(currenBook ->
                                {
                                    displayBook(currenBook);
                                }
                        );
                    }
                    break;
                case EXIT:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }


    }

    private static void addBook() {
        String title;
        String category;
        String language;
        Author author;
        List<Author> authorList = new ArrayList<>();
        System.out.println("Enter title");
        title = scanner.nextLine();
        System.out.println("Enter category");
        category = scanner.nextLine();
        System.out.println("Enter language");
        language = scanner.nextLine();
        System.out.println("Enter number authors");
        int noOfAuthors = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= noOfAuthors; i++) {
            System.out.println("Enter name of author " + i);
            authorList.add(new Author(scanner.nextLine()));
        }
        Book book = new Book(title, language, category, authorList);
        library.addBookItem(book);
    }

    private void deleteBook() {
        System.out.println("Enter title to delete a book");
        String bookTitle;
        bookTitle = scanner.nextLine();
        boolean isdeleted = library.deleteBookItem(bookTitle);
        if (isdeleted)
            System.out.println("Book delete succesfuly");
        else
            System.out.println("Book not found");
    }

    private void searchByTitle() {
        boolean isFound = true;
        System.out.println("enter title to search");
        BooksInventory bookForTitle = library.searchByTitle(scanner.nextLine());
        if (bookForTitle == null) {
            System.out.println("Book not available in libray");

        } else {
            Book thisBook = bookForTitle.getBook();
            this.displayBook(thisBook);

        }

        System.out.println("want to issue book[Y/N]");
        String ch = scanner.nextLine();
        String userName = null;
        if (ch.equals("Y") || ch.equals("y"))
            System.out.println("enter your name to proceed");
        userName = scanner.nextLine();
        library.issueBook(userName);

    }

    private void displayBook(Book thisBook) {
        System.out.println("Title -> " + thisBook.getTitle());
        System.out.println("Category -> " + thisBook.getCategory());
        System.out.println("Language -> " + thisBook.getLanguage());
        thisBook.getAuthors().stream().forEach(author -> {
            System.out.println("author -> " + author.getAuthorName());
        });
        System.out.println();
    }

    private void searchByAuthors() {
        System.out.println("enter author to search");
        List<BooksInventory> bookForAuthor = library.searchByAuthor(scanner.nextLine());
        if (bookForAuthor.isEmpty()) {
            System.out.println("Book not available for this author");
        } else {
            bookForAuthor.stream().forEach(books -> {
                displayBook(books.getBook());
            });
        }
    }

    private void viewAllBooks() {
        List<BooksInventory> listOfBooks = library.getBookList();
        listOfBooks.stream().forEach(book -> {
            displayBook(book.getBook());
        });
    }

    private void viewBookByCategory() {
        System.out.println("enter category to search");
        List<BooksInventory> booksBycategory = library.searchByCategory(scanner.nextLine());
        if (booksBycategory.isEmpty()) {
            System.out.println("Book not available for this author");
        } else {
            booksBycategory.stream().forEach(books -> {
                displayBook(books.getBook());
            });
        }
    }

}





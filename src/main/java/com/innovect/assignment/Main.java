package main.java.com.innovect.assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.java.com.innovect.assignment.BookCategory;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author("amol"));
        Book book2 = new Book("Advance computing","English", BookCategory.SCI_FI.getCatgory(), authorList);
        library.addBookItem(book2);

        List<Author> authorList1 = new ArrayList<>();
        authorList1.add(new Author("amol11"));
        Book book1 = new Book("Advance computing", "English", BookCategory.SCI_FI.getCatgory(), authorList1);
        library.addBookItem(book1);


//        library.getBookList().stream().forEach(book ->
//                {
//                System.out.println(book.getBooks().getTitle());
//                System.out.println(book.getQuantity());
//                }
//
//
//                );


//        Start Search By authors
//        List<Book> bookListbyAuthor=library.searchByAuthor("amol");
//        bookListbyAuthor.stream().forEach(authorsBook-> System.out.println(authorsBook.getTitle()));
//     End search by authors


//        Start view by categery

//        List<Book> bookListbyCategory = library.seachByCategory(BookCategory.SCI_FI.getCatgory());
//        bookListbyCategory.stream().forEach(categoryBook -> System.out.println(categoryBook.getTitle()));


//                End search by category



    }
}

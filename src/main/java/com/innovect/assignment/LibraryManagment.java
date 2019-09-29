package main.java.com.innovect.assignment;

import java.util.List;
import java.util.Map;

public interface LibraryManagment {

    public Boolean addBookItem(Book book);
    public Boolean deleteBookItem(String name);
    public BooksInventory searchByTitle(String title);
    public List<BooksInventory> searchByAuthor(String author);
    public Book issueBook(String username);
    public List<BooksInventory> getBookList();
    public List<BooksInventory> searchByCategory(String category);
    public Map<String,List<Book>> viewIssuedBooks();
}

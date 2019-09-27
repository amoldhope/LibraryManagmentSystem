package main.java.com.innovect.assignment;

import java.util.List;

public interface LibraryManagment {

    public Boolean addBookItem(Book book);
    public Boolean deleteBookItem(String name);
    public BooksInventory searchByTitle(String title);
    public List<BooksInventory> searchByAuthor(String author);
    public Book issueBook();
    public List<BooksInventory> getBookList();
    public List<BooksInventory> seachByCategory(String category);
}

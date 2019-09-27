package main.java.com.innovect.assignment;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryManagment {
    List<BooksInventory> bookList = new ArrayList<>();
    static Library library = null;

    private Library() {
    }

    public static Library getInstance() {

        if (library == null)
            return new Library();

        return library;
    }

    @Override
    public Boolean addBookItem(Book newBook) {
        BooksInventory book = isExist(newBook);
        if (book == null) {
            bookList.add(new BooksInventory(newBook, 1));
            return true;
        }
        book.setQuantity(book.getQuantity() + 1);
        return true;
    }


    private BooksInventory isExist(Book newItem) {
        for (BooksInventory item : bookList) {
            if (item.getBooks().getTitle().equals(newItem.getTitle())) {
                return item;
            }
        }
        return null;
    }





    @Override
    public Boolean deleteBookItem(String title) {
        BooksInventory book = searchByTitle(title);
        if (book != null) {
            bookList.remove(book);
            return true;
        }
        return false;
    }

    @Override
    public BooksInventory searchByTitle(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            BooksInventory book = bookList.get(i);
            if (book.getBooks().getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<BooksInventory> searchByAuthor(String author) {
        List<BooksInventory> searchedBooks = new ArrayList<>();
        for (BooksInventory book : bookList) {
            List<Author> authorList = book.getBooks().getAuthors();
            for (Author author1 : authorList) {
                if (author1.getAuthorName().equals(author)) {
                    searchedBooks.add(book);
                }
            }

        }
        return searchedBooks;
    }

    @Override
    public Book issueBook() {
        return null;
    }

    @Override
    public List<BooksInventory> getBookList() {
        return bookList;
    }

    @Override
    public List<BooksInventory> seachByCategory(String category) {
        List<BooksInventory> searchedBooks = new ArrayList<>();
        for (BooksInventory book : bookList) {
            if (book.getBooks().getCategory().equals(category)) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }


}

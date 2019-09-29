package main.java.com.innovect.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements LibraryManagment {

    Book currentBook;
    List<BooksInventory> bookList = new ArrayList<>();
    Map<String, List<Book>> issuedBooks = new HashMap<>();
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
            if (item.getBook().getTitle().equals(newItem.getTitle())) {
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
            if (book.getBook().getTitle().equals(title)) {
                currentBook = book.getBook();
                return book;
            }
        }
        return null;
    }

    @Override
    public List<BooksInventory> searchByAuthor(String author) {
        List<BooksInventory> searchedBooks = new ArrayList<>();
        for (BooksInventory book : bookList) {
            List<Author> authorList = book.getBook().getAuthors();
            for (Author author1 : authorList) {
                if (author1.getAuthorName().equals(author)) {
                    searchedBooks.add(book);
                }
            }

        }
        return searchedBooks;
    }

    @Override
    public Book issueBook(String userName) {
        boolean isUserPresent = issuedBooks.containsKey(userName);
        ArrayList<Book> newList = null;
        if (isUserPresent) {
            List<Book> usersBook = issuedBooks.get(userName);
            usersBook.add(currentBook);
        } else {
            newList = new ArrayList<>();
            newList.add(currentBook);
            issuedBooks.put(userName,newList);
        }

        decreaseBookQuatity();

        return currentBook;

    }

    private void decreaseBookQuatity() {
        for (BooksInventory booksInventory : bookList) {
            if (currentBook == booksInventory.getBook()) {
                booksInventory.setQuantity(booksInventory.getQuantity() - 1);
            }
        }
    }

    @Override
    public List<BooksInventory> getBookList() {
        return bookList;
    }

    @Override
    public List<BooksInventory> searchByCategory(String category) {
        List<BooksInventory> searchedBooks = new ArrayList<>();
        for (BooksInventory book : bookList) {
            if (book.getBook().getCategory().equals(category)) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    @Override
    public Map<String, List<Book>> viewIssuedBooks() {
     return   issuedBooks;
    }


}

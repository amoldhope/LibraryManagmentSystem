package main.java.com.innovect.assignment;

public class BooksInventory {

    private Book books;
    private int quantity;

    public BooksInventory(Book books, int quantity) {
        this.books = books;
        this.quantity = quantity;
    }

    public Book getBooks() {
        return books;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

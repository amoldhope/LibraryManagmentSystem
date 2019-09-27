package main.java.com.innovect.assignment;

public enum BookCategory {
    SCI_FI("Science Fiction"),
    HORROR("Horror");

    public String getCatgory() {
        return catgory;
    }

    private final String catgory;

    BookCategory(String category) {
        this.catgory=category;
    }
}

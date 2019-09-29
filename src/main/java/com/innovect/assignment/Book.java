package main.java.com.innovect.assignment;

import java.util.List;

public class Book {
    private String title;
    private String language;
    private List<Author> authors;
    private String category;

    public String getCategory() {
        return category;
    }

    public Book(String title, String language, String category, List<Author> authors) {
        this.title = title;
        this.language = language;
        this.authors = authors;
        this.category=category;
    }


    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}

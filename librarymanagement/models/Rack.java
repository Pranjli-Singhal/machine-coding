package com.pranjli.machinecoding.librarymanagement.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Rack {

    Map<String, Book> books;
    Map<String, String> copyToBook;

    public Rack(Map<String, Book> books, Map<String, String> copyToBook) {
        this.books = books;
        this.copyToBook = copyToBook;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    public Map<String, String> getCopyToBook() {
        return copyToBook;
    }

    public void setCopyToBook(Map<String, String> copyToBook) {
        this.copyToBook = copyToBook;
    }
}

package com.pranjli.machinecoding.librarymanagement.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Rack {
    Map<String, Book> books;
    int id;

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }

    public Rack(Map<String, Book> books, int id) {
        this.books = books;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Book> getBooks() {
        return books;
    }


}

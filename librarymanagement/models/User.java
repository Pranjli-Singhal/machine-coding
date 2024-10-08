package com.pranjli.machinecoding.librarymanagement.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String id;
    String name;
    int borrowedBooks;
    List<List<String>> borrowed;

    public User(String id, String name, int borrowedBooks, List<List<String>> borrowed) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = borrowedBooks;
        this.borrowed = borrowed;
    }

    public List<List<String>> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(List<List<String>> borrowed) {
        this.borrowed = borrowed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public User(String id) {
        this.id = id;
        this.borrowedBooks = 0;
        this.borrowed = new ArrayList<>();
    }
}


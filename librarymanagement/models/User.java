package com.pranjli.machinecoding.librarymanagement.models;

public class User {
    int id;
    String name;
    int borrowedBooks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public User(int id, String name, int borrowedBooks) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = borrowedBooks;
    }
}

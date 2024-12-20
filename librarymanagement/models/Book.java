package com.pranjli.machinecoding.librarymanagement.models;

import java.util.List;

public class Book {

    String id;
    String title;
    List<String> authors;
    List<String> publishers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    public Book(String id, String title, List<String> authors, List<String> publishers) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
    }
}

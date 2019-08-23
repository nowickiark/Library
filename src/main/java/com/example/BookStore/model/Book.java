package com.example.BookStore.model;

import java.time.LocalDate;

public class Book {

    private int id;
    private String author;
    private String title;
    private LocalDate dateOfReturn;

    public Book(int id,String title,String author,LocalDate dateOfReturn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.dateOfReturn = dateOfReturn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", dateOfReturn=" + dateOfReturn +
                '}';
    }
}

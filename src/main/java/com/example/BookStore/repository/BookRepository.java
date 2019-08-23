package com.example.BookStore.repository;

import com.example.BookStore.model.Book;

import java.util.List;

public interface BookRepository {

    public String borrowBook(long id);
    public void addBook(String title,String author);
    public void delateBook(long id);
    public String returnBook(long id);
    public List<Book> getBooks();

}

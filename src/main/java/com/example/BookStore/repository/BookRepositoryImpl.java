package com.example.BookStore.repository;

import com.example.BookStore.model.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private List<Book> books;

    public BookRepositoryImpl(){

        books = new ArrayList<>();

        books.add(new Book(1,"Jan Brzechwa","Akademia Pana Kleksa", LocalDate.now()));
        books.add(new Book(2,"Sofokles","Antygona",LocalDate.now()));
        books.add(new Book(3,"Stanisław Lem","Bajki Robotów",LocalDate.now()));
        books.add(new Book(4,"Nieznany","Biblia",LocalDate.now()));
        books.add(new Book(5,"Ryszard Kapuściński","Cesarz",LocalDate.now()));
        books.add(new Book(6,"Zoffia Kossak","Bursztyny",LocalDate.now()));
        books.add(new Book(7,"Adam Mickiewicz","Dziady",LocalDate.now()));
        books.add(new Book(8,"Albert Camus","Dżuma",LocalDate.now()));
        books.add(new Book(9,"Witold Gombrowicz","Ferdydurke",LocalDate.now()));
        books.add(new Book(10,"Homer","Iliada",LocalDate.now()));
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String borrowBook(long id) {

        Book book = books.stream().filter(b->b.getId()==id).findAny().get();

        String returnMessage;

        if (book != null){
            book.setDateOfReturn(null);
            returnMessage = "You've succefully borrowed book";
        } else {
            returnMessage = "The book is currently unavailable";
        }

        return returnMessage;


    }

    @Override
    public void addBook(String title,String author ) {

        int id = books.stream().mapToInt(a->a.getId()).max().orElseThrow(NoSuchElementException::new) + 1;

        books.add(new Book(id,title,author,LocalDate.now()));

    }

    @Override
    public void delateBook(long id) {

        for(int i=0; i<books.size() ;i++){

            if(books.get(i).getId() == id){
                books.remove(i);
            }
        }

    }

    @Override
    public String returnBook(long id) {

        books.stream().filter(b->b.getId() == id).findFirst().get().setDateOfReturn(LocalDate.now());
        return "Thank you for returning a book";

    }
}

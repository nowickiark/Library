package com.example.BookStore.service;

import com.example.BookStore.model.Book;
import com.example.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class OrderService {

    private InputReader inputReader;
    private BookRepository bookRepository;
    private int id;
    private String message;
    private boolean exit = false;

    @Autowired
    public OrderService(InputReader inputReader, BookRepository bookRepository){
        this.inputReader = inputReader;
        this.bookRepository = bookRepository;
    }

    public void action(){

        while (!exit) {

            int actionNumber = inputReader.readAction();

            switch (actionNumber) {
                case 1:
                    System.out.println("Write an id of the book to borrow");
                    message = bookRepository.borrowBook(inputReader.readInt());
                    System.out.println(message);
                    break;
                case 2:
                    System.out.println("Write an id of the book to return");
                    message = bookRepository.returnBook(inputReader.readInt());
                    System.out.println(message);
                    break;
                case 3:
                    System.out.println("Write name of the book to add to library");
                    String name = inputReader.reatString();
                    System.out.println("Write author of the book");
                    String author = inputReader.reatString();
                    bookRepository.addBook(name, author);
                    break;
                case 4:
                    System.out.println("Write id of the book to dalate from the library");
                    bookRepository.delateBook(inputReader.readInt());
                    break;
                case 5:
                    List<Book> books = bookRepository.getBooks();
                    books.stream().forEach(System.out::println);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Bye bye!");
                    break;
            }

        }



    }



}

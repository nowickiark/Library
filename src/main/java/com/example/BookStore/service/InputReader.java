package com.example.BookStore.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputReader {

    Scanner scanner = new Scanner(System.in);

    public int readAction(){
        printMenu();
        int action = scanner.nextInt();
        return action;
    }

    public int readInt(){
        int i = scanner.nextInt();
        return i;
    }

    public String reatString(){
        String s = scanner.nextLine();
        return s;
    }

    public void printMenu(){
        System.out.println("Please chose the action :");
        System.out.println("1.Borrow the book");
        System.out.println("2.Return a book");
        System.out.println("3.Add the book to database");
        System.out.println("4.Delete a book from database");
        System.out.println("5.Show all the books");
        System.out.println("6.Exit the program");
    }

}

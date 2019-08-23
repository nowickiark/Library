package com.example.BookStore.controller;

import com.example.BookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControler {

    private OrderService orderService;

    @Autowired
    public BookControler(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping("/")
    public void run(){
        orderService.action();
    }

}

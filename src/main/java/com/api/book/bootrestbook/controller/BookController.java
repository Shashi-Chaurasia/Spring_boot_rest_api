package com.api.book.bootrestbook.controller;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/books")
    public Book getBook(){
        Book book = new Book();
        book.setId(222);
        book.setBookName("Half Girl friend");
        book.setAuthor("Chetan Bhagat");
        return book;

    }

}

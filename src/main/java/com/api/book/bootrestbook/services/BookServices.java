package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.book.bootrestbook.entities.Book;

import org.springframework.stereotype.Component;


@Component
public class BookServices {
    
    private static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(123, "java programming", "Ramanujan"));
        list.add(new Book(234, "Python programming", "Satyawan"));
        list.add(new Book(345, "Dat programming", "Shashi"));
    }

    /*----------------------------Get Multiple Book-------------------- */
    public List<Book> getAllBooks(){
        return list;

    }

    /*--------------------------------Get Single Book---------------------*/
    public Book getBookById(int id){
        Book book = null;
        try {
            book = list.stream().filter(e ->e.getId() == id).findFirst().get();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        return book;
    }

    /*-------------------------Adding the book-----------------------------------*/
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    /*---------------------------Delete operation---------------------------------*/
    public void deleteBook(int bid){
        list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());

    }

    /*--------------------------Update operation------------------------------------*/
    public void updateBook(Book book , int bid){
        list.stream().map(b -> {
            if (book.getId() == bid) {
                b.setBookName(book.getBookName());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}

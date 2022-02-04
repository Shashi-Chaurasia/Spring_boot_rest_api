package com.api.book.bootrestbook.controller;
import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookServices bookServices;

    /*----------------Get Multiple Book Handler-----------*/
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBook(){
        List<Book> list  = this.bookServices.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
            
        return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }

    /*------------------Get Single book Handler--------------*/
    @GetMapping("books/{id}")
    public ResponseEntity<Book> getBooks(@PathVariable("id") int id){
        
        Book book = this.bookServices.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return  ResponseEntity.of(Optional.of(book));
    }

    /*---------------------Post Handler-----------*/
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b = null;
        try {
            b = this.bookServices.addBook(book);
            System.out.println(b);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        
    }

    /*----------------Delete handler------------------*/
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBooks(@PathVariable("bookId") int bookId){

        try {
            this.bookServices.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
          
        }
     
      

    }

    /*-----------------Update handler---------------------*/
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable("bookId") int bookId){
        try {
            this.bookServices.updateBook(book, bookId);
            return ResponseEntity.status(HttpStatus.OK).build();
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      
    }

    }

}

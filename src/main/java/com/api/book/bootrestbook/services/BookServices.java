package com.api.book.bootrestbook.services;

import java.util.List;

import com.api.book.bootrestbook.dao.BookRespository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookServices {
    
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(123, "java programming", "Ramanujan"));
    //     list.add(new Book(234, "Python programming", "Satyawan"));
    //     list.add(new Book(345, "Dat programming", "Shashi"));
    // }

    @Autowired
    private BookRespository bookRespository;
    /*----------------------------Get Multiple Book-------------------- */
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>) this.bookRespository.findAll();
        return list;

    }

    /*--------------------------------Get Single Book---------------------*/
    public Book getBookById(int id){
        Book book = null;
        try {
            book = this.bookRespository.findById(id);
            // book = list.stream().filter(e ->e.getId() == id).findFirst().get();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        return book;
    }

    /*-------------------------Adding the book-----------------------------------*/
    public Book addBook(Book b){
        Book result = this.bookRespository.save(b);
        // list.add(b);
        return result;
    }

    /*---------------------------Delete operation---------------------------------*/
    public void deleteBook(int bid){

        this.bookRespository.deleteById(bid);
        // list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());

    }

    /*--------------------------Update operation------------------------------------*/
    public void updateBook(Book book , int bid){
        // list.stream().map(b -> {
        //     if (book.getId() == bid) {
        //         b.setBookName(book.getBookName());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(bid);
        this.bookRespository.save(book);

           
            
    }
}

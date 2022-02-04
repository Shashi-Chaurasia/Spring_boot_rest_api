package com.api.book.bootrestbook.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Book_store")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Book_Id")
    private int id;

    @Column(name = "Book_Name")
    private String bookName;

    
   
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;


    public Book(int id, String bookName, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

    public Book(){

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getBookName() {
        return bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public Author getAuthor() {
        return author;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Book [author=" + author + ", bookName=" + bookName + ", id=" + id + "]";
    }

    


    
    
}

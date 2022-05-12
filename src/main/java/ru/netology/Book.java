package ru.netology;


public class Book extends Product {

    protected String author;

    public Book(String name, int id, String author) {
        super(id, name);
        this.author = author;
    }


}



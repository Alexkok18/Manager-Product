package ru.netology;

import lombok.AllArgsConstructor;


@AllArgsConstructor

public class Product {
    protected int id;
    protected String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

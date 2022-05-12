package ru.netology;


public class Smartphone extends Product {
    protected String manufacturer;

    public Smartphone(String name, int id, String manufacturer) {
        super(id, name);
        this.manufacturer = manufacturer;
    }


}

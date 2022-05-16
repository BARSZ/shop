package com.company;
import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private double price;
    private Category category;
    private final LocalDate expirationDate;

    public Product(int id, String name, double price, Category category, LocalDate expirationDate){
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.expirationDate = expirationDate;
    }
    public String toString(){
        System.out.println();
        return "ID: " + this.id + "\nName: " + this.name + "\nPrice: " + this.price + "\nExpiration Date: " + this.expirationDate;
    }
}

package com.company;
import java.time.LocalDate;

public class Product extends Base {
    private Category category;
    private final String expirationDate;

    public Product(int id, String name, double price, Category category, String expirationDate){
        super(id, name, price);
        this.category = category;
        this.expirationDate = expirationDate;
    }
    public Product(){
        this.expirationDate = "2022-08-09";
    }
    @Override public String toString(){
        System.out.println();
        return (super.toString() + "\nExpiration Date: " + this.expirationDate);
    }
    public Category GetProductCategory(){
        return this.category;
    }
    public LocalDate GetProductExpirationDate(){
        return LocalDate.parse(this.expirationDate);
    }
}

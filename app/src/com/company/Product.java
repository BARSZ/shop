package com.company;
import java.time.LocalDate;

public class Product extends Base {
    private Category category;
    private final String expirationDate;
    private int stock;
    public Product(int id, String name, double price, Category category, String expirationDate, int stock){
        super(id, name, price);
        this.category = category;
        this.expirationDate = expirationDate;
        this.stock = stock;
    }
    public Product(){
        this.expirationDate = "2022-08-09";
    }
    @Override public String toString(){
        System.out.println();
        return (super.toString() + "\nExpiration Date: " + this.expirationDate + "\nStock: " + this.stock);
    }
    public Category GetProductCategory(){
        return this.category;
    }
    public LocalDate GetProductExpirationDate(){
        return LocalDate.parse(this.expirationDate);
    }
    public boolean isExpired(){
        if(this.GetProductExpirationDate().isBefore(LocalDate.now())){
            return true;
        }
        return false;
    }
    public void RemoveFromStock(){
        this.stock -= 1;
    }
}

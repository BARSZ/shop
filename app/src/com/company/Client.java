package com.company;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private double money;
    private List<Product> basket;

    public Client(String name, double money){
        this.name = name;
        this.money = money;
        basket = new ArrayList<Product>();
    }
    public double GetMoney(){
        return this.money;
    }
    public List<Product> GetBasket(){
        return this.basket;
    }
    public void AddProduct(Product product){
        basket.add(product);
    }
    public void RemoveProduct(Product product){
        for (Product p : this.basket)
        {
            if(p.GetName() == product.GetName()){
                basket.remove(p);
            }
        }
    }
    public void PrintBasket(){
        System.out.println("Basket for " + this.name);
        for (int i = 0; i < basket.size() ; i++) {
            System.out.println(basket.get(i).toString());
        }
    }
    public String GetName(){
        return this.name;
    }
}

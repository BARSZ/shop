package com.company;

public class Base {
    private int id;
    private String name;
    private double price;

    public Base(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Base(){}
    public String GetName(){
        return this.name;
    }
    public double GetPrice(){
        return this.price;
    }
    public int GetId(){
        return this.id;
    }
    public String toString(){
        return ("ID: " + this.id + "\nName: " + this.name + "\nInitial Price: " + this.price + " leva");
    }
}

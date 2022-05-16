package com.company;

public class Worker {
    private static int count = 0;

    private int id;
    private String name;
    private double salary;

    public Worker(String name, double salary) {
        this.id = ++count;
        this.name = name;
        this.salary = salary;
    }
    public String toString(){
        System.out.println();
        return "ID: " + this.id + "\nName: " + this.name + "\nSalary: " + this.salary;
    }
}

package com.company;

public class Worker extends Base {

    public Worker(int id, String name, double salary) {
        super(id, name, salary);
    }
    @Override public String toString(){
        return ("ID: " + this.GetId() + "\nName: " + this.GetName() + "\nSalary: " + this.GetPrice() + " leva");
    }
}

package com.company;

public class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            try{
                sleep(2000);
                System.out.println(i);
            }catch (InterruptedException w){
            }
        }
    }
}

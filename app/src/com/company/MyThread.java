package com.company;

public class MyThread implements Runnable{
    private Shop shop;
    private Client client;
    public MyThread(Shop shop, Client client){
        this.shop = shop;
        this.client = client;
    }
    public void run() {
        for (int i = 0; i < client.GetBasket().size() ; i++) {
            try{
                Thread.sleep(2000);
                Product product = client.GetBasket().get(i);
                System.out.println(client.GetName() + " buys " + product.GetName() + " for " + this.shop.CalculateProductPrice(product));
                System.out.println();
            }catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }

        }
    }
}

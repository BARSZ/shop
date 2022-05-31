package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    private static int productId = 1;
    private static int workerId = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Shop> shops = new ArrayList<Shop>();

        //region Add Metro Shop
        Shop metro = new Shop("Metro", 10, 15, 3, 10);

        Product sapun = new Product(productId++,"Sapun", 5, Category.NONFOOD, "2022-09-30", 60);
        Product shampoo = new Product(productId++,"Shampoo", 6, Category.NONFOOD, "2022-09-30", 87);

        Worker pesho = new Worker(workerId++,"Pesho", 700);
        Worker gregorii = new Worker(workerId++,"Gregorii", 960);

        CashRegister cashRegisterM = new CashRegister("A", pesho);
        CashRegister cashRegisterM1 = new CashRegister("B", gregorii);

        metro.AddProduct(sapun);
        metro.AddProduct(shampoo);
        metro.AddWorker(pesho);
        metro.AddWorker(gregorii);
        metro.AddCashRegister(cashRegisterM);
        metro.AddCashRegister(cashRegisterM1);
        //endregion

        //region Add Fantastiko Shop
        Shop fantastiko = new Shop("Fantastiko", 12, 16, 4, 10);

        Product olio = new Product(productId++,"Olio", 12, Category.FOOD, "2022-09-30", 97);
        Product magdanoz = new Product(productId++,"Magdanoz", 1, Category.FOOD, "2022-09-30", 0);

        Worker vivaldi = new Worker(workerId++,"Vivaldi", 730);
        Worker frodo = new Worker(workerId++,"Frodo", 570);

        CashRegister cashRegisterF = new CashRegister("A", vivaldi);
        CashRegister cashRegisterF1 = new CashRegister("B", frodo);

        fantastiko.AddProduct(olio);
        fantastiko.AddProduct(magdanoz);
        fantastiko.AddWorker(vivaldi);
        fantastiko.AddWorker(frodo);
        fantastiko.AddCashRegister(cashRegisterF);
        fantastiko.AddCashRegister(cashRegisterF1);
        //endregion

        shops.add(metro);
        shops.add(fantastiko);
        int command;
        String commandAgain = "y";

        while(Objects.equals(commandAgain, "y")) {
            //region Commands
            System.out.println("Press 1 To Add Shop");
            System.out.println("Press 2 To Add Product To Shop");
            System.out.println("Press 3 To Add Workers To Shop");
            System.out.println("Press 5 To See All Shops");
            System.out.println("Press 6 To See All Products For A Shop");
            System.out.println("Press 7 To See All Workers For A Shop");
            System.out.println("Press 8 To Calculate Price for Product In Shop");
            System.out.println("Press 10 To Test Working Shop");
            //endregion
            command = Integer.parseInt(reader.readLine());

            if (command == 1) {
                Shop shop = EnterShop();
                shops.add(shop);
                System.out.println("Shop added\n" + System.lineSeparator() + shop.toString() + System.lineSeparator());
            } else if (command == 2) {
                PrintShops(shops);
                System.out.print("Enter Shop Name: ");

                //CHOOSE SHOP
                Shop chosenShop = ChooseShop(shops);
                if(chosenShop != null){
                    System.out.println("Chosen shop is");
                    System.out.println();
                    System.out.println(chosenShop.toString());
                    Product product = EnterProduct();
                    chosenShop.AddProduct(product);
                    for (int i = 0; i < shops.size() ; i++) {
                        if(Objects.equals(shops.get(i).getName(), chosenShop.getName())){
                            shops.set(i, chosenShop);
                            break;
                        }
                    }
                    System.out.println("Product has been added!");
                } else{
                    System.out.println("Shop doesn't exist!");
                }


            } else if (command == 3) {
                PrintShops(shops);
                System.out.print("Enter Shop Name: ");

                //CHOOSE SHOP
                Shop chosenShop = ChooseShop(shops);
                if(chosenShop != null){
                    System.out.println();
                    System.out.println(chosenShop.toString());

                    Worker worker = EnterWorker();

                    chosenShop.AddWorker(worker);
                    for (int i = 0; i < shops.size() ; i++) {
                        if(Objects.equals(shops.get(i).getName(), chosenShop.getName())){
                            shops.set(i, chosenShop);
                            break;
                        }
                    }
                    System.out.println("Worker has been added!");
                } else {
                    System.out.println("Shop doesn't exist!");
                }

            }else if (command == 4){

            }else if (command == 5){
                PrintShops(shops);
            }else if (command == 6){
                PrintShops(shops);
                System.out.print("Enter Shop Name: ");

                //CHOOSE SHOP
                Shop chosenShop = ChooseShop(shops);
                if(chosenShop != null){
                    PrintProducts(chosenShop);
                } else{
                    System.out.println("Shop doesn't exist!");
                }

            }else if(command == 7){
                PrintShops(shops);
                System.out.println();
                System.out.print("Enter Shop Name: ");

                //CHOOSE SHOP
                Shop chosenShop = ChooseShop(shops);
                if(chosenShop != null){
                    PrintWorkers(chosenShop);
                } else{
                    System.out.println("Shop doesn't exist!");
                }
            }else if(command == 8){
                PrintShops(shops);
                System.out.println("Enter Shop Name: ");

                //CHOOSE SHOP
                Shop chosenShop = ChooseShop(shops);
                if(chosenShop != null){
                    PrintProducts(chosenShop);
                    Product chosenProduct = ChooseProduct(chosenShop);
                    if(chosenProduct != null){
                        System.out.println("Price: " + chosenShop.CalculateProductPrice(chosenProduct) + " lev");
                    }else {
                        System.out.println("Product doesn't exist!");
                    }
                } else{
                    System.out.println("Shop doesn't exist!");
                }

            }else if(command == 10){
                PrintShops(shops);
                System.out.println("Enter Shop Name: ");

                //CHOOSE SHOP
                Shop chosenShop = ChooseShop(shops);
                if(chosenShop != null){
                    MyThread t1 = new MyThread();
                    MyThread t2 = new MyThread();
                    t1.start();
                    t2.start();
                    while(t1.isAlive() && t2.isAlive()){
                        //Wait
                    }
                }else{
                    System.out.println("Shop doesn't exist!");
                }
            }else {
                System.out.println("Enter Valid Command");
            }
            System.out.println("Do you want to enter new command? y/n");
            commandAgain = reader.readLine();
        }
    }
    public static void PrintShops(List<Shop> shops){
        shops.forEach(value -> System.out.println(value+ "\n"));
    }
    public static void PrintProducts(Shop shop){
        List<Product> products = shop.GetProducts();
        if(products.size() == 0){
            System.out.println("Shop doesn't have any products!");
        }else{
            for (int i = 0; i < products.size(); i++) {
                System.out.println(products.get(i).toString());
            }
            System.out.println();
        }
    }
    public static void PrintWorkers(Shop shop){
        List<Worker> workers = shop.GetWorkers();
        if(workers.size() == 0){
            System.out.println("There are no workers in this shop!");
        }else {
            for (int i = 0; i < workers.size(); i++) {
                System.out.println(workers.get(i).toString());
            }
            System.out.println();
        }
    }
    public static Shop EnterShop() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Add new Shop");

        System.out.print("Enter Name For Shop: ");
        String name = reader.readLine();

        System.out.print("Enter Food Surplus For Shop: ");
        double foodSurplus = Double.parseDouble(reader.readLine());

        System.out.print("Enter NonFood Surplus For Shop: ");
        double nonfoodSurplus = Double.parseDouble(reader.readLine());

        System.out.print("Enter Days Until Discount For Products in Shop: ");
        int remainingDaysForDiscount = Integer.parseInt(reader.readLine());

        System.out.print("Enter Percent Discount For Products in Shop: ");
        double percentDiscount = Double.parseDouble(reader.readLine());

        Shop shop = new Shop(name, foodSurplus, nonfoodSurplus, remainingDaysForDiscount, percentDiscount);

        return shop;
    }
    public static Product EnterProduct() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("Add Product To Shop");

        System.out.print("Enter Name For Product: ");
        String name = reader.readLine();

        System.out.print("Enter Price For Product: ");
        double price = Double.parseDouble(reader.readLine());

        System.out.println("Enter Category For Product: food/nonfood");
        String category = reader.readLine();
        Category category1 = Category.NONFOOD;
        if(Objects.equals(category, "food")){
            category1 = Category.FOOD;
        }else{
            category1 = Category.NONFOOD;
        }
        System.out.println("Please Enter Expiration Date in Format: yyyy-mm-dd");
        String date = reader.readLine();

        System.out.print("Enter Stock For Product: ");
        int stock = Integer.parseInt(reader.readLine());
        Product product = new Product(productId++, name, price, category1, date, stock);
        return product;
    }
    public static Worker EnterWorker() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("Add Worker To Shop");

        System.out.print("Enter Name For Worker: ");
        String name = reader.readLine();

        System.out.print("Enter Salary For Worker: ");
        double salary = Double.parseDouble(reader.readLine());

        Worker worker = new Worker(workerId++, name, salary);

        return worker;
    }
    public static Shop ChooseShop(List<Shop> shops)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        for (int i = 0; i < shops.size(); i++) {
            if(Objects.equals(shops.get(i).getName(), name)){
                Shop chosenShop = shops.get(i);
                return chosenShop;
            }
        }
        return null;
    }
    public static Product ChooseProduct(Shop shop)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Product Name: ");
        String name = reader.readLine();
        for (int i = 0; i < shop.GetProducts().size(); i++) {
            if(Objects.equals(shop.GetProducts().get(i).GetName(), name)){
                Product product = shop.GetProducts().get(i);
                return product;
            }
        }
        return null;
    }
}



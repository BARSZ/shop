package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Main {
    private static int productId = 1;
    private static int workerId = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Shop> shops = new ArrayList<Shop>();

        //region Add Metro Shop
        Shop metro = new Shop("Metro", 10, 15, 3, 10);

        Product sapun = new Product(productId++,"Sapun", 5, Category.NONFOOD, "2022-01-30", 60);
        Product shampoo = new Product(productId++,"Shampoo", 6, Category.NONFOOD, "2022-09-30", 87);
        Product sladoled = new Product(productId++,"Sladoled", 12, Category.FOOD, "2022-09-30", 90);
        Product salam = new Product(productId++,"Salam", 15, Category.FOOD, "2022-09-30", 10);

        Worker pesho = new Worker(workerId++,"Pesho", 700);
        Worker gregorii = new Worker(workerId++,"Gregorii", 960);
        Worker panaiotis = new Worker(workerId++,"Panaiotis", 1200);
        Worker emanuil = new Worker(workerId++,"Emanuil", 1050);

        CashRegister cashRegisterM = new CashRegister('A', pesho);
        CashRegister cashRegisterM1 = new CashRegister('B', gregorii);
        CashRegister cashRegisterM2 = new CashRegister('C', panaiotis);
        CashRegister cashRegisterM3 = new CashRegister('D', emanuil);

        metro.AddProduct(sapun);
        metro.AddProduct(shampoo);
        metro.AddProduct(sladoled);
        metro.AddProduct(salam);
        metro.AddWorker(pesho);
        metro.AddWorker(gregorii);
        metro.AddWorker(panaiotis);
        metro.AddWorker(emanuil);
        metro.AddCashRegister(cashRegisterM);
        metro.AddCashRegister(cashRegisterM1);
        metro.AddCashRegister(cashRegisterM2);
        metro.AddCashRegister(cashRegisterM3);
        //endregion

        //region Add Fantastiko Shop
        Shop fantastiko = new Shop("Fantastiko", 12, 16, 4, 10);

        Product olio = new Product(productId++,"Olio", 12, Category.FOOD, "2022-09-30", 97);
        Product magdanoz = new Product(productId++,"Magdanoz", 1, Category.FOOD, "2022-09-30", 0);
        Product brokoli = new Product(productId++,"Brokoli", 2, Category.FOOD, "2022-09-30", 3);
        Product kroasan = new Product(productId++,"Kroasan", 5, Category.FOOD, "2022-09-30", 32);

        Worker vivaldi = new Worker(workerId++,"Vivaldi", 730);
        Worker frodo = new Worker(workerId++,"Frodo", 570);
        Worker sam = new Worker(workerId++,"Sam", 1500);
        Worker joro = new Worker(workerId++,"Joro", 570);

        CashRegister cashRegisterF = new CashRegister('E', vivaldi);
        CashRegister cashRegisterF1 = new CashRegister('F', frodo);
        CashRegister cashRegisterF2 = new CashRegister('G', sam);
        CashRegister cashRegisterF3 = new CashRegister('H', joro);

        fantastiko.AddProduct(olio);
        fantastiko.AddProduct(magdanoz);
        fantastiko.AddProduct(brokoli);
        fantastiko.AddProduct(kroasan);
        fantastiko.AddWorker(vivaldi);
        fantastiko.AddWorker(frodo);
        fantastiko.AddWorker(sam);
        fantastiko.AddWorker(joro);
        fantastiko.AddCashRegister(cashRegisterF);
        fantastiko.AddCashRegister(cashRegisterF1);
        fantastiko.AddCashRegister(cashRegisterF2);
        fantastiko.AddCashRegister(cashRegisterF3);
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
                //region Add Shop
                Shop shop = EnterShop();
                shops.add(shop);
                System.out.println("Shop added\n" + System.lineSeparator() + shop.toString() + System.lineSeparator());
                //endregion
            } else if (command == 2) {
                //region Add Product To Shop
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
                //endregion
            } else if (command == 3) {
                //region Add Worker To Shop
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
                //endregion
            }else if (command == 4){

            }else if (command == 5){
                PrintShops(shops);
            }else if (command == 6){
                //region Print Products
                PrintShops(shops);
                System.out.print("Enter Shop Name: ");

                //CHOOSE SHOP
                Shop chosenShop = ChooseShop(shops);
                if(chosenShop != null){
                    PrintProducts(chosenShop);
                } else{
                    System.out.println("Shop doesn't exist!");
                }
                //endregion
            }else if(command == 7){
                //region Print Workers
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
                //endregion
            }else if(command == 8){
                //region Calculate Price For Product
                PrintShops(shops);
                System.out.print("Enter Shop Name: ");

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
                //endregion
            }else if(command == 10){
                //region Threads Simulation
                PrintShops(shops);
                System.out.print("Enter Shop Name: ");

                //CHOOSE SHOP
                Shop chosenShop = ChooseShop(shops);
                if(chosenShop != null){
                    System.out.println("Do you want to enter clients? y/n ");
                    String enterClientCommand = reader.readLine();
                    if(Objects.equals(enterClientCommand, "y")){
                        List<Client> clients = new ArrayList<Client>();
                        String enterAnotherClientCommand = "n";
                        do{
                            Client client = EnterClient();
                            clients.add(client);
                            System.out.println("Do you want to enter another client? y/n ");
                            enterAnotherClientCommand = reader.readLine();
                        }while(Objects.equals(enterAnotherClientCommand, "y"));
                        do{
                            System.out.println("Choose For Which Client to Add Products:");
                            PrintClients(clients);
                            System.out.print("Client name: ");
                            Client chosenClient = ChooseClient(clients);
                            if(chosenClient != null){
                                String addAnotherProduct = "n";
                                do{
                                    System.out.println("Choose Product To Add");
                                    PrintProducts(chosenShop);
                                    Product productToAdd = ChooseProduct(chosenShop);
                                    if(productToAdd != null){
                                        chosenClient.AddProduct(productToAdd, chosenShop.CalculateProductPrice(productToAdd));
                                    }else{
                                        System.out.println("Invalid Product!");
                                    }
                                    System.out.println("Add another product for this client? y/n");
                                    addAnotherProduct = reader.readLine();
                                }while(Objects.equals(addAnotherProduct, "y"));

                            }else{
                                System.out.println("Invalid Client Chosen!");
                            }
                            System.out.println("Do you want to add products for another Client? y/n");
                            enterAnotherClientCommand = reader.readLine();
                        }while(Objects.equals(enterAnotherClientCommand, "y"));
                        for (int i = 0; i < clients.size(); i++) {
                            PrintFinalClientInfo(clients.get(i));
                        }
                    }else if(Objects.equals(enterClientCommand, "n")){
                        System.out.println("Creating sample clients data...");
                        System.out.println();
                        Client c1 = new Client("Velizar", 35);
                        Client c2 = new Client("Silvestur", 40);
                        Client c3 = new Client("Achelous", 39);
                        Client c4 = new Client("Theseus", 12);
                        List<Client> clients = new ArrayList<Client>();
                        Product p1 = chosenShop.GetProducts().get(GetRandomNumberForProduct(chosenShop.GetProducts()));
                        Product p2 = chosenShop.GetProducts().get(GetRandomNumberForProduct(chosenShop.GetProducts()));
                        Product p3 = chosenShop.GetProducts().get(GetRandomNumberForProduct(chosenShop.GetProducts()));
                        Product p4 = chosenShop.GetProducts().get(GetRandomNumberForProduct(chosenShop.GetProducts()));

                        c1.AddProduct(p1, chosenShop.CalculateProductPrice(p1));
                        c1.AddProduct(p2, chosenShop.CalculateProductPrice(p2));

                        c2.AddProduct(p3, chosenShop.CalculateProductPrice(p3));
                        c2.AddProduct(p4, chosenShop.CalculateProductPrice(p4));

                        c3.AddProduct(p1, chosenShop.CalculateProductPrice(p1));
                        c3.AddProduct(p4, chosenShop.CalculateProductPrice(p4));

                        c4.AddProduct(p2, chosenShop.CalculateProductPrice(p2));
                        c4.AddProduct(p3, chosenShop.CalculateProductPrice(p3));

                        Thread t1 = new Thread(new MyThread(chosenShop, c1));
                        Thread t2 = new Thread(new MyThread(chosenShop, c2));
                        Thread t3 = new Thread(new MyThread(chosenShop, c3));
                        Thread t4 = new Thread(new MyThread(chosenShop, c4));

                        t1.start();
                        t2.start();
                        t3.start();
                        t4.start();

                        while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive()){

                        }
                        clients.add(c1);
                        clients.add(c2);
                        clients.add(c3);
                        clients.add(c4);
                        List<Client> finishedClients = AssignCashRegisters(clients, chosenShop);
                        PrintFinalClientInfo(c1);
                        PrintFinalClientInfo(c2);
                        PrintFinalClientInfo(c3);
                        PrintFinalClientInfo(c4);

                        System.out.println("Do you want a receipt? y/n");
                        String getReceiptCommand = reader.readLine();
                        if(Objects.equals(getReceiptCommand, "y")){
                            PrintClients(clients);
                        }

                    }else{
                        System.out.println("Invalid command!");
                    }
                }else{
                    System.out.println("Shop doesn't exist!");
                }
                //endregion
            }else {
                //region Invalid Command
                System.out.println("Enter Valid Command");
                //endregion
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
                System.out.println("Shop price: " + shop.CalculateProductPrice(products.get(i)));
            }
            System.out.println();
        }
    }
    public static void PrintAddedProductsForClient(Client client){
        if(client.GetBasket().size() > 0){
            for (int i = 0; i < client.GetBasket().size() ; i++) {
                System.out.println(client.GetBasket().get(i).GetName());
            }
        }else{
            System.out.println("There are no added products for " + client.GetName());
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
    public static void PrintClients(List<Client> clients){
        clients.forEach(value -> System.out.println(value.toString() + "\n"));
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
    public static Client EnterClient() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("Enter Client");

        System.out.print("Enter Name For Client: ");
        String name = reader.readLine();

        System.out.print("Money: ");
        double money = Double.parseDouble(reader.readLine());

       Client client = new Client(name, money);

       return client;
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
    public static Client ChooseClient(List<Client> clients)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        for (int i = 0; i < clients.size(); i++) {
            if(Objects.equals(clients.get(i).GetName(), name)){
                Client chosenClient = clients.get(i);
                return chosenClient;
            }
        }
        return null;
    }
    public static List<Client> AssignCashRegisters(List<Client> clients, Shop chosenShop){
        if(chosenShop.GetCashRegisters().size() > 0){
            for (int i = 0; i < clients.size(); i++) {
                clients.get(i).AssignCashRegister(chosenShop.GetRandomCashRegister());
            }
        } else{
            return null;
        }
        return clients;
    }
    public static void PrintFinalClientInfo(Client client){
        System.out.println(client.GetName() + " is on cash register " + client.GetCashRegister().GetName() + " with worker " + client.GetCashRegister().GetCashier().GetName() +  " and his bill is " + client.GetCurrentBill() + " leva");
    }
    public static int GetRandomNumberForProduct(List<Product> products){
        Random random = new Random();
        return random.nextInt(products.size());
    }

}



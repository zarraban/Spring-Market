package org.example.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.app.entity.Product;
import org.example.app.utils.Cart;
import org.example.app.repository.product.ProductRepository;
import org.example.app.view.AppView;
import org.springframework.stereotype.Controller;

import java.util.Map;
import java.util.Scanner;


@Slf4j
@Controller("appController")
public class AppController {
    private final Scanner sc;

    ProductRepository repository;
    AppView view;
    Cart cart;

    public AppController(ProductRepository productRepository, AppView view, Cart cart, Scanner sc){
        this.sc = sc;
        this.repository = productRepository;
        this.view =view;
        this.cart = cart;
    }


    public void initRepo(){
        repository.create(new Product(1,"Apple",5));
        repository.create(new Product(2,"Banana",4));
        repository.create(new Product(3,"Cherry",2));
        repository.create(new Product(4,"Orange",8));
    }
    public void run(){
        int option = view.menu();

        switch (option){
            case 1 ->  printAllProducts();
            case 2-> {
                int optionCart = view.cartMenu();
                switch (optionCart){
                    case 1-> {
                        printAllProducts();
                        addToCart();
                    }
                    case 2-> {
                        System.out.println("Products in cart: \n");
                        if(cart.isEmpty()){
                            System.out.println("nothing");
                        }else {
                            System.out.println(cart);
                            deleteFromCart();
                        }

                    }
                    default -> {

                        log.error("User typed in wrong option");
                        System.out.println("There is no such option");
                    }
                }

            }
            case 3-> {
                if(cart.isEmpty()){
                    System.out.println("Products in cart: \n");
                    System.out.println("nothing");
                }else {
                    System.out.println("Products in cart: \n");
                    System.out.println(cart);
                }
            }

            case 4-> {
                int optionRepo = view.productRepoMenu();
                switch (optionRepo){
                    case 1-> createProduct();
                    case 2-> getByIdProduct();
                    case 3-> updateProduct();
                    case 4-> deleteProduct();
                    default -> {
                        log.error("User typed in wrong option");
                        System.out.println("There is no such option");
                    }

                }
            }
            case 0-> System.exit(0);
            default -> {

                log.error("User typed in wrong option");
                System.out.println("There is no such option");
            }
        }
        run();
    }

    private void addToCart(){
        System.out.println("Choose product to add(Product id):");
        long userOpt = sc.nextLong();
        cart.add(repository.getById(userOpt));
        run();
    }
    private void deleteFromCart(){
        System.out.println("Choose product to delete(Number of product in cart):");
        long userOpt = sc.nextLong();

        cart.delete(userOpt);
        run();
    }

    private void printAllProducts(){
        if(repository.getAll().isPresent()){
            Map<Long, Product> list = repository.getAll().get();
            list.forEach((k,v)-> System.out.println(k+")"+" "+v));
        }
    }

    private void createProduct(){
        System.out.println("Product properties:");
        System.out.println("Product id = ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.println("Product name = ");
        String name = sc.nextLine();
        System.out.println("Product cost = ");
        int cost = sc.nextInt();
        Product product = new Product(id, name, cost);
        repository.create(product);

    }
    private void getByIdProduct(){

        System.out.println("Enter product id:");
        Long id = sc.nextLong();
        sc.nextLine();
        System.out.println(repository.getById(id));


    }
    private void updateProduct(){
        System.out.println("Product properties:");
        System.out.println("Product id = ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.println("Product name = ");
        String name = sc.nextLine();
        System.out.println("Product cost = ");
        int cost = sc.nextInt();
        Product product = new Product(id, name, cost);
        repository.update(id, product);

    }
    private void deleteProduct(){

        System.out.println("Enter product id:");
        Long id = sc.nextLong();
        sc.nextLine();
        System.out.println(repository.delete(id));

    }
}

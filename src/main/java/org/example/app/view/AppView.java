package org.example.app.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("appView")
public class AppView {
    private static final Scanner sc = new Scanner(System.in);


    public int menu(){
        System.out.println("\n");
        System.out.println("Choose option");
        System.out.println("1) Show all products");
        System.out.println("2) Edit your cart");
        System.out.println("3) Show your cart");
        System.out.println("4) Edit products list (For manager)");
        System.out.println(("0) Exit app"));
        System.out.println("\n");

        return sc.nextInt();

    }

    public int cartMenu(){
        System.out.println("\n");
        System.out.println("1) Add product to your cart");
        System.out.println("2) Delete product from your cart");
        System.out.println("\n");
        return sc.nextInt();
    }

    public int productRepoMenu(){
        System.out.println("\n");
        System.out.println("1) Create product");
        System.out.println("2) Get by id product");
        System.out.println("3) Update product");
        System.out.println("4) Delete product");
        System.out.println("\n");
        return sc.nextInt();



    }
}

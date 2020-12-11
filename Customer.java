package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Customer extends Product {

    static ArrayList<product> shoppingBasket = new ArrayList<>();

    public static void displayProducts() {
        DataBase.getProducts();
    }

    public static void buyProduct() {
        for (int i = 0; i < shoppingBasket.size(); i++) {
            DataBase.DBdecrementQuantity(shoppingBasket.get(i).id, shoppingBasket.get(i).quantity);
        }
    }
}
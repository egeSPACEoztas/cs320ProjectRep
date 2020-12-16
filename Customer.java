import java.util.ArrayList;
import java.util.Scanner;


public class Customer {


    static ArrayList<Product> shoppingBasket = new ArrayList<Product>();

    public static void displayProducts() {
        Database.getProducts();
    }

    public static void buyProduct() {
        for (int i = 0; i < shoppingBasket.size(); i++) {
            Database.DBdecrementQuantity(shoppingBasket.get(i).id, shoppingBasket.get(i).quantity);
        }
    }
}
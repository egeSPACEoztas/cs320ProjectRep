public class Management {

    public static final int password = 1235;

    public static void addProduct(int productID, int quantity){
        Database.DBincrementQuantity(productID,quantity);
    }

    public static void removeProduct(int productID){
        Database.removeFromDB(productID);
    }

    public static void addNewProduct(int productID , int quantity, String brand, double price, String name){
        Database.DBaddProduct(productID, quantity, brand, price, name);
    }

    public static void updatePrice(int productID, double newPrice){
        Database.DBupdatePrice(productID,newPrice);
    }
}

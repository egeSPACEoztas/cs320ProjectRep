public class Management {


    public static void addProduct(int productID, int quantity){
        DataBase.DBincrementQuantity(productID,quantity);
    }

    public static void removeProduct(int productID){
        DataBase.removeFromDB(productID);
    }

    public static void addNewProduct(int productID , int quantity, String brand, double price, String name){
        DataBase.DBaddProduct(productID, quantity, brand, price, name);
    }

    public static void updatePrice(int productID, double newPrice){
        DataBase.DBupdatePrice(productID,newPrice);
    }
}

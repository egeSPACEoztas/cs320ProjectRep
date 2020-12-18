

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/cs320?useSSL=false&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "XaX404d@nk=";

    private static Connection connection = null;

    public static ArrayList<items> products = new ArrayList<items>();

    public static void establishConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //******************************************************************
    // LIST PRODUCST IN STOCKS
    public static void getProducts() {
        try {
            establishConnection();
            Statement statement = connection.createStatement();
            String cols = "";
            String selectQuery = "SELECT * FROM STOCKS NATURAL JOIN PRODUCT WHERE squantity > 0";
            ResultSet rs = statement.executeQuery(selectQuery);


            items items;
            while (rs.next()) {
                items = new items (rs.getInt("pid"), rs.getString("pname") , rs.getDouble("pprice") ,rs.getString("pbrand") , rs.getInt("squantity"));
                products.add(items);
            }

            rs.close();
            statement.close();
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //****************************************************
    // REMOVE PRODUCTS from STOCKS
    public static void removeFromDB(int pid) {
        try {
            establishConnection();
            Statement statement = connection.createStatement();

            String delete_stocks = "SELECT * FROM STOCKS WHERE pid=\"" + pid + "\"";
            ResultSet rs = statement.executeQuery(delete_stocks);

            if (rs.next()) {
                String deleteQuery = ("DELETE FROM STOCKS WHERE pid=\"" + pid + "\"");
                statement.executeUpdate(deleteQuery);
                System.out.println("Process completed!");
            } else {
                System.out.println("WARNING! In stocks, there is no product with the given product id.");
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //************************************************************
    // Decreasing Quantity
    public static void DBdecrementQuantity(int pid, int squantity) {
        try {
            establishConnection();
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM STOCKS WHERE pid=" + pid;
            ResultSet rs = statement.executeQuery(selectQuery);

            rs.next();
            if (rs.getInt("squantity") >= squantity) {
                String updateQuery = "UPDATE STOCKS SET squantity = squantity -" + squantity + " WHERE pid=" + pid ;
                statement.executeUpdate(updateQuery);
                System.out.println("\nProcess completed!");

            } else {
                System.out.println("There are no enough products in stock.");
            }

            rs.close();
            statement.close();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //*******************************************************
    // increase QUANTITY
    public static void DBincrementQuantity(int pid, double squantity) {
        try {
            establishConnection();
            Statement statement = connection.createStatement();

            String updateQuery = "UPDATE STOCKS SET squantity= squantity + \"" + squantity + "\" WHERE pid= \"" + pid
                    + "\"";
            statement.executeUpdate(updateQuery);
            System.out.println("\nProcess completed!");

            statement.close();
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //***************************************
    // NEW PRODUCT with QUANTITY
    public static void DBaddProduct(int pid, int squantity, String pbrand, double pprice, String pname) {
        try {
            establishConnection();
            Statement statement = connection.createStatement();

            String insertProduct = "INSERT INTO PRODUCT (pid, pbrand, pprice, pname) VALUES (\"" + pid + "\" ,\""
                    + pbrand + "\" ,\"" + pprice + "\", \"" + pname + "\")";
            statement.executeUpdate(insertProduct);

            String insertQuantity = "INSERT INTO STOCKS (pid, squantity) VALUES (\"" + pid + "\", \"" + squantity
                    + "\")";
            statement.executeUpdate(insertQuantity);

            System.out.println("\nProcess completed!");
            statement.close();
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // *******************************************************
    // UPDATE PRICE
    public static void DBupdatePrice(int pid, double pprice) {
        try {
            establishConnection();
            Statement statement = connection.createStatement();

            String updateQuery = "UPDATE PRODUCT SET pprice= \"" + pprice + "\" WHERE pid= \"" + pid + "\"";
            statement.executeUpdate(updateQuery);
            System.out.println("\nProcess completed!");

            statement.close();
            closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static double getPrice(int id){
        double price = 0.0;
        try {

            establishConnection();
            Statement statement = connection.createStatement();
            String selectQuery = "select pprice from product where pid=" +id;
            ResultSet rs = statement.executeQuery(selectQuery);

            if(rs.next()){
                price += rs.getDouble("pprice");
            }

            rs.close();
            statement.close();
            closeConnection();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }
}

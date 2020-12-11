
import java.sql.*;
import java.util.Scanner;

public class database {
	private static final String URL = "jdbc:mysql://localhost:3306/cs320?useSSL=false&useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "XaX404d@nk=";

	private static Connection connection = null;

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

			String selectQuery = "SELECT * FROM STOCKS NATURAL JOIN PRODUCT WHERE squantity > 0 \"";
			ResultSet rs = statement.executeQuery(selectQuery);

			while (rs.next()) {
				System.out.println("pid: " + rs.getString("pid") + " | Product's Name: " + rs.getString("pname")
						+ " | Product's Price: " + rs.getString("pprice") + " | Product's Brand: "
						+ rs.getString("pbrand") + " | Quantity: " + rs.getString("squantity"));
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

			String delete_stocks = "SELECT * FROM STOCKS";
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


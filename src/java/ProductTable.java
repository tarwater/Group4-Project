
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.sql.*;

public class ProductTable {
    
    static String url = "jdbc:mysql://localhost:3306/store";
    static String username = "root";
    static String password = "root";
    
    static Connection connection = null;
    static PreparedStatement selectProduct = null;
    static ResultSet resultset = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static List<Product> selectProducts() {
        return null;
    }

    public static Product selectProduct(String productCode) {
        return null;
    }

    public static boolean exists(String productCode) {
        return false;
    }

    private static void saveProducts(List<Product> products) {

    }

    public static void insertProduct(Product product) {
        
        String code = product.getCode();
        String description = product.getDescription();
        Double price = product.getPrice();

    }

    public static void updateProduct(Product product) {
    }

    public static void deleteProduct(Product product) {
    }

}

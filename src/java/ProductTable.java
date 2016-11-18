
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
    static PreparedStatement preparedStatement = null;
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

        String code;
        String description;
        Double price;

        ArrayList<Product> products = new ArrayList();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products");

            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                code = resultset.getString("code");
                description = resultset.getString("description");
                price = resultset.getDouble("price");

                Product p = new Product();
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);

                products.add(p);
            }

        } catch (Exception e) {

        }

        return products;
    }

    public static Product selectProduct(String productCode) {

        String code;
        String description;
        Double price;

        Product p = new Product();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE code = " + productCode);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                price = resultset.getDouble("price");
                code = resultset.getString("code");
                description = resultset.getString("description");

                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);
            }

        } catch (Exception e) {

        }

        return p;
    }

    public static boolean exists(String productCode) {

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE code = " + productCode);
            resultset = preparedStatement.executeQuery();

            return resultset.isBeforeFirst();

        } catch (Exception e) {
            return false;
        }

    }

    private static void saveProducts(List<Product> products) {

        for (Product p : products) {

            String code = p.getCode();
            String description = p.getDescription();
            Double price = p.getPrice();

            try {

                String query = "INSERT INTO products (code, description, price) "
                        + "VALUES (?, ?, ?)";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, code);
                preparedStatement.setString(2, description);
                preparedStatement.setDouble(3, price);

                preparedStatement.executeUpdate();

            } catch (Exception e) {

            }

        }

    }

    public static void insertProduct(Product product) {

        String code = product.getCode();
        String description = product.getDescription();
        Double price = product.getPrice();

        try {

            String query = "INSERT INTO products (code, description, price) "
                    + "VALUES (?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, price);

            preparedStatement.executeUpdate();

        } catch (Exception e) {

        }

    }

    public static void updateProduct(Product product) {

        String code = product.getCode();
        String description = product.getDescription();
        Double price = product.getPrice();

        try {

            String query = "UPDATE products SET "
                    + "code = ?, "
                    + "description = ?, "
                    + "price = ?"
                    + "WHERE code = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, code);

            preparedStatement.executeUpdate();

        } catch (Exception e) {

        }

    }

    public static void deleteProduct(Product product) {

        String code = product.getCode();

        try {
            String query = "DELETE FROM products WHERE code = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, code);

            preparedStatement.executeUpdate();
        } catch (Exception e) {

        }

    }

}

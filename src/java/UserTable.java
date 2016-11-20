
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class UserTable {

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

    public static void addRecord(User user) throws IOException {

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String userPassword = user.getPassword();

        try {

            String query = "INSERT INTO users (firstName, lastName, email, password) "
                    + "VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, userPassword);
            preparedStatement.executeUpdate();

        } catch (Exception e) {

        }

    }

    public static User getUser(String emailAddress) throws IOException {

        String firstName;
        String lastName;
        String userPassword;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = " + emailAddress);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                firstName = resultset.getString("firstName");
                lastName = resultset.getString("lastName");
                userPassword = resultset.getString("password");

                User u = new User(firstName, lastName, emailAddress, userPassword);
                
                return u;

            }

        } catch (Exception e) {

        }

        return null;

    }

    public static ArrayList<User> getUsers() throws IOException {
        
        String firstName;
        String lastName;
        String userPassword;
        String email;
        
        ArrayList<User> users = new ArrayList<User>();
        
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users");

            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                firstName = resultset.getString("firstName");
                lastName = resultset.getString("lastName");
                email = resultset.getString("email");
                userPassword = resultset.getString("password");
                
                User u = new User(firstName,lastName, email, userPassword);

                users.add(u);
            }
            
            return users;

        } catch (Exception e) {

        }
        return null;
        
    }

    public static HashMap<String, User> getUsersMap() throws IOException {
        
        HashMap<String, User> userMap = new HashMap<String, User>();
        
        String firstName;
        String lastName;
        String userPassword;
        String email;
        
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users");

            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                firstName = resultset.getString("firstName");
                lastName = resultset.getString("lastName");
                email = resultset.getString("email");
                userPassword = resultset.getString("password");
                
                User u = new User(firstName,lastName, email, userPassword);

                userMap.put(email, u);
            }
            
            return userMap;

        } catch (Exception e) {

        }
        return null;
        
        
        
        
    }
}

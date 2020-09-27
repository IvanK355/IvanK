import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            try {
                Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}


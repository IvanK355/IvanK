import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String SQL = "INSERT INTO STUDENTS (id, name, surname, age) VALUES (random_uuid(), 'Viktor', 'Medvedev', 18)";
    private static final String SQL2 = "SELECT * FROM STUDENTS";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            try {
                connection =
                        DriverManager.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM './HomeTask8/schema.sql'\\;RUNSCRIPT FROM './HomeTask8/data.sql'");
                statement = connection.createStatement();
                System.out.println(statement.execute(SQL2));
            } finally {
                statement.close();
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}


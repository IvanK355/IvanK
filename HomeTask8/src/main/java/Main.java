import java.sql.*;

public class Main {

    private static final String SELECT = "SELECT * FROM STUDENTS";

    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM './HomeTask8/schema.sql'\\;RUNSCRIPT FROM './HomeTask8/data.sql'");
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
        }
    }
}


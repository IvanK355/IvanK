import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.ArrayList;

public class AccountService {

    public void withdraw(int accountId, int amount) {

    }

    public void balance(String accountId) throws UnknownAccountException, IOException {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT");
                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String id = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String amount = resultSet.getString(3);
                    System.out.println(id+" "+name+" "+amount);
                }

            } finally {
                preparedStatement.close();
                connection.close();
            }
        } catch
        (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

        public void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {

    }


    public void transfer(int from, int to, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {


    }


    public void create(int parseInt, String s) throws IOException, UnknownAccountException {


    }

    public void createNew() throws IOException {
        String sql = "SELECT * FROM ACCOUNT";
        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM './HomeTask8/schema.sql'\\;RUNSCRIPT FROM './HomeTask8/data.sql'");
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





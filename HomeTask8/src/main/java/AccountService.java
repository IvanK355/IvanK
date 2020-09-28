import java.io.*;
import java.sql.*;

public class AccountService {

    void withdraw(String accountId, String amount) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT");

                preparedStatement = connection.prepareStatement("SELECT * FROM account");
                ResultSet resultSet = preparedStatement.executeQuery();
                int count = 0;

                while (resultSet.next()) {

                    if (resultSet.getInt(1) == Integer.parseInt(accountId)) {
                        count++;

                    }
                }

                if (count == 0) {
                    throw new UnknownAccountException("Счет неверный");
                }
                preparedStatement = null;
                int amount1 = 0;


                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    amount1 = resultSet.getInt(3);
                    System.out.println("Номер счета: " + id);
                    System.out.println("Владелец счета: " + name);
                    System.out.println("Сумма до снятия денежных средств: " + amount1);

                }
                System.out.println("Сняли: " + amount);

                amount1 -= Integer.parseInt(amount);

                if (amount1 < 0) {
                    throw new NotEnoughMoneyException("Недостаточно средств");
                }

                String sql = "update account set amount = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, amount1);
                preparedStatement.setInt(2, Integer.parseInt(accountId));
                int rows = preparedStatement.executeUpdate();

                preparedStatement = null;
                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    amount1 = resultSet.getInt(3);
                    System.out.println("Номер счета: " + id);
                    System.out.println("Владелец счета: " + name);
                    System.out.println("Сумма после снятия денежных средств: " + amount1);
                }


            } catch (SQLException | UnknownAccountException |
                    NotEnoughMoneyException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            preparedStatement.close();
            connection.close();
        }

    }

    public void balance(String accountId) throws UnknownAccountException, SQLException {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT");

                preparedStatement = connection.prepareStatement("SELECT * FROM account");
                ResultSet resultSet = preparedStatement.executeQuery();
                int count = 0;

                while (resultSet.next()) {

                    if (resultSet.getInt(1) == Integer.parseInt(accountId)) {
                        count++;

                    }
                }

                if (count == 0) {
                    throw new UnknownAccountException("Счет неверный");
                }
                preparedStatement = null;

                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String amount = resultSet.getString(3);
                    System.out.println(id + " " + name + " " + amount);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            preparedStatement.close();
            connection.close();
        }

    }


    public void deposit(String accountId, String amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException, SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT");

                preparedStatement = connection.prepareStatement("SELECT * FROM account");
                ResultSet resultSet = preparedStatement.executeQuery();
                int count = 0;

                while (resultSet.next()) {

                    if (resultSet.getInt(1) == Integer.parseInt(accountId)) {
                        count++;

                    }
                }

                if (count == 0) {
                    throw new UnknownAccountException("Счет неверный");
                }
                preparedStatement = null;
                int amount1 = 0;

                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    amount1 = resultSet.getInt(3);
                    System.out.println(id + " " + name + " " + amount1);
                }
                amount1 += Integer.parseInt(amount);

                String sql = "update account set amount = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, amount1);
                preparedStatement.setInt(2, Integer.parseInt(accountId));
                int rows = preparedStatement.executeUpdate();

                preparedStatement = null;
                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    amount1 = resultSet.getInt(3);
                    System.out.println(id + " " + name + " " + amount1);
                }


            } catch (SQLException | UnknownAccountException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            preparedStatement.close();
            connection.close();
        }

    }


    public void transfer(String from, String to, String amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException, SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT");

                preparedStatement = connection.prepareStatement("SELECT * FROM account");
                ResultSet resultSet = preparedStatement.executeQuery();
                int count = 0;

                while (resultSet.next()) {

                    if (resultSet.getInt(1) == Integer.parseInt(from)) {
                        count++;
                    }
                    if (resultSet.getInt(1) == Integer.parseInt(to)) {
                        count++;
                    }
                }

                if (count == 0) {
                    throw new UnknownAccountException("Счет неверный");
                }
                preparedStatement = null;
                int amount1 = 0;
                int amount2 = 0;

                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(from));

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    amount1 = resultSet.getInt(3);
                    System.out.println(id + " " + name + " " + amount1);
                }
                amount1 -= Integer.parseInt(amount);


                preparedStatement = null;

                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");

                preparedStatement.setInt(1, Integer.parseInt(to));
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    amount2 = resultSet.getInt(3);
                    System.out.println(id + " " + name + " " + amount1);
                }

                amount2 += Integer.parseInt(amount);

                String sql = "update account set amount = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, amount1);
                preparedStatement.setInt(2, Integer.parseInt(from));
                int rows = preparedStatement.executeUpdate();

                String sql1 = "update account set amount = ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql1);
                preparedStatement.setInt(1, amount2);
                preparedStatement.setInt(2, Integer.parseInt(to));
                int rows1 = preparedStatement.executeUpdate();

                preparedStatement = null;
                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id in (?,?)");
                preparedStatement.setInt(1, Integer.parseInt(from));
                preparedStatement.setInt(2, Integer.parseInt(to));
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    amount1 = resultSet.getInt(3);
                    System.out.println(id + " " + name + " " + amount1);
                }


            } catch (SQLException | UnknownAccountException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            preparedStatement.close();
            connection.close();
        }


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

    void sqlSelect() {

    }

}





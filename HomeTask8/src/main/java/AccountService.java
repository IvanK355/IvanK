import java.io.*;
import java.sql.*;

public class AccountService {

    void withdraw(String accountId, String amount2) throws SQLException, UnknownAccountException {
        sqlSelect(accountId);
        updateWithdraw(accountId, amount2);
        sqlSelect(accountId);

    }

    void balance(String accountId) throws SQLException, UnknownAccountException {
        sqlSelect(accountId);
    }

    void deposit(String accountId, String amount2) throws SQLException, UnknownAccountException {
        sqlSelect(accountId);
        updateDeposit(accountId, amount2);
        sqlSelect(accountId);
    }

    public void transfer(String from, String to, String amount) throws SQLException, UnknownAccountException {

        balance(from);
        balance(to);
        updateWithdraw(from, amount);
        updateDeposit(to, amount);
        balance(from);
        balance(to);

    }

    void createNew() {
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

    void sqlSelect(String accountId) throws SQLException, UnknownAccountException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            try {

                connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT");
                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                ResultSet resultSet = preparedStatement.executeQuery();
                int id;
                String name;
                int amount;
                if (!resultSet.next()) {
                    throw new UnknownAccountException("Счет неверный");
                }
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    id = resultSet.getInt(1);
                    name = resultSet.getString(2);
                    amount = resultSet.getInt(3);
                    System.out.println(id + " " + name + " " + amount);
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }


    void updateWithdraw(String accountId, String amount2) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            try {

                System.out.println("Сняли: " + amount2);

                connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT");
                String sql = "update account set amount = amount - ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Integer.parseInt(amount2));
                preparedStatement.setInt(2, Integer.parseInt(accountId));
                int rows = preparedStatement.executeUpdate();

                preparedStatement = null;

                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    throw new UnknownAccountException("Счет неверный");
                }

            } catch (SQLException | UnknownAccountException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    void updateDeposit(String accountId, String amount2) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            try {

                System.out.println("Положили: " + amount2);

                connection = DriverManager
                        .getConnection("jdbc:h2:mem:ACCOUNT");
                String sql = "update account set amount = amount +  ? WHERE id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Integer.parseInt(amount2));
                preparedStatement.setInt(2, Integer.parseInt(accountId));
                int rows = preparedStatement.executeUpdate();

                preparedStatement = null;

                preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id = ?");
                preparedStatement.setInt(1, Integer.parseInt(accountId));
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    throw new UnknownAccountException("Счет неверный");
                }

            } catch (SQLException | UnknownAccountException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }
}





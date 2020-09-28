import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.sql.*;

public class BankFacade {

    private ArrayList<Account> accounts;
    private AccountService accountService;


    public BankFacade() {
        this.accounts = new ArrayList<>();
        this.accountService = new AccountService();
    }

    public void info() throws IOException, UnknownNameOperationException, UnknownAccountException, NotEnoughMoneyException {


        accountService.createNew();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        String[] array = s.split("\\W");

        switch (array[0]) {
            case "balance" -> accountService.balance(array[1]);
            case "withdraw" -> accountService.withdraw(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
            case "deposit" -> accountService.deposit(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
            case "transfer" -> accountService.transfer(Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]));
            case "create" -> accountService.create(Integer.parseInt(array[1]), array[2]);

            default -> throw new UnknownNameOperationException("Неизвестная операция " + array[0]);
        }
    }
}
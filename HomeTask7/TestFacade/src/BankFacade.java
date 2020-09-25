import java.io.*;
import java.util.ArrayList;

public class BankFacade {

    public ArrayList<Account> accounts;
    private AccountService accountService;


    public BankFacade() {
        this.accounts = new ArrayList<>();
        this.accountService = new AccountService();

    }

    public void info() throws IOException, UnknownAccountException, NotEnoughMoneyException, UnknownNameOperationException {


        accountService.createNew();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        String[] array = s.split("\\W");

        switch (array[0]) {
            case "balance" -> accountService.balance(Integer.parseInt(array[1]));
            case "withdraw" -> accountService.withdraw(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
            case "deposit" -> accountService.deposit(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
            case "transfer" -> accountService.transfer(Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]));
            case "create" -> accountService.create(Integer.parseInt(array[1]), array[2]);

            default -> throw new UnknownNameOperationException("Неизвестная операция " + array[0]);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, UnknownAccountException, NotEnoughMoneyException, UnknownNameOperationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int accountId, to, from, amount;
        String s = reader.readLine();
        String[] array = s.split("\\W");

        for (String x : array) {
            System.out.println(x);

        }
        switch (array[0]) {
            case ("balance") -> {
                accountId = Integer.parseInt(array[1]);
                AccountService.balance(accountId);}
            case ("withdraw") -> {
                accountId = Integer.parseInt(array[1]);
                amount = Integer.parseInt(array[2]);
                AccountService.withdraw(accountId, amount);}
            case ("deposite") -> {
                accountId = Integer.parseInt(array[1]);
                amount = Integer.parseInt(array[2]);
                AccountService.deposit(accountId, amount);}
            case ("transfer") -> {
                from = Integer.parseInt(array[1]);
                to = Integer.parseInt(array[2]);
                amount = Integer.parseInt(array[3]);
                AccountService.transfer(from, to, amount);}
            default -> throw new UnknownNameOperationException("Неизвестная операция " + array[0]);
        }
    }


}

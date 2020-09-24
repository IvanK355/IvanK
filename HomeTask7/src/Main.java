import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, UnknownNameOperationException, UnknownAccountException, NotEnoughMoneyException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int accountId, to, from, amount;
        int qtyAccounts = 10;

        Account[] accounts = new Account[qtyAccounts + 1];

        for (int i = 1; i < (qtyAccounts + 1); i++) {

            accounts[i] = new Account(i, ("Holder" + i));

            String path = "HomeTask7\\" + i + ".txt";
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();

                FileWriter fw = new FileWriter("HomeTask7\\" + i + ".txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(String.valueOf(0));
                bw.close();
            }
        }

        String s = reader.readLine();
        String[] array = s.split("\\W");

        switch (array[0]) {
            case ("balance") -> {
                accountId = Integer.parseInt(array[1]);
                System.out.println("Счет " + accounts[accountId].getId());
                System.out.println("Владелец счета " + accounts[accountId].getHolder());
                System.out.print("Баланс счета ");
                AccountService.balance(accountId);
            }
            case ("withdraw") -> {
                accountId = Integer.parseInt(array[1]);
                amount = Integer.parseInt(array[2]);
                System.out.println("Счет " + accounts[accountId].getId());
                System.out.println("Владелец счета " + accounts[accountId].getHolder());
                AccountService.withdraw(accountId, amount);
            }
            case ("deposit") -> {
                accountId = Integer.parseInt(array[1]);
                amount = Integer.parseInt(array[2]);
                System.out.println("Счет " + accounts[accountId].getId());
                System.out.println("Владелец счета " + accounts[accountId].getHolder());
                AccountService.deposit(accountId, amount);
            }
            case ("transfer") -> {
                from = Integer.parseInt(array[1]);
                to = Integer.parseInt(array[2]);
                amount = Integer.parseInt(array[3]);
                System.out.println("Перевод со счета: " + accounts[from].getId());
                System.out.println("Отправитель " + accounts[from].getHolder());
                System.out.println("Перевод на счет " + accounts[to].getId());
                System.out.println("Получатель " + accounts[to].getHolder());
                AccountService.transfer(from, to, amount);
            }
            default -> throw new UnknownNameOperationException("Неизвестная операция " + array[0]);
        }


    }
}

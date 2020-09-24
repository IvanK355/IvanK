import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, UnknownNameOperationException, UnknownAccountException, NotEnoughMoneyException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int accountId, to, from, amount;
        int qtyAccounts = 11;

        Account[] accounts = new Account[qtyAccounts + 1];

        for (int i = 1; i < (qtyAccounts + 1); i++) {

            accounts[i] = new Account(i, ("Holder_" + i));

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
                System.out.println("Счет: " + accounts[accountId].getId());
                System.out.println("Владелец счета: " + accounts[accountId].getHolder());
                System.out.print("Баланс счета: ");
                System.out.println(accounts[accountId].getAmount());
            }
            case ("withdraw") -> {
                accountId = Integer.parseInt(array[1]);
                amount = Integer.parseInt(array[2]);
                System.out.println("Счет: " + accounts[accountId].getId());
                System.out.println("Владелец счета: " + accounts[accountId].getHolder());
                System.out.print("Баланс счета до снятия наличных: ");
                System.out.println(accounts[accountId].getAmount());
                System.out.println("Сумма снятия: " + amount);
                AccountService.withdraw(accountId, amount);
                System.out.print("Баланс счета после снятия наличных: ");
                System.out.println(accounts[accountId].getAmount());
            }
            case ("deposit") -> {
                accountId = Integer.parseInt(array[1]);
                amount = Integer.parseInt(array[2]);
                System.out.println("Счет: " + accounts[accountId].getId());
                System.out.println("Владелец счета: " + accounts[accountId].getHolder());
                System.out.print("Баланс счета до внесения наличных: ");
                System.out.println(accounts[accountId].getAmount());
                System.out.println("Сумма депозита: " + amount);
                AccountService.deposit(accountId, amount);
                System.out.print("Баланс счета после внесенмя наличных: ");
                System.out.println(accounts[accountId].getAmount());
            }
            case ("transfer") -> {
                from = Integer.parseInt(array[1]);
                to = Integer.parseInt(array[2]);
                amount = Integer.parseInt(array[3]);
                System.out.print("Баланс счета Отправителя " + accounts[from].getHolder() + " до перевода: ");
                System.out.println(accounts[from].getAmount());
                System.out.print("Баланс счета Получателя " + accounts[to].getHolder() + " до перевода: ");
                System.out.println(accounts[to].getAmount());
                System.out.println("Сумма перевода: " + amount);
                AccountService.transfer(from, to, amount);
                System.out.print("Баланс счета Отправителя " + accounts[from].getHolder() + " после перевода: ");
                System.out.println(accounts[from].getAmount());
                System.out.print("Баланс счета Получателя " + accounts[to].getHolder() + " после перевода: ");
                System.out.println(accounts[to].getAmount());
            }
            default -> throw new UnknownNameOperationException("Неизвестная операция " + array[0]);
        }


    }
}

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class AccountService {

    private static String current;
    private static String last;
    private static int newAmount;

    public AccountService() throws FileNotFoundException {
    }


    static void withdraw(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {

        ArrayList<Account> accountsWithdraw = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsWithdraw.add(new Account(Integer.parseInt(s1), br.readLine()));
        }

        int count = 0;
        int id = 0;
        for (int i = 0; i < accountsWithdraw.size(); i++) {
            if (accountsWithdraw.get(i).getId() == accountId) {
                count++;
                id = i;
            }
        }

        if (count == 0) {
            throw new UnknownAccountException("Счет неверный");
        }

        String p = "HomeTask7\\" + accountsWithdraw.get(id).getId() + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }

        newAmount = Integer.parseInt(last) - amount;
        if (newAmount < 0) {
            throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
        }
        System.out.println("Счет: " + accountsWithdraw.get(id).getId());
        System.out.println("Владелец счета: " + accountsWithdraw.get(id).getHolder());
        System.out.print("Баланс счета до снятия: ");
        System.out.println(last);
        System.out.println("Сняли: " + amount);


        BufferedWriter writer = Files.newBufferedWriter(Path.of(p), StandardOpenOption.APPEND);
        writer.write("\n" + newAmount);
        writer.close();
        System.out.print("Баланс счета после снятия: ");
        System.out.println(newAmount);

    }

    static void balance(int accountId) throws UnknownAccountException, IOException {

        ArrayList<Account> accountsBalance = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsBalance.add(new Account(Integer.parseInt(s1), br.readLine()));
        }
        int count = 0;
        int id = 0;
        for (int i = 0; i < accountsBalance.size(); i++) {
            if (accountsBalance.get(i).getId() == accountId) {
                count++;
                id = i;
            }
        }

        if (count == 0) {
            throw new UnknownAccountException("Счет неверный");
        }

        String p = "HomeTask7\\" + accountsBalance.get(id).getId() + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        System.out.println("Счет: " + accountsBalance.get(id).getId());
        System.out.println("Владелец счета: " + accountsBalance.get(id).getHolder());
        System.out.print("Баланс счета: ");
        System.out.println(last);
    }


    static void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {
        ArrayList<Account> accountsDeposit = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsDeposit.add(new Account(Integer.parseInt(s1), br.readLine()));
        }

        int count = 0;
        int id = 0;
        for (int i = 0; i < accountsDeposit.size(); i++) {
            if (accountsDeposit.get(i).getId() == accountId) {
                count++;
                id = i;
            }
        }

        if (count == 0) {
            throw new UnknownAccountException("Счет неверный");
        }

        String p = "HomeTask7\\" + accountsDeposit.get(id).getId() + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }

        newAmount = Integer.parseInt(last) + amount;
        if (newAmount < 0) {
            throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
        }
        System.out.println("Счет: " + accountsDeposit.get(id).getId());
        System.out.println("Владелец счета: " + accountsDeposit.get(id).getHolder());
        System.out.print("Баланс счета до пополнения: ");
        System.out.println(last);
        System.out.println("Внесли: " + amount);


        BufferedWriter writer = Files.newBufferedWriter(Path.of(p), StandardOpenOption.APPEND);
        writer.write("\n" + newAmount);
        writer.close();
        System.out.print("Баланс счета после пополнения: ");
        System.out.println(newAmount);

    }


    static void transfer(int from, int to, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {

        ArrayList<Account> accountsTransfer = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsTransfer.add(new Account(Integer.parseInt(s1), br.readLine()));
        }
        int newAmountTo = 0;
        int newAmountFrom = 0;
        String fromAccount = "HomeTask7\\" + from + ".txt";
        String toAccount = "HomeTask7\\" + to + ".txt";
        String currentFrom;
        String lastFrom = null;

        int countFrom = 0;
        int idFrom = 0;
        for (int i = 0; i < accountsTransfer.size(); i++) {
            if (accountsTransfer.get(i).getId() == from) {
                countFrom++;
                idFrom = i;
            }
        }

        int countTo = 0;
        int idTo = 0;
        for (int i = 0; i < accountsTransfer.size(); i++) {
            if (accountsTransfer.get(i).getId() == to) {
                countTo++;
                idTo = i;
            }
        }

        if (countFrom == 0) {
            throw new UnknownAccountException("Счет Отправителя неверный");
        } else if (countTo == 0) {
            throw new UnknownAccountException("Счет Получателя неверный");
        }


        BufferedReader bufferedReaderFrom = new BufferedReader(new FileReader(fromAccount));

        while ((currentFrom = bufferedReaderFrom.readLine()) != null) {
            lastFrom = currentFrom;
        }

        newAmountFrom = Integer.parseInt(lastFrom) - amount;
        if (newAmount < 0) {
            throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
        }

        BufferedWriter writer = Files.newBufferedWriter(Path.of(fromAccount), StandardOpenOption.APPEND);
        writer.write("\n" + newAmountFrom);
        writer.close();


        BufferedReader bufferedReaderTo = new BufferedReader(new FileReader(toAccount));
        while ((current = bufferedReaderTo.readLine()) != null) {
            last = current;
        }

        newAmountTo = Integer.parseInt(last) + amount;

        BufferedWriter writerTo = Files.newBufferedWriter(Path.of(toAccount), StandardOpenOption.APPEND);
        writerTo.write("\n" + newAmountTo);
        writerTo.close();

    }
}




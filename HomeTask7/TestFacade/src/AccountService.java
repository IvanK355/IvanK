import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class AccountService {

    private static String current;
    private static String last;
    private static int newAmount;


    static void withdraw(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {

        ArrayList<Account> accountsWithdraw = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsWithdraw.add(new Account(Integer.parseInt(s1), br.readLine()));
        }

        for (int i = 0; i < accountsWithdraw.size(); i++) {
            if (accountsWithdraw.get(i).getId() == accountId) {

                String p = "HomeTask7\\" + accountsWithdraw.get(i).getId() + ".txt";

                BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
                while ((current = bufferedReader.readLine()) != null) {
                    last = current;
                }

                newAmount = Integer.parseInt(last) - amount;
                if (newAmount < 0) {
                    throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
                }
                System.out.println("Счет: " + accountsWithdraw.get(i).getId());
                System.out.println("Владелец счета: " + accountsWithdraw.get(i).getHolder());
                System.out.print("Баланс счета до снятия: ");
                System.out.println(last);
                System.out.println("Сняли: " + amount);


                BufferedWriter writer = Files.newBufferedWriter(Path.of(p), StandardOpenOption.APPEND);
                writer.write("\n" + newAmount);
                writer.close();
                System.out.print("Баланс счета после снятия: ");
                System.out.println(last);
                break;
            } else {
                throw new UnknownAccountException("Счет неверный");
            }
        }
    }

    static void balance(int accountId) throws UnknownAccountException, IOException {

        ArrayList<Account> accountsBalance = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsBalance.add(new Account(Integer.parseInt(s1), br.readLine()));
        }

        for (int i = 0; i < accountsBalance.size(); i++) {
            if (accountsBalance.get(i).getId() == accountId) {

                String p = "HomeTask7\\" + accountsBalance.get(i).getId() + ".txt";

                BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
                while ((current = bufferedReader.readLine()) != null) {
                    last = current;
                }
                System.out.println("Счет: " + accountsBalance.get(i).getId());
                System.out.println("Владелец счета: " + accountsBalance.get(i).getHolder());
                System.out.print("Баланс счета: ");
                System.out.println(last);
                break;
            } else {
                throw new UnknownAccountException("Счет неверный");
            }
        }
    }

    static void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {
        String p = "HomeTask7\\" + accountId + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        newAmount = Integer.parseInt(last) + amount;
        BufferedWriter writer = Files.newBufferedWriter(Path.of(p), StandardOpenOption.APPEND);
        writer.write("\n" + newAmount);
        writer.close();
    }

    static void transfer(int from, int to, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {
        int newAmountTo = 0;
        int newAmountFrom = 0;

        String fromAccount = "HomeTask7\\" + from + ".txt";
        String toAccount = "HomeTask7\\" + to + ".txt";
        String currentFrom;
        String lastFrom = null;

        BufferedReader bufferedReaderFrom = new BufferedReader(new FileReader(fromAccount));

        while ((currentFrom = bufferedReaderFrom.readLine()) != null) {
            lastFrom = currentFrom;
        }
        newAmountFrom = Integer.parseInt(lastFrom) - amount;

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

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
        ArrayList<Account> accountsDeposit = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsDeposit.add(new Account(Integer.parseInt(s1), br.readLine()));
        }

        for (int i = 0; i < accountsDeposit.size(); i++) {
            if (accountsDeposit.get(i).getId() == accountId) {

                String p = "HomeTask7\\" + accountsDeposit.get(i).getId() + ".txt";

                BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
                while ((current = bufferedReader.readLine()) != null) {
                    last = current;
                }

                newAmount = Integer.parseInt(last) + amount;
                if (newAmount < 0) {
                    throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
                }
                System.out.println("Счет: " + accountsDeposit.get(i).getId());
                System.out.println("Владелец счета: " + accountsDeposit.get(i).getHolder());
                System.out.print("Баланс счета до пополнения: ");
                System.out.println(last);
                System.out.println("Внесли: " + amount);


                BufferedWriter writer = Files.newBufferedWriter(Path.of(p), StandardOpenOption.APPEND);
                writer.write("\n" + newAmount);
                writer.close();
                System.out.print("Баланс счета после пополнения: ");
                System.out.println(newAmount);
                break;
            } else {
                throw new UnknownAccountException("Счет неверный");
            }
        }
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

        for (int i = 0; i < accountsTransfer.size(); i++) {
            if (accountsTransfer.get(i).getId() == from) {
                for (int j = 0; j < accountsTransfer.size(); j++) {
                    if (accountsTransfer.get(j).getId() == to) {

                        String p = "HomeTask7\\" + accountsTransfer.get(i).getId() + ".txt";

                        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
                        while ((current = bufferedReader.readLine()) != null) {
                            last = current;
                        }

                        newAmount = Integer.parseInt(last) + amount;
                        if (newAmount < 0) {
                            throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
                        }
                        System.out.println("Счет: " + accountsTransfer.get(i).getId());
                        System.out.println("Владелец счета: " + accountsTransfer.get(i).getHolder());
                        System.out.print("Баланс счета до пополнения: ");
                        System.out.println(last);
                        System.out.println("Внесли: " + amount);


                        BufferedWriter writer = Files.newBufferedWriter(Path.of(p), StandardOpenOption.APPEND);
                        writer.write("\n" + newAmount);
                        writer.close();
                        System.out.print("Баланс счета после пополнения: ");
                        System.out.println(newAmount);
                        break;
                    }
                }
            } else {
                throw new UnknownAccountException("Счет неверный");
            }

        }
    }
}

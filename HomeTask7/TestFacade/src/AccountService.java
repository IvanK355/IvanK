import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class AccountService {

    private static String last;
    private static int newAmount;
    private static final String pathData = "HomeTask7\\data.txt";

    private ArrayList<Account> readAccountData() throws IOException {
        ArrayList<Account> accounts = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(pathData));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accounts.add(new Account(Integer.parseInt(s1), br.readLine(), br.readLine()));
        }
        return accounts;
    }

    public void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, IOException {

        getBalance(accountId);

        String parhWithdraw = "HomeTask7\\" + accountId + ".txt";
        newAmount = Integer.parseInt(last) - amount;
        if (newAmount < 0) {
            throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
        }

        System.out.println("Сняли: " + amount);

        BufferedWriter writer = Files.newBufferedWriter(Path.of(parhWithdraw), StandardOpenOption.APPEND);
        writer.write("\n" + newAmount);
        writer.close();
        System.out.print("Баланс счета после снятия: ");
        System.out.println(newAmount);

    }

    void balance(int accountId) throws UnknownAccountException, IOException {

        getBalance(accountId);

    }


    void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {
        getBalance(accountId);

        String parhDeposit = "HomeTask7\\" + accountId + ".txt";

        newAmount = Integer.parseInt(last) + amount;
        if (newAmount < 0) {
            throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
        }

        System.out.println("Внесли: " + amount);


        BufferedWriter writer = Files.newBufferedWriter(Path.of(parhDeposit), StandardOpenOption.APPEND);
        writer.write("\n" + newAmount);
        writer.close();
        System.out.print("Баланс счета после пополнения: ");
        System.out.println(newAmount);

    }


    void transfer(int from, int to, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {

        int newAmountTo;
        int newAmountFrom;
        String currentFrom;
        String lastFrom;
        String currentTo;
        String lastTo;

        getBalance(from);
        lastFrom = last;
        getBalance(to);
        lastTo = last;

        String pathFrom = "HomeTask7\\" + from + ".txt";

        BufferedReader bufferedReaderFrom = new BufferedReader(new FileReader(pathFrom));
        while ((currentFrom = bufferedReaderFrom.readLine()) != null) {
            lastFrom = currentFrom;
        }

        newAmountFrom = Integer.parseInt(lastFrom) - amount;
        if (newAmountFrom < 0) {
            throw new NotEnoughMoneyException("Недостаточно стредств на счете: " + from);
        }

        System.out.println("Перевели: " + amount);


        BufferedWriter writer = Files.newBufferedWriter(Path.of(pathFrom), StandardOpenOption.APPEND);
        writer.write("\n" + newAmountFrom);
        writer.close();
        System.out.print("Баланс счета " + from + " после перевода: ");
        System.out.println(newAmountFrom);

        String pathTo = "HomeTask7\\" + to + ".txt";

        BufferedReader bufferedReaderTo = new BufferedReader(new FileReader(pathTo));

        while ((currentTo = bufferedReaderTo.readLine()) != null) {
            lastTo = currentTo;
        }

        newAmountTo = Integer.parseInt(lastTo) + amount;


        BufferedWriter writerTo = Files.newBufferedWriter(Path.of(pathTo), StandardOpenOption.APPEND);
        writerTo.write("\n" + newAmountTo);
        writerTo.close();
        System.out.print("Баланс счета " + to + " после пополнения: ");
        System.out.println(newAmountTo);

    }


    void create(int parseInt, String s) throws IOException, UnknownAccountException {

        ArrayList<Account> accountsCreate = readAccountData();
        String pathCreate = "HomeTask7\\data.txt";

        int count = 0;

        for (Account account : accountsCreate) {
            if (account.getId() == parseInt) {
                count++;
                break;
            }
        }

        if (count == 1) {
            throw new UnknownAccountException("Такой счет уже сцществует");
        }

        BufferedWriter writer = Files.newBufferedWriter(Path.of(pathCreate), StandardOpenOption.APPEND);
        writer.write("\n" + parseInt);
        writer.write("\n" + "Holder_" + s);
        writer.write("\n" + "HomeTask7\\" + parseInt + ".txt");
        writer.close();

        String pathNewAccount = "HomeTask7\\" + parseInt + ".txt";
        File file = new File(pathNewAccount);
        file.createNewFile();
        FileWriter fw = new FileWriter(pathNewAccount);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.valueOf(0));
        bw.close();
    }

    public void createNew() throws IOException {
        for (int i = 1; i < 11; i++) {

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

        File file1 = new File(pathData);
        if (!file1.exists()) {
            file1.createNewFile();
            FileWriter fw = new FileWriter(pathData);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(1));
            bw.write("\n" + "Holder_1");
            bw.write("\n" + "HomeTask7\\1.txt");
            bw.close();

            for (int i = 2; i < 11; i++) {
                BufferedWriter writer = Files.newBufferedWriter(Path.of(pathData), StandardOpenOption.APPEND);
                writer.write("\n" + i);
                writer.write("\n" + "Holder_" + i);
                writer.write("\n" + "HomeTask7\\" + i + ".txt");
                writer.close();
            }
        }
    }

    void getBalance(int accountId) throws UnknownAccountException, IOException {

        ArrayList<Account> accountsBalance = readAccountData();

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

        String p = accountsBalance.get(id).getAmount();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        String current;
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        System.out.println("Счет: " + accountsBalance.get(id).getId());
        System.out.println("Владелец счета: " + accountsBalance.get(id).getHolder());
        System.out.print("Баланс счета: ");
        System.out.println(last);

    }
}




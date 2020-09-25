import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class AccountService {

    private static String current;
    private static String last;
    private static int newAmount;
    private static String pathData = "HomeTask7\\data.txt";

    public void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, IOException {

        ArrayList<Account> accountsWithdraw = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(pathData));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsWithdraw.add(new Account(Integer.parseInt(s1), br.readLine(), br.readLine()));
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

        String parhWithdraw = "HomeTask7\\" + accountsWithdraw.get(id).getId() + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(parhWithdraw));
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

        BufferedWriter writer = Files.newBufferedWriter(Path.of(parhWithdraw), StandardOpenOption.APPEND);
        writer.write("\n" + newAmount);
        writer.close();
        System.out.print("Баланс счета после снятия: ");
        System.out.println(newAmount);

    }

    public void balance(int accountId) throws UnknownAccountException, IOException {

        ArrayList<Account> accountsBalance = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(pathData));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsBalance.add(new Account(Integer.parseInt(s1), br.readLine(), br.readLine()));
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

        String p = accountsBalance.get(id).getAmount();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        System.out.println("Счет: " + accountsBalance.get(id).getId());
        System.out.println("Владелец счета: " + accountsBalance.get(id).getHolder());
        System.out.print("Баланс счета: ");
        System.out.println(last);
    }


    public void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {
        ArrayList<Account> accountsDeposit = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsDeposit.add(new Account(Integer.parseInt(s1), br.readLine(), br.readLine()));
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

        String p = accountsDeposit.get(id).getAmount();

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


    public void transfer(int from, int to, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {

        ArrayList<Account> accountsTransfer = new ArrayList<>();
        String path1 = "HomeTask7\\data.txt";
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsTransfer.add(new Account(Integer.parseInt(s1), br.readLine(), br.readLine()));
        }
        int newAmountTo;
        int newAmountFrom;
        String currentFrom;
        String lastFrom = null;
        String currentTo;
        String lastTo = null;

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


        String pathFrom = accountsTransfer.get(idFrom).getAmount();

        BufferedReader bufferedReaderFrom = new BufferedReader(new FileReader(pathFrom));
        while ((currentFrom = bufferedReaderFrom.readLine()) != null) {
            lastFrom = currentFrom;
        }

        newAmountFrom = Integer.parseInt(lastFrom) - amount;
        if (newAmountFrom < 0) {
            throw new NotEnoughMoneyException("Недостаточно стредств на счете: " + accountsTransfer.get(idFrom).getId());
        }
        System.out.println("Счет: " + accountsTransfer.get(idFrom).getId());
        System.out.println("Владелец счета: " + accountsTransfer.get(idFrom).getHolder());
        System.out.print("Баланс счета до перевода: ");
        System.out.println(lastFrom);
        System.out.println("Перевели: " + amount);


        BufferedWriter writer = Files.newBufferedWriter(Path.of(pathFrom), StandardOpenOption.APPEND);
        writer.write("\n" + newAmountFrom);
        writer.close();
        System.out.print("Баланс счета после перевода: ");
        System.out.println(newAmountFrom);

        String pathTo = accountsTransfer.get(idTo).getAmount();

        BufferedReader bufferedReaderTo = new BufferedReader(new FileReader(pathTo));

        while ((currentTo = bufferedReaderTo.readLine()) != null) {
            lastTo = currentTo;
        }

        newAmountTo = Integer.parseInt(lastTo) + amount;
        if (newAmountTo < 0) {
            throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
        }
        System.out.println("Счет: " + accountsTransfer.get(idTo).getId());
        System.out.println("Владелец счета: " + accountsTransfer.get(idTo).getHolder());
        System.out.print("Баланс счета до пополнения: ");
        System.out.println(lastTo);
        System.out.println("Перевели: " + amount);


        BufferedWriter writerTo = Files.newBufferedWriter(Path.of(pathTo), StandardOpenOption.APPEND);
        writerTo.write("\n" + newAmountTo);
        writerTo.close();
        System.out.print("Баланс счета после пополнения: ");
        System.out.println(newAmountTo);

    }


    public void create(int parseInt, String s) throws IOException, UnknownAccountException {

        ArrayList<Account> accountsCreate = new ArrayList<>();
        String pathCreate = "HomeTask7\\data.txt";

        BufferedReader br = new BufferedReader(new FileReader(pathCreate));
        String s1;
        while ((s1 = br.readLine()) != null) {
            accountsCreate.add(new Account(Integer.parseInt(s1), br.readLine(), br.readLine()));
        }

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
}




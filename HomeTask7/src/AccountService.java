import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AccountService {
    private static String current;
    private static String last;
    private static int newAmount;

   static void withdraw(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {

        String p = "HomeTask7\\" + accountId + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        System.out.println("Баланс счета до снятия наличных: " + last);
        System.out.println("Сумма снятия: " + amount);

        try {
            newAmount = Integer.parseInt(last) - amount;
            if (newAmount < 0) {
                throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
            }
            System.out.print("Баланс счета после снятия наличных: " + newAmount);
            BufferedWriter writer = Files.newBufferedWriter(Path.of(p), StandardOpenOption.APPEND);
            writer.write("\n" + newAmount);
            writer.close();
        } catch (
                NumberFormatException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void balance(int accountId) throws UnknownAccountException, IOException {

        String p = "HomeTask7\\" + accountId + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        System.out.println(last);//result
    }

    static void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {
        String p = "HomeTask7\\" + accountId + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        newAmount = Integer.parseInt(last) + amount;
        System.out.println("Баланс счета до внесения депозита: " + last);
        System.out.println("Сумма депозита: " + amount);
        System.out.println("Баланс счета после внесения депозита: " + newAmount);

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

        System.out.println("Баланс счета отправителя до перевода: " + lastFrom);
        System.out.println("Сумма перевода: " + amount);
        System.out.println("Баланс счета отправителя после перевода: " + newAmountFrom);

        System.out.println("Баланс счета получателя до перевода: " + last);
        System.out.println("Сумма перевода: " + amount);
        System.out.println("Баланс счета получателя после перевода: " + newAmountTo);
    }
}

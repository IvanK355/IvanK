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

        String p = "HomeTask7\\" + accountId + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }

        try {
            newAmount = Integer.parseInt(last) - amount;
            if (newAmount < 0) {
                throw new NotEnoughMoneyException("Недостаточно стредств на счете!");
            }

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

    static int balance(int accountId) throws UnknownAccountException, IOException {
        String p = "HomeTask7\\" + accountId + ".txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(p));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        return Integer.parseInt(last);
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

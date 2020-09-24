import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class AccountService {
    private static String current;
    private static String last;
    private static int newAmount;


    static void withdraw(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException {

    }

    static void balance(int accountId) throws UnknownAccountException, IOException {

        if (accountId < 1 && accountId > 10) {
            throw new UnknownAccountException("Номер счета неверный");
        }
        System.out.println("Баланс Счета: " + accountId);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("HomeTask7\\" + accountId + ".txt"));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        System.out.println(last);//result
    }

    static void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("HomeTask7\\" + accountId + ".txt"));
        while ((current = bufferedReader.readLine()) != null) {
            last = current;
        }
        newAmount = Integer.parseInt(last) + amount;

        /*FileWriter fw = new FileWriter("HomeTask7\\" + accountId + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);

        // Write in file
        bw.write(String.valueOf(newAmount));

        // Close connection
        bw.close();*/
        String p = "HomeTask7\\" + accountId + ".txt";
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(p), StandardOpenOption.APPEND)) {
            writer.write("\n"+ newAmount);
        }
    }


    static void transfer(int from, int to, int amount) throws
            NotEnoughMoneyException, UnknownAccountException {

    }
}

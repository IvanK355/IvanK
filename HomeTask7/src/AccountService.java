import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class AccountService {
    static void withdraw(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException {

    }

    static void balance(int accountId) throws UnknownAccountException, IOException {
        if (accountId < 1 && accountId > 10) {
            throw new UnknownAccountException("Номер счета неверный");
        }
        System.out.println("Баланс Счета: " + accountId);
        Files.lines(Paths.get("HomeTask7\\" + accountId + ".txt"), UTF_8).forEach(System.out::println);;
    }

    static void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException {

    }

    static void transfer(int from, int to, int amount) throws
            NotEnoughMoneyException, UnknownAccountException {

    }
}

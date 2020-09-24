public class AccountService {
    static void withdraw(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException {

    }

    static void balance(int accountId) throws UnknownAccountException {
        System.out.println("Баланс Счета: " + accountId);
        System.out.println("1000 USD");
    }

    static void deposit(int accountId, int amount) throws
            NotEnoughMoneyException, UnknownAccountException {

    }

    static void transfer(int from, int to, int amount) throws
            NotEnoughMoneyException, UnknownAccountException {

    }
}

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, UnknownAccountException, UnknownNameOperationException, NotEnoughMoneyException {
        BankFacade facade = new BankFacade();
        facade.info();
    }
}

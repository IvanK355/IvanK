import javax.security.auth.login.AccountException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class BankFacade {

    private Account account;
    private AccountService accountService;


    public BankFacade() throws FileNotFoundException {
        this.account = new Account();
        this.accountService = new AccountService();
    }

    public void info() throws IOException, UnknownAccountException, NotEnoughMoneyException, UnknownNameOperationException {

        for (int i = 2; i < 22; i += 2) {

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
        String path1 = "HomeTask7\\data.txt";

        File file1 = new File(path1);
        if (!file1.exists()) {
            file1.createNewFile();

            file1.createNewFile();
            FileWriter fw = new FileWriter(path1);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.valueOf(2));
            bw.write("\n" + "Holder_2");
            bw.close();

            for (int i = 4; i < 22; i += 2) {
                BufferedWriter writer = Files.newBufferedWriter(Path.of(path1), StandardOpenOption.APPEND);
                writer.write("\n" + i);
                writer.write("\n" + "Holder_" + i);
                writer.close();
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        String[] array = s.split("\\W");


        switch (array[0]) {
            case ("balance") -> {
                AccountService.balance(Integer.parseInt(array[1]));
                break;
            }
            case ("withdraw") -> {
                AccountService.withdraw(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                break;
            }
            case ("deposit") -> {
                {
                    AccountService.deposit(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                    break;
                }
            }
            case ("transfer") -> {
                AccountService.transfer(Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]));
                break;
            }

            default -> throw new UnknownNameOperationException("Неизвестная операция " + array[0]);


        }
    }
}

//BufferedReader br = new BufferedReader(new FileReader(path1));

//for (int i = 1; i < (qtyAccounts + 1); i++) {
//String s1;
//while ((s1 = br.readLine()) != null) {
//  accounts.add(new Account(Integer.parseInt(s1), br.readLine()));


// account.getInfo();
// accountService.getInfo();



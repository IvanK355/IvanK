import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, UnknownAccountException, NotEnoughMoneyException, UnknownNameOperationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int accountId, to, from, amount;
        int qtyAccounts = 10;



        try {
            // Create new file
            //String content = "100";
            for (int i = 1; i < (qtyAccounts + 1); i++) {

                String path = "HomeTask7\\"+i + ".txt";
                File file = new File(path);
                // If file doesn't exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }



        String s = reader.readLine();
        String[] array = s.split("\\W");

        for (String x : array) {
            System.out.println(x);
        }

        switch (array[0]) {
            case ("balance") -> {
                accountId = Integer.parseInt(array[1]);
                AccountService.balance(accountId);
            }
            case ("withdraw") -> {
                accountId = Integer.parseInt(array[1]);
                amount = Integer.parseInt(array[2]);
                AccountService.withdraw(accountId, amount);
            }
            case ("deposite") -> {
                accountId = Integer.parseInt(array[1]);
                amount = Integer.parseInt(array[2]);
                AccountService.deposit(accountId, amount);
            }
            case ("transfer") -> {
                from = Integer.parseInt(array[1]);
                to = Integer.parseInt(array[2]);
                amount = Integer.parseInt(array[3]);
                AccountService.transfer(from, to, amount);
            }
            default -> throw new UnknownNameOperationException("Неизвестная операция " + array[0]);
        }
    }


}

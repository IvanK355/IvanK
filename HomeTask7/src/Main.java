import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, UnknownNameOperationException, UnknownAccountException, NotEnoughMoneyException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int accountId, to, from, amount;
        int qtyAccounts = 11;

        ArrayList<Account> accounts = new ArrayList<>();

        for (int i = 2; i < 22; i+=2) {

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

            for (int i = 4; i < 22; i+=2) {
                BufferedWriter writer = Files.newBufferedWriter(Path.of(path1), StandardOpenOption.APPEND);
                writer.write("\n" + i);
                writer.write("\n" + "Holder_" + i);
                writer.close();
            }
        }

        BufferedReader br = new BufferedReader(new FileReader(path1));

        //for (int i = 1; i < (qtyAccounts + 1); i++) {
        String s1;
        while ((s1 = br.readLine()) != null) {
            accounts.add(new Account(Integer.parseInt(s1), br.readLine()));
        }


        //System.out.println(accounts.get(10).getHolder()+" " + accounts.get(10).getId());


        String s = reader.readLine();

        String[] array = s.split("\\W");


        switch (array[0]) {
            case ("balance") -> {
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getId() == Integer.parseInt(array[1])) {
                        System.out.println("Счет: " + accounts.get(i).getId());
                        System.out.println("Владелец счета: " + accounts.get(i).getHolder());
                        System.out.print("Баланс счета: ");
                        System.out.println(accounts.get(i).getAmount());
                    }
                    else {throw new UnknownAccountException("Счет неверный");}
                }
            }
            case ("withdraw") -> {
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getId() == Integer.parseInt(array[1])) {
                        amount = Integer.parseInt(array[2]);
                        System.out.println("Счет: " + accounts.get(i).getId());
                        System.out.println("Владелец счета: " + accounts.get(i).getHolder());
                        System.out.print("Баланс счета до снятия наличных: ");
                        System.out.println(accounts.get(i).getAmount());
                        System.out.println("Сумма снятия: " + amount);
                        AccountService.withdraw(accounts.get(i).getId(), amount);
                        System.out.print("Баланс счета после снятия наличных: ");
                        System.out.println(accounts.get(i).getAmount());
                    }
                }
            }
            case ("deposit") -> {
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getId() == Integer.parseInt(array[1])) {
                        amount = Integer.parseInt(array[2]);
                        System.out.println("Счет: " + accounts.get(i).getId());
                        System.out.println("Владелец счета: " + accounts.get(i).getHolder());
                        System.out.print("Баланс счета до внесения наличных: ");
                        System.out.println(accounts.get(i).getAmount());
                        System.out.println("Сумма депозита: " + amount);
                        AccountService.deposit(accounts.get(i).getId(), amount);
                        System.out.print("Баланс счета после внесенмя наличных: ");
                        System.out.println(accounts.get(i).getAmount());
                    }
                }
            }
            case ("transfer") -> {
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getId() == Integer.parseInt(array[1])) {
                        for (int j = 0; j < accounts.size(); j++) {
                            if (accounts.get(j).getId() == Integer.parseInt(array[2])) {
                                amount = Integer.parseInt(array[3]);
                                System.out.print("Баланс счета Отправителя " + accounts.get(i).getHolder() + " до перевода: ");
                                System.out.println(accounts.get(i).getAmount());
                                System.out.print("Баланс счета Получателя " + accounts.get(j).getHolder() + " до перевода: ");
                                System.out.println(accounts.get(j).getAmount());
                                System.out.println("Сумма перевода: " + amount);
                                AccountService.transfer(Integer.parseInt(array[1]), Integer.parseInt(array[2]), amount);
                                System.out.print("Баланс счета Отправителя " + accounts.get(i).getHolder() + " после перевода: ");
                                System.out.println(accounts.get(i).getAmount());
                                System.out.print("Баланс счета Получателя " + accounts.get(j).getHolder() + " после перевода: ");
                                System.out.println(accounts.get(j).getAmount());
                            }
                        }
                    }
                }

            }
            default -> throw new UnknownNameOperationException("Неизвестная операция " + array[0]);
        }
    }
}

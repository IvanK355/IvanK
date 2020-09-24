import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String s = reader.readLine();
        list.add(s);
        String[] array = list.toArray(new String[0]);

        switch (array[0]) {
            case ("balance") -> System.out.println("Баланс");
            case ("withdraw") -> System.out.println("Снятие");
            case ("deposite") -> System.out.println("Пополнение");
            case ("transfer") -> System.out.println("Перевод");
        }
    }
}

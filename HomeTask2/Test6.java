import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {
    public static void main(String[] args) throws IOException {
        String plusminus;
        String chetnecet;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());

        if (s > 0) {
            plusminus = "положительное";
        } else {
            plusminus = "отрицательное";
        }

        if (s % 2 == 0) {
            chetnecet = "четное";
        } else {
            chetnecet = "нечетное";
        }

        if (s == 0) {
            System.out.println("нулевое число");
        } else {
            System.out.println(s + " " + plusminus + " " + chetnecet + " число");
        }
    }
}

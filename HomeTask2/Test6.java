import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {
    public static void main(String[] args) throws IOException {
        String positiveNegativeNumber;
        String oddEvenNumber;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());

        if (s > 0) {
            positiveNegativeNumber = "положительное";
        } else {
            positiveNegativeNumber = "отрицательное";
        }

        if (s % 2 == 0) {
            oddEvenNumber = "четное";
        } else {
            oddEvenNumber = "нечетное";
        }

        if (s == 0) {
            System.out.println("нулевое число");
        } else {
            System.out.println(s + " " + positiveNegativeNumber + " " + oddEvenNumber + " число");
        }
    }
}

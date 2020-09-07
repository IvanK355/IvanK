import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());
        if ((s > 0) && ((s % 2 != 0))) System.out.println("положительное нечетное число");
        else if ((s < 0) && ((s % 2 != 0))) System.out.println("отрицательное нечетное число");
        else if ((s > 0) && ((s % 2 == 0))) System.out.println("положительное четное число");
        else if ((s < 0) && ((s % 2 == 0))) System.out.println("отрицательное четное число");
        else if (s == 0) System.out.println("нулевое число");
    }
}

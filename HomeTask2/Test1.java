import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(reader.readLine());
        int lastNumber = s % 10;

        System.out.println(lastNumber);
    }
}

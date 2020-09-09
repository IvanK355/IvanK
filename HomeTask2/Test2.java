import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    public static void main(String[] args) throws IOException {
        int sum = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        char[] result = str.toCharArray();
        int[] number = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            number[i] = Integer.parseInt(String.valueOf(result[i]));
            sum += number[i];
        }

        System.out.println(sum);
    }
}

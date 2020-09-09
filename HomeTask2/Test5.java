import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test5 {
    public static void main(String[] args) throws IOException {
        int min;
        int[] s = new int[3];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            s[i] = Integer.parseInt(reader.readLine());
        }

        min = s[0];

        for (int i = 1; i < s.length; i++) {
            if (s[i] < min) {
                min = s[i];
            }
        }

        System.out.println(min);
    }
}

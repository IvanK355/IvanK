import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] s = new int[3];
        s[0] = Integer.parseInt(reader.readLine());
        s[1] = Integer.parseInt(reader.readLine());
        s[2] = Integer.parseInt(reader.readLine());
        Arrays.sort(s);
        System.out.println(s[0]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());
        if (s > 0) s++;
        else {
            if (s < 0) s -= 2;
            else s = 10;
        }
        System.out.println(s);
    }
}

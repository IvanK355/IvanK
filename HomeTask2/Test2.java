import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());
        int triigit = s % 10;
        int secdigit = s / 10 % 10;
        int fstdigit = s / 100;
        System.out.println(triigit+secdigit+fstdigit);

    }
}

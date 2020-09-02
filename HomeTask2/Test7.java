import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int codeGoroda = Integer.parseInt(reader.readLine());
        int minutedur = 10;
        double moscost = 4.15;
        double rostovcost = 1.98;
        double krasnodarcost = 2.69;
        double kirovcost = 5.0;

        switch (codeGoroda) {
            case (905) -> System.out.println("Москва. Стоимость разговора:" + minutedur * moscost);
            case (194) -> System.out.println("Ростов. Стоимость разговора:" + minutedur * rostovcost);
            case (491) -> System.out.println("Краснодар. Стоимость разговора:" + minutedur * krasnodarcost);
            case (800) -> System.out.println("Киров. Стоимость разговора:" + minutedur * kirovcost);
        }
    }
}

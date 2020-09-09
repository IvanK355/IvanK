import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7 {
    public static void main(String[] args) throws IOException {

        int duration = 10;
        double costPerMinuteMoscow = 4.15;
        double costPerMinuteiteRostov = 1.98;
        double costPerMinitKrasnodar= 2.69;
        double costPerMinuteKirov = 5.0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int townCode = Integer.parseInt(reader.readLine());


        switch (townCode) {
            case (905) -> System.out.println("Москва. Стоимость разговора:" + duration * costPerMinuteMoscow);
            case (194) -> System.out.println("Ростов. Стоимость разговора:" + duration * costPerMinuteiteRostov);
            case (491) -> System.out.println("Краснодар. Стоимость разговора:" + duration * costPerMinitKrasnodar);
            case (800) -> System.out.println("Киров. Стоимость разговора:" + duration * costPerMinuteKirov);
        }
    }
}

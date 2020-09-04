package Test1;

public class Main {
    public static void main(String[] args) {

        Phone iphone = new Phone();
        iphone.number = 7;
        iphone.model = "SE";
        iphone.weight = 101.56;

        Phone samsung = new Phone();
        samsung.number = 9;
        samsung.model = "Galaxy";
        samsung.weight = 99.45;

        Phone xiaomi = new Phone();
        xiaomi.number = 8;
        xiaomi.model = "Note";
        xiaomi.weight = 104.45;

        System.out.println(iphone.number+" "+iphone.model+" "+iphone.weight);
        System.out.println(samsung.number+" "+samsung.model+" "+samsung.weight);
        System.out.println(xiaomi.number+" "+xiaomi.model+" "+xiaomi.weight);
    }
}

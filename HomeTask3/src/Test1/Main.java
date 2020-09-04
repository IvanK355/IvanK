package Test1;

public class Main {
    public static void main(String[] args) {

        Phone iphone = new Phone(7,"SE", 101.56);
        iphone.telNumberAbonent = 6669988;
        iphone.nameAbonent = "Ivan";

        iphone.getNumber(iphone.telNumberAbonent);
        iphone.receiveCall(iphone.nameAbonent);
        iphone.receiveCall(iphone.nameAbonent, iphone.telNumberAbonent);

        Phone samsung = new Phone(9,"Galaxy", 99.45);
        samsung.telNumberAbonent = 7779988;
        samsung.nameAbonent = "Danil";

        samsung.getNumber(samsung.telNumberAbonent);
        samsung.receiveCall(samsung.nameAbonent);
        samsung.receiveCall(samsung.nameAbonent, samsung.telNumberAbonent);

        Phone xiaomi = new Phone(8, "Note", 104.45);
        xiaomi.telNumberAbonent = 5559988;
        xiaomi.nameAbonent = "Maxim";

        xiaomi.getNumber(xiaomi.telNumberAbonent);
        xiaomi.receiveCall(xiaomi.nameAbonent);
        xiaomi.receiveCall(xiaomi.nameAbonent, xiaomi.telNumberAbonent);

        System.out.println(iphone.number+" "+iphone.model+" "+iphone.weight);
        System.out.println(samsung.number+" "+samsung.model+" "+samsung.weight);
        System.out.println(xiaomi.number+" "+xiaomi.model+" "+xiaomi.weight);

        Phone.sendMessage(1, 2, 3);


    }
}

package Test1;

public class Phone {
    int number;
    String model;
    double weight;
    String nameAbonent;
    int telNumberAbonent;

    public Phone(int number, String model, double weight) {
        this(number, model);
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    public void receiveCall(String nameAbonent) {
        System.out.println("Звонит " + nameAbonent);
    }

    public void getNumber(int telNumberAbonent) {
        System.out.println(telNumberAbonent);
    }

    public void receiveCall(String nameAbonent, int telNumberAbonent) {
        System.out.println("Звонит " + nameAbonent + " номер телефона " + telNumberAbonent);
    }

    // Метод vaTest() допускает переменное число аргументов
    public static void sendMessage(int... v) {
        System.out.println("Кол-во номеров: " + v.length);
        System.out.println("Телефон: ");

        for (int i = 0; i < v.length; i++) {
            System.out.println("№ " + i + ": " + v[i]);
        }
        System.out.println();
    }
}

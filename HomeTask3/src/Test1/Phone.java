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

    public void receiveCall (String nameAbonent) {
        System.out.println("Звонит "+nameAbonent);
    }

    public void getNumber (int telNumberAbonent) {
        System.out.println(telNumberAbonent);
    }

    public void receiveCall (String nameAbonent, int telNumberAbonent) {
        System.out.println("Звонит "+nameAbonent + " номер телефона "+ telNumberAbonent);
    }


}

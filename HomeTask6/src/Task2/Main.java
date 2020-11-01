package Task2;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        Apple apple = new Apple();
        Orange orange = new Orange();

        for (int i=0;i< apple.getQty();i++) {
            appleBox.addFruit(new Apple());
        }

        for (int i=0; i< orange.getQty();i++){
            orangeBox.addFruit(new Orange());
        }

        System.out.println(appleBox.getTotalWeight());
        System.out.println(orangeBox.getTotalWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box <Apple> appleBox1 = new Box<>();
        Box <Apple> appleBox2 = new Box<>();

        System.out.println(appleBox.getBox());
        appleBox.transfer(appleBox1);
        System.out.println(appleBox.getTotalWeight());
        System.out.println(appleBox1.getTotalWeight());
        System.out.println(appleBox.getBox());
        System.out.println(appleBox1.getBox());

        System.out.println(appleBox1.getBox());
        appleBox1.transferv2(appleBox2);
        System.out.println(appleBox1.getTotalWeight());
        System.out.println(appleBox2.getTotalWeight());

        System.out.println(appleBox1.getBox());
        System.out.println(appleBox2.getBox());

    }
}

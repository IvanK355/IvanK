package Task2;

public abstract class Car {
    public String carModel;
    public String carClass;
    public int carWeigth;
    public Engine carEngine;

    public abstract String start();

    public abstract String stop();

    public abstract void printInfo();

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }
}

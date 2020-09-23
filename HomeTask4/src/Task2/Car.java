package Task2;

public abstract class Car {
    String carModel;
    String carClass;
    int carWeigth;
    Engine engine;

    Car(String carModel, String carClass, int carWeigth, Engine engine) {
        this.carModel = carModel;
        this.carClass = carClass;
        this.carWeigth = carWeigth;
        this.engine = engine;
    }

    abstract void start();

    abstract void stop();

    abstract void printInfo();

    void turnRight() {
        System.out.println("Поворот направо");
    }

    void turnLeft() {
        System.out.println("Поворот налево");
    }
}

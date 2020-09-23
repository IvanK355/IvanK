package Task2;

public class Main {
    public static void main(String[] args) {
        Engine lorryEngine = new Engine();
        lorryEngine.setCapacity(800);
        lorryEngine.setMaker("Hino");

        Engine sportCarEngine = new Engine();
        sportCarEngine.setCapacity(320);
        sportCarEngine.setMaker("Ferrari");

        Car lorry = new Lorry("Hino", "Truck", 15000, lorryEngine, 8000);
        Car sportCar = new SportCar("Ferrari", "Racing", 1800, sportCarEngine, 380);

        lorry.printInfo();
        lorry.start();
        lorry.turnLeft();
        lorry.stop();
        lorry.start();
        lorry.turnRight();

        System.out.println();

        sportCar.printInfo();
        sportCar.start();
        sportCar.turnLeft();
        sportCar.stop();
        sportCar.start();
        sportCar.turnRight();
    }
}

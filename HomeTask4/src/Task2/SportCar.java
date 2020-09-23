package Task2;

public class SportCar extends Car {

    private int topSpeed;

    public SportCar(String carModel, String carClass, int carWeigth, Engine engine, int topSpeed) {
        super(carModel, carClass, carWeigth, engine);
        this.topSpeed = topSpeed;
    }


    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }


    @Override
    public void printInfo() {

        System.out.println("Марка автомобиля: " + carModel);
        System.out.println("Класс автомобиля: " + carClass);
        System.out.println("Вес автомобиля: " + carWeigth);
        System.out.println("Предельная скорость: " + getTopSpeed());
        System.out.println("Мощность двигателя : " + engine.getCapacity());
        System.out.println("Произодитель двигателя: " + engine.getMaker());
        System.out.println();
    }

    @Override
    public void start() {
        System.out.println("SportCar поехал");
    }

    @Override
    public void stop() {

        System.out.println("SportCar остановился");
    }
}

package Task2;

public class Lorry extends Car {

    private int carryingCapacity;

    public Lorry(String carModel, String carClass, int carWeigth, Engine engine, int carryingCapacity) {
        super(carModel, carClass, carWeigth, engine);
        this.carryingCapacity = carryingCapacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public void start() {
        System.out.println("Грузовик поехал");
    }

    @Override
    public void stop() {

        System.out.println("Грузовик остановился");
    }

    @Override
    public void printInfo() {

        System.out.println("Марка автомобиля: " + carModel);
        System.out.println("Класс автомобиля: " + carClass);
        System.out.println("Вес автомобиля: " + carWeigth);
        System.out.println("Грузоподьемоность: " + getCarryingCapacity());
        System.out.println("Мощность двигателя : " + engine.getCapacity());
        System.out.println("Произодитель двигателя: " + engine.getMaker());
        System.out.println();
    }
}

package Task2;

public class Lorry extends Car {

    int carryingCapacity;

    @Override
    public String start() {
        return "Грузовик поехал";
    }

    @Override
    public String stop() {
        return "Грузовик остановился";
    }

    @Override
    public void printInfo() {

        System.out.println("Марка автомобиля: " + carModel);
        System.out.println("Класс автомобиля: " + carClass);
        System.out.println("Вес автомобиля: " + carWeigth);
        System.out.println("Мощность двигателя: " + carEngine.Capacity);
        System.out.println("Производитель двигателя: " + carEngine.Maker);
        System.out.println("Грузоподьемоность: " + carryingCapacity);
    }
}

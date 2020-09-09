package Task2;

public class SportCar extends Car {

    int topSpeed;

    @Override
    public String start() {
        return "SportCar поехал";
    }

    @Override
    public String stop() {
        return "SportCar остановился";
    }

    @Override
    public void printInfo() {

        System.out.println("Марка автомобиля: "+ carModel);
        System.out.println("Класс автомобиля: "+ carClass);
        System.out.println("Вес автомобиля: "+carWeigth);
        System.out.println("Мощность двигателя: "+carEngine.Capacity);
        System.out.println("Производитель двигателя: "+carEngine.Maker);
        System.out.println("Предельная скорость: "+topSpeed);
    }
}

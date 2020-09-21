package Test2;

public class Main {
    public static void main(String[] args) {

        Veterinar veterinar = new Veterinar(30, true);

        Animal[] animals = new Animal[3];

        animals[0] = new Cat("Wiskas", "Kovrik", true);
        animals[1] = new Dog("Chappy", "Budka", "Hunting");
        animals[2] = new Horse("Seno", "Stoylo", true);

        for (int i = 0; i < 3; i++) {

            veterinar.treatAnimal(animals[i]);
        }
    }
}

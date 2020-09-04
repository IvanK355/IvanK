package Test2;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("Wiskas","Kovrik");
        animals[1] = new Dog("Chappy","Budka");
        animals[2] = new Horse("Seno", "Stoylo");

        for(int i=0;i<3;i++){

          Veterinar.treatAnimal(animals[i]);     }

        }
    }

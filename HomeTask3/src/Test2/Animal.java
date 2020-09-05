package Test2;

public class Animal {
    String food;
    String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    void makeNoise(){
        System.out.println("животное спит");
    }
    void eat(){}
    void sleep(){}
    }

class Dog extends Animal{

        public Dog(String food, String location) {
        super(food, location);
    }

    @Override
    void makeNoise() {
        System.out.println("Dog животное спит");
    }

    @Override
    void eat() {
        System.out.println("Dog животное ест");
    }
}

class Cat extends Animal{

    public Cat(String food, String location) {
        super(food, location);
    }

    @Override
    void makeNoise(){
        System.out.println(this.getClass().getName()+"животное спит");
    }

    @Override
    void eat() {
        System.out.println(this.getClass().getName()+"животное ест");
    }
}

class Horse extends Animal{

    public Horse(String food, String location) {
        super(food, location);
    }

    @Override
    void makeNoise(){
        System.out.println("Horse животное спит");
    }

    @Override
    void eat() {
        super.eat();
    }
}

class Veterinar {

    public static void treatAnimal(Animal animal){
        System.out.println(animal.getClass().getTypeName()+" "+animal.food+" "+animal.location);
    }
}


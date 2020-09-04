package Test2;

public class Animal {
    String food;
    String location;

    void makeNoise(){
        System.out.println("животное спит");
    }
    void eat(){}
    void sleep(){}
    }

class Dog extends Animal{

    @Override
    void makeNoise() {
        System.out.println("Dog животное спит");
    }
}

class Cat extends Animal{

    @Override
    void makeNoise(){
        System.out.println("Cat животное спит");
    }
}

class Horse extends Animal{

    @Override
    void makeNoise(){
        System.out.println("Horse животное спит");
    }
}

class Veterinar{

    void treatAnimal(Animal animal){

    }
}


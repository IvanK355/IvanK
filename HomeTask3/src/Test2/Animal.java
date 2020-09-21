package Test2;

public class Animal {
    public String food;
    public String location;


    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    void makeNoise() {

        System.out.println("Животное шумит");
    }

    void eat() {

        System.out.println("Животное ест");
    }

    void sleep() {

        System.out.println("Животное спит");
    }
}


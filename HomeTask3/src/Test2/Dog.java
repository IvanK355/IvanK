package Test2;

class Dog extends Animal {

    public String usingDogs;

    public Dog(String food, String location, String usingDogs) {
        super(food, location);
        this.usingDogs = usingDogs;
    }

    @Override
    void makeNoise() {
        System.out.println(this.getClass().getName() + " животное шумит");
    }

    @Override
    void eat() {
        System.out.println(this.getClass().getName() + " животное ест");
    }

    @Override
    void sleep() {
        System.out.println(this.getClass().getName() + "животное спит");
    }
}

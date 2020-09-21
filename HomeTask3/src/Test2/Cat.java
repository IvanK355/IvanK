package Test2;

class Cat extends Animal {

    public boolean predator;

    public Cat(String food, String location, boolean predator) {
        super(food, location);
        this.predator = predator;
    }

    @Override
    void makeNoise() {
        System.out.println(this.getClass().getName() + "животное шумит");
    }

    @Override
    void eat() {
        System.out.println(this.getClass().getName() + "животное ест");
    }

    @Override
    void sleep() {
        System.out.println(this.getClass().getName() + "животное спит");
    }
}

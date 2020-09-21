package Test2;

class Horse extends Animal {

    public boolean runningHorse;

    public Horse(String food, String location, boolean runningHorse) {

        super(food, location);
        this.runningHorse = runningHorse;
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

package Task2;

public class Engine {

    private int capacity;
    private String maker;


    public Engine(int capacity, String maker) {
        this.capacity = capacity;
        this.maker = maker;
    }

    public Engine() {
        this.capacity = 110;
        this.maker = "Lada";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}

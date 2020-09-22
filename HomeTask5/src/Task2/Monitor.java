package Task2;

public class Monitor {
    private String monitorMaker;

    public Monitor() {
        this.monitorMaker = "NEC";
    }

    public void getInfo() {
        System.out.println("Характеристика монитора");
        System.out.println("производитель " + monitorMaker);
    }
}

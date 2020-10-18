package Task2;

public class Monitor implements Computer{
    private String monitorMaker;

    public Monitor() {
        this.monitorMaker = "NEC";
    }

    @Override
    public void info() {
        System.out.println("Характеристика монитора");
        System.out.println("производитель " + monitorMaker);
    }
}

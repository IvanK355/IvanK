package Task2;

public class MonitorFillStratege implements FillComputerStrategy {
    private String monitorMaker = "NEC";

    @Override
    public void fill() {

        System.out.println("Характеристика монитора");
        System.out.println("производитель " + monitorMaker);
    }
}

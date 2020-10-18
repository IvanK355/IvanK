package Task2;

public class Monitor extends Computer{
    public Monitor() {
        this.fillComputerStrategy = new MonitorFillStratege();
    }
}

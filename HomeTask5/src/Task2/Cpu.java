package Task2;

public class Cpu extends Computer {

    public Cpu() {
        this.fillComputerStrategy = new CpuFillStrategy();
    }
}

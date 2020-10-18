package Task2;

public class Ram extends Computer{
    public Ram() {
     this.fillComputerStrategy = new RamFillStrategy();
    }
}

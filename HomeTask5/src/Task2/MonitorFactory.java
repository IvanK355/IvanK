package Task2;

public class MonitorFactory extends ComputerFactory{
    @Override
    public Computer createComputer() {
        return new Monitor();
    }
}

package Task2;

public class CpuFactory extends ComputerFactory {
    @Override
    public Computer createComputer() {
        return new Cpu();
    }
}

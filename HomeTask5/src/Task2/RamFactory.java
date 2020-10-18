package Task2;

public class RamFactory extends ComputerFactory{
    @Override
    public Computer createComputer() {
        return new Ram();
    }
}

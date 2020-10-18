package Task2;

public class StorageDeviceFactory extends ComputerFactory {
    @Override
    public Computer createComputer() {
        return new StorageDevice();
    }
}

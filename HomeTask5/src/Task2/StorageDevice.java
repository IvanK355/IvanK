package Task2;

public class StorageDevice extends Computer{
    public StorageDevice() {
        this.fillComputerStrategy = new StorageDeviceFillStrategy();
    }
}

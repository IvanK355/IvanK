package Task2;

import java.util.ArrayList;

public class ComputerFacade {

    private Cpu cpu;
    private Ram ram;
    private VideoCard videoCard;
    private StorageDevice storageDevice;
    private Monitor monitor;

    public ComputerFacade() {
        this.cpu = new Cpu();
        this.ram = new Ram();
        this.videoCard = new VideoCard();
        this.storageDevice = new StorageDevice();
        this.monitor = new Monitor();
    }

    public void info() {
        cpu.getInfo();
        ram.getInfo();
        monitor.getInfo();
        videoCard.getInfo();
        storageDevice.getInfo();
    }
}

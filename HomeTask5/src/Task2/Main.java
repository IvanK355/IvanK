package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Для того чтобы создать экземпляр " +
                "экземпляров классов характеристик введите   CPU,\n" +
                "    MONITOR,\n" +
                "    RAM,\n" +
                "    STORAGEDEVICE,\n" +
                "    VIDEOCARD");
        Scanner sc = new Scanner(System.in);

        ComputerType type = ComputerType.valueOf(sc.nextLine());
        ComputerFactory factory = null;
        switch (type) {
            case CPU -> factory = new CpuFactory();
            case MONITOR -> factory = new MonitorFactory();
            case RAM -> factory = new RamFactory();
            case STORAGEDEVICE -> factory = new StorageDeviceFactory();
            case VIDEOCARD -> factory = new StorageDeviceFactory();
            default -> System.out.println("Ошибка ввода");
        }
        if (factory != null) {
            Computer computer = factory.createComputer();
            computer.info();
        }
    }
}

package Task2;

public class CpuFillStrategy implements FillComputerStrategy {

    private String cpuClockFrequency = "555 Hz";
    private int cpuQtyCore = 8;
    private String cpuCacheMemory = "512 Mb";
    private String cpuName = "Core i5";
    private String cpuMaker = "Intel";


    @Override
    public void fill() {
        System.out.println("Характеристика процессора");
        System.out.println(
                "тактовая частота " + cpuClockFrequency + "\n" +
                        "кол-во ядер " + cpuQtyCore + "\n" +
                        "кеш память " + cpuCacheMemory + "\n" +
                        "название " + cpuName + "\n" +
                        "производитель " + cpuMaker);

    }
}


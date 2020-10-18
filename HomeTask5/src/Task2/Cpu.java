package Task2;

public class Cpu implements Computer {

    private String cpuClockFrequency;
    private int cpuQtyCore;
    private String cpuCacheMemory;
    private String cpuName;
    private String cpuMaker;

    public Cpu() {
        this.cpuClockFrequency = "3.2 GHz";
        this.cpuQtyCore = 7;
        this.cpuCacheMemory = "1 Gb";
        this.cpuName = "Core";
        this.cpuMaker = "Intel";
    }


    @Override
    public void info() {
        System.out.println("Характеристика процессора");
        System.out.println(
                "тактовая частота " + cpuClockFrequency + "\n" +
                        "кол-во ядер " + cpuQtyCore + "\n" +
                        "кеш память " + cpuCacheMemory + "\n" +
                        "название " + cpuName + "\n" +
                        "производитель " + cpuMaker);

    }
}

package Task2;

public class Cpu {

    private String cpuClockFrequency = "3.2 GHz";
    private int cpuQtyCore = 7;
    private String cpuCacheMemory = "1 Gb";
    private String cpuName = "Core";
    private String cpuMaker = "Intel";

    public void getInfo() {
        System.out.println("Характеристика процессора");
        System.out.println(
                        "тактовая чистота " + cpuClockFrequency + "\n" +
                        "кол-во ядер " + cpuQtyCore + "\n" +
                        "кеш память " + cpuCacheMemory + "\n" +
                        "название " + cpuName + "\n" +
                        "производитель " + cpuMaker);
    }
}

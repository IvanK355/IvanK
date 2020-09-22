package Task2;

public class StorageDevice {
    private String sdMemory;
    private String sdFormFactor;
    private String[] sdType = new String[2];
    private String sdMaker;

    public StorageDevice() {
        this.sdMemory = "160 Gb";
        this.sdFormFactor = "CFF";
        this.sdType[0] = "HDD";
        this.sdType[1] = "SSD";
        this.sdMaker = "IBM";
    }

    public void getInfo() {
        System.out.println("Характеристика накопителя");
        System.out.println(
                "форм-фактор " + sdFormFactor + "\n" +
                        "обьем памяти " + sdMemory + "\n" +
                        "тип накопителя " + sdType[0] + "\n" +
                        "производитель " + sdMaker);
    }
}

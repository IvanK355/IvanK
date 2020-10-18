package Task2;

public class StorageDeviceFillStrategy implements FillComputerStrategy {

    private String sdMemory = "160 Gb";
    private String sdFormFactor = "CFF";
    private String [] sdType = {"HDD","SDD"};
    private String sdMaker = "IBM";


    public void fill() {
        System.out.println("Характеристика накопителя");
        System.out.println(
                "форм-фактор " + sdFormFactor + "\n" +
                        "обьем памяти " + sdMemory + "\n" +
                        "тип накопителя " + sdType[0] + "\n" +
                        "производитель " + sdMaker);
    }
}

package Task2;

public class VideoCardFillStrategy implements FillComputerStrategy {

    private String cardMemory = "16 Gb";
    private String cardTypeMemory = "RAM";
    private String[] cardCooler = {"Active", "Passive"};
    private String cardMaker = "NVideo";

    public void fill() {
        System.out.println("Характеристика видеокарты");
        System.out.println(
                "охлаждение " + cardCooler[0] + "\n" +
                        "память " + cardMemory + "\n" +
                        "тип памяти " + cardTypeMemory + "\n" +
                        "производитель " + cardMaker);
    }
}

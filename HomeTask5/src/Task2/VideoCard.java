package Task2;

public class VideoCard {

    private String cardMemory;
    private String cardTypeMemory;
    private String[] cardCooler = new String[2];
    private String cardMaker;

    public VideoCard() {
        this.cardMemory = "16 Gb";
        this.cardTypeMemory = "RAM";
        this.cardCooler[0] = "Active";
        this.cardCooler[1] = "Passive";
        this.cardMaker = "NVideo";
    }

    public void getInfo() {
        System.out.println("Характеристика видеокарты");
        System.out.println(
                "охлаждение " + cardCooler[0] + "\n" +
                        "память " + cardMemory + "\n" +
                        "тип памяти " + cardTypeMemory + "\n" +
                        "производитель " + cardMaker);
    }
}

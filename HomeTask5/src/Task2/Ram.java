package Task2;

public class Ram implements Computer{
    private String ramMaker;
    private String ramMamory;
    private String ramFrequency;
    private String ramType;

    public Ram() {
        this.ramMaker = "Corsair";
        this.ramMamory = "8 Gb";
        this.ramFrequency = "4200MHz";
        this.ramType = "DRAM";
    }

    @Override
    public void info() {
        System.out.println("Характеристика оперативной памяти");
        System.out.println(
                "частота " + ramFrequency + "\n" +
                        "обьем памяти " + ramMamory + "\n" +
                        "тип памяти " + ramType + "\n" +
                        "производитель " + ramMaker);
    }
}

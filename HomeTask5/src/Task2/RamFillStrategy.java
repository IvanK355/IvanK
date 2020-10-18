package Task2;

public class RamFillStrategy implements FillComputerStrategy{
    private String ramMaker = "Corsair";
    private String ramMamory = "8 Gb";
    private String ramFrequency = "4200MHz";
    private String ramType = "DRAM";


    @Override
    public void fill() {
        System.out.println("Характеристика оперативной памяти");
        System.out.println(
                "частота " + ramFrequency + "\n" +
                        "обьем памяти " + ramMamory + "\n" +
                        "тип памяти " + ramType + "\n" +
                        "производитель " + ramMaker);
    }
}


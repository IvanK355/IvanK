package Task2;

public class VideoCardFactory extends ComputerFactory {
    @Override
    public Computer createComputer() {
        return new VideoCard();
    }
}

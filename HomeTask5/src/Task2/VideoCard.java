package Task2;

public class VideoCard extends Computer{
    public VideoCard() {
        this.fillComputerStrategy = new VideoCardFillStrategy();
    }
}

package Test3;

public class Aspirant extends Student {

    Boolean scienceWork = true;

    @Override
    public int getScholarship(double averageMark) {

        if (averageMark == 5) {
            return 200;
        } else {
            return 180;
        }
    }
}

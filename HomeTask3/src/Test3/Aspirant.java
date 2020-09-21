package Test3;

public class Aspirant extends Student {

    private boolean scienceWork = true;

    @Override
    public int getScholarship(double averageMark) {

        if (averageMark == 5) {
            return 200;
        } else {
            return 180;
        }
    }

    public boolean isScienceWork() {
        return scienceWork;
    }

    public void setScienceWork(boolean scienceWork) {
        this.scienceWork = scienceWork;
    }
}

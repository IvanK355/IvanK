package Test3;

public class Student {
    String firstName, lastName, group;
    double averageMark = 4.7;

    public int getScholarship(double averageMark){
        if (averageMark==5.0) return 100; else return 80;
    }
}

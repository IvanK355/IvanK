package Test3;

public class Main {
    public static void main(String[] args) {

        Student student = new Aspirant();
        Student[] students = new Student[2];
        students[0] = new Student();
        students[1] = new Aspirant();
        students[0].setAverageMark(4.0);
        students[1].setAverageMark(5.0);


        for (int i = 0; i < 2; i++) {

            System.out.println(students[i].getScholarship(students[i].getAverageMark()));
        }
    }
}

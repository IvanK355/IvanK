package Test3;

public class Student {


    private String firstName, lastName, group;
    public double averageMark = 4.0;

    public int getScholarship(double averageMark) {

        if (averageMark == 5.0) {
            return 100;
        } else {
            return 80;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}

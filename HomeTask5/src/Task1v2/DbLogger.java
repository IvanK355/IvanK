package Task1v2;

public class DbLogger extends Caculator {

    @Override
    public String makeMultiplication(int a, int b) {

        log(super.makeMultiplication(a, b));
        return null;
    }

    @Override
    public String makeSum(int a, int b) {
        log(super.makeSum(a, b));
        return null;
    }

    @Override
    public String makeSubtraction(int a, int b) {

        log(super.makeSubtraction(a, b));
        return null;
    }

    @Override
    public String makeDivision(int a, int b) {
        log(super.makeDivision(a, b));
        return null;
    }

       public void log(String message) {
        System.out.println("DbLogger - Log into database: " + message);
    }

}

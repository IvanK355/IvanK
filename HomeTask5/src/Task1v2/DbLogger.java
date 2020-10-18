package Task1v2;

public class DbLogger extends Caculator {


    @Override
    public int makeMultiplication(int a, int b) {
        String s = "Выражение "+a+ " * " + b +" = " + super.makeMultiplication(a, b);
        log(s);
        return super.makeMultiplication(a, b);
    }

    @Override
    public int makeSum(int a, int b) {
        String s = "Выражение "+a+ " + " + b +" = " + super.makeSum(a, b);
        log(s);
        return super.makeSum(a, b);
    }

    @Override
    public int makeSubtraction(int a, int b) {

        String s = "Выражение "+a+ " - " + b +" = " + super.makeSubtraction(a, b);
        log(s);
        return super.makeSubtraction(a, b);
    }

    @Override
    public Double makeDivision(int a, int b) {
        String s = "Выражение "+a+ " / " + b +" = " + super.makeDivision(a, b);
        log(s);
        return super.makeDivision(a, b);
    }

       public void log(String message) {
        System.out.println("DbLogger - Log into database: " + message);
    }

}

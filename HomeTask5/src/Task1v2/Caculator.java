package Task1v2;

public abstract class Caculator {

    private String s;

    public String makeMultiplication(int a, int b) {
        return s = "Выражение "+a+ " * " + b +" = " + (a*b);
    }

    public String makeSum(int a, int b) {

            return s = "Выражение "+a+ " + " + b +" = " + (a+b);
    }

    public String makeSubtraction(int a, int b) {
        return s = "Выражение "+a+ " - " + b +" = " + (a-b);
    }

    public String makeDivision(int a, int b) {
        return s = "Выражение "+a+ " / " + b +" = " + (a*1.0/b);
    }
}

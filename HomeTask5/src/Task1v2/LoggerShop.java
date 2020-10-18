package Task1v2;

public abstract class LoggerShop {

    public Caculator orderLogger(LoggerType type, int a, int b, String c) {
        Caculator calculator = createLogger(type);

        switch (c) {
            case "+" -> calculator.makeSum(a, b);
            case "-" -> calculator.makeSubtraction(a, b);
            case "*" -> calculator.makeMultiplication(a, b);
            case "/" -> calculator.makeDivision(a, b);
        }

        System.out.println("Вот ваш результат! Спасибо, приходите еще!");
        return calculator;
    }

    protected abstract Caculator createLogger(LoggerType type);
}

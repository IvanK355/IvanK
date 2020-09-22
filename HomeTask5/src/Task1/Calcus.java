package Task1;

import java.util.Scanner;

public class Calcus {
    public static void main(String[] args) {
        System.out.println("Программа выполняет арифметические выражения над действительными \n" +
                "числами и поддерживает следующие операции: +,-,*,/ . \n" +
                "Для завершения работы прогаммы введите \"exit\" [Enter]");
        System.out.println();
        System.out.print("Введите выражение и нажмите [Enter]:");
        Scanner sc = new Scanner(System.in);

        int a;
        int b;
        String c;
        do {
            String input = sc.nextLine();
            input = input.replaceAll(" ", "");
            if (input.equals("exit")) {
                System.out.println("До свидания!");
                break;
            }
            String[] digit = input.split("\\W");
            String[] operation = input.split("\\w");
            try {
                a = Integer.parseInt(digit[0]);
                b = Integer.parseInt(digit[1]);
                c = operation[operation.length - 1];
                System.out.println("Ответ: " + calculation(a, b, c));
            } catch (Exception e) {
                System.out.println("Ошибка \"Неверный тип данных\": не удалось произвести расчет");
            }
        } while (true);

    }

    private static int calculation(int a, int b, String c) {
        int d;
        String s = null;
        LoggerFactory factory = null;
        switch (c) {
            case "*": {
                factory = new ConsoleLoggerFactory();
                s = "Умножили " + a + " на " + b;
                d = a * b;
                break;
            }
            case "+": {
                factory = new DbLoggerFactory();
                s = "Суммировали " + a + " и " + b;
                d = a + b;
                break;
            }
            case "-": {
                factory = new FileLoggerFactory();
                s = "Вычитание от " + a + " " + b;
                d = a - b;
                break;
            }
            case "/": {
                factory = new ConsoleLoggerFactory();
                s = "Разделили " + a + " на " + b;
                d = a / b;
                break;
            }
            default: {
                factory = new ConsoleLoggerFactory();
                s = "Не было никакой операции";
                d = 0;
                break;
            }
        }
        if(factory != null){
            Logger logger = factory.creatLogger();
            logger.log(s);
        }
        return d;
    }
}

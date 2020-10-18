package Task1v2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Программа выполняет арифметические выражения над целыми \n" +
                "числами и поддерживает следующие операции: +,-,*,/ . \n");


        int a = 0;
        int b = 0;
        String c = null;
        String type;

        System.out.println();
        System.out.print("Введите тип логгирования DBLOGGER,FILELOGGER, CONSOLELOGGER и нажмите [Enter]:");
        Scanner scannerType = new Scanner(System.in);
        type = scannerType.nextLine();

        System.out.println();
        System.out.print("Введите выражение (пример 5*5) и нажмите [Enter]:");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.replaceAll(" ", "");

        String[] digit = input.split("\\W");
        String[] operation = input.split("\\w");
        try {
            a = Integer.parseInt(digit[0]);
            b = Integer.parseInt(digit[1]);
            c = operation[operation.length - 1];

        } catch (Exception e) {
            System.out.println("Ошибка \"Неверный тип данных\": не удалось произвести расчет");
        }

        LoggerShop loggerShop = new LoggerFactory();

        switch (type) {
            case "DBLOGGER" -> loggerShop.orderLogger(LoggerType.DBLOGGER, a, b, c);
            case "FILELOGGER" -> loggerShop.orderLogger(LoggerType.FILELOGGER, a, b, c);
            case "CONSOLELOGGER" -> loggerShop.orderLogger(LoggerType.CONSOLELOGGER, a, b, c);
        }


    }
}



package Task1v2;

public class LoggerFactory extends LoggerShop {

    @Override
    protected Caculator createLogger(LoggerType type) {
        Caculator caculator = switch (type) {
            case DBLOGGER -> new DbLogger();
            case FILELOGGER -> new FileLogger();
            case CONSOLELOGGER -> new ConsoleLogger();
        };
        return caculator;
    }
}

package Task1;

public class ConsoleLoggerFactory extends LoggerFactory {
    @Override
    public Logger creatLogger() {
        return new ConsoleLogger();
    }
}

package Task1;

public class FileLoggerFactory extends LoggerFactory{
    @Override
    public Logger creatLogger() {
        return new FileLogger();
    }
}

package Task1;

public class DbLoggerFactory extends LoggerFactory {
    @Override
    public Logger creatLogger() {
        return new DbLogger();
    }
}

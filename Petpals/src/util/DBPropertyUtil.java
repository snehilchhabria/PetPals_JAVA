package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString(String propertyFileName) throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream(propertyFileName);
        properties.load(in);
        return properties.getProperty("db.connection.string");
    }
}

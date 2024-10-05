package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;

public class DBConnUtil {

    public static Connection getConnection() throws SQLException, IOException {
        String connectionString = DBPropertyUtil.getConnectionString("PetPals/resources/db.properties");
        return DriverManager.getConnection(connectionString);
    }
}

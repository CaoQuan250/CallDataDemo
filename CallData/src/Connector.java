import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getMssql() throws SQLException{
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=student";
        String username ="sa";
        String password ="123";
        Connection connection = DriverManager.getConnection(dbURL,username,password);
        return connection;
    }

}

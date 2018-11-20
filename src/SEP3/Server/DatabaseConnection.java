package SEP3.Server;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private Connection connection = null;

    public synchronized Connection connect() {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "postgres");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}

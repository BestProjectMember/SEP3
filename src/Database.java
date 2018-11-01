import utility.persistence.MyDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
    private MyDatabase db;
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lukaso";
    private static final Database INSTANCE = new Database() ;


    private Database() {
        try {
            this.db = new MyDatabase("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/postgres","postgres", "lukaso");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Database getInstance() {

        return INSTANCE;
    }

    public Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "lukaso");
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return con;
    }

    public synchronized void saveApartment(Apartment apartment)
    {
        String sql = "insert into lald.apartment values('" + apartment.getNumber()  + "'," + "'" + apartment.getLocation()  + "'," + "'"
                + apartment.getSize() + "'," + "'" + apartment.getStatus() + "'," + "'" + apartment.getPrice() + "'," + "'" + apartment.getFloor()  + "');";
        try {
            this.db.update(sql);
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

}

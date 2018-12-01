package SEP3.DatabaseServer;

import java.io.IOException;

public class DatabaseServerMain {

    public static void main (String[] args) throws IOException {
        DatabaseServer databaseServer = new DatabaseServer(6969);
        Thread t = new Thread(databaseServer);
        t.start();
    }
}


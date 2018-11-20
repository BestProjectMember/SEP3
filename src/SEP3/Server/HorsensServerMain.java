package SEP3.Server;

import java.io.IOException;

public class HorsensServerMain {

    public static void main (String[] args) throws IOException {
        HorsensServer server = new HorsensServer(6969);
        Thread t = new Thread(server);
        t.start();

    }
}


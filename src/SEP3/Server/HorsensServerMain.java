package SEP3.Server;

import SEP3.Server.HorsensServer;

import java.io.IOException;

public class HorsensServerMain {

    public static void main (String[] args) {
        try {
            HorsensServer server = new HorsensServer(6789);
            server.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

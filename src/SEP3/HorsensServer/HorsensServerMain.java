package SEP3.HorsensServer;

import java.io.IOException;

public class HorsensServerMain {

    public static void main (String[] args) throws IOException {
        HorsensServer horsensServer = new HorsensServer(6970);
        Thread t = new Thread(horsensServer);
        t.start();
    }
}

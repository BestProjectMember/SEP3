package SEP3.Server;

import java.io.IOException;

public class HorsensServerMain {

    public static void main (String[] args) {
        HorsensServerModel test = new HorsensServerModelManager();
        try {
            HorsensServer server = new HorsensServer(1234);
            System.out.println(test.getTenantList().getAllTenats());
            server.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package SEP3.Client;

public class ClientMain {

    public static void main(String[] args) throws Exception {

        Client client = new Client("localhost", 1234);
        client.execute();


    }

}

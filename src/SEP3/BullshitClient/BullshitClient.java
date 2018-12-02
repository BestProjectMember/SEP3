package SEP3.BullshitClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BullshitClient {

    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    final int PORT = 6970;
    final String HOST = "localhost";

    public BullshitClient() throws IOException {
        clientSocket = new Socket(HOST, PORT);
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());

    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}

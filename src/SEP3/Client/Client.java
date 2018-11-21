package SEP3.Client;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    final int PORT = 6969;
    final String HOST = "localhost";

    public Client() throws IOException {
        clientSocket = new Socket(HOST, PORT);
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
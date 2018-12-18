package SEP3.ClientSide.Domain.Mediator;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    final int PORT = 6970;
    final String HOST = "localhost";

    public Client() throws IOException {
        clientSocket = new Socket(HOST, PORT);
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
package SEP3.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HorsensServer {

    private ServerSocket welcomeSocket;
    private DatabaseConnection connection;

    public HorsensServer(int port) throws IOException {
        this.welcomeSocket = new ServerSocket(port);
        connection = new DatabaseConnection();
    }

    public void execute() {
        System.out.println("Server running...");
        connection.connect();
        System.out.println("Database: " + connection.toString());
        try {
            while (true) {
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected at port" + socket.getPort());
                CommunicatonThreadHandler handler = new CommunicatonThreadHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

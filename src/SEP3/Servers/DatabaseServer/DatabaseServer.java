package SEP3.Servers.DatabaseServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DatabaseServer implements Runnable {

    private ServerSocket welcomeSocket;
    private DatabaseConnection connection;


    public DatabaseServer(int port) throws IOException {
        this.welcomeSocket = new ServerSocket(port);
        connection = new DatabaseConnection();
        connection.connect();
    }

    @Override
    public void run() {
        System.out.println("Waiting for Horsens server...");

        while(true) {
            try {

                Socket socket = welcomeSocket.accept();
                System.out.println("Horsens server at port " + socket.getPort());
                CommunicatonThreadHandler handler = new CommunicatonThreadHandler(socket);
                //handler.ReadFromCsharp(); //todo readFromCsharp
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

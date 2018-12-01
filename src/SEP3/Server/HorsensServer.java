package SEP3.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HorsensServer implements Runnable {

    private ServerSocket welcomeSocket;
    private DatabaseConnection connection;


    public HorsensServer(int port) throws IOException {
        this.welcomeSocket = new ServerSocket(port);
        //connection = new DatabaseConnection();
        //connection.connect();
    }

    @Override
    public void run() {

        while(true) {
            try {
                System.out.println("Waiting for clients...");
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected at port " + socket.getPort());
                CommunicatonThreadHandler handler = new CommunicatonThreadHandler(socket);
                //handler.ReadFromCsharp();
                handler.readRegistration();
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

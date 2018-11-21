package SEP3.Server;

import SEP3.Domain.Model.RqApartment;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HorsensServer {

    private ServerSocket welcomeSocket;
    private DatabaseConnection connection;


    public HorsensServer(int port) throws IOException {
        this.welcomeSocket = new ServerSocket(port);
        connection = new DatabaseConnection();
<<<<<<< HEAD
        //connection.connect();
=======
>>>>>>> parent of 0d97a1e... sockets connection fix
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
<<<<<<< HEAD
                handler.ReadFromCsharp();
                //Thread t = new Thread(handler);
                //t.start();
            } catch (IOException e) {
                e.printStackTrace();
=======
                Thread t = new Thread(handler);
                t.start();
>>>>>>> parent of 0d97a1e... sockets connection fix
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

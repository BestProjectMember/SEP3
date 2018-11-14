package SEP3.Server;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HorsensServer {

    private ServerSocket welcomeSocket;

    public HorsensServer(int port) throws IOException {
        this.welcomeSocket = new ServerSocket(port);
    }

    public void execute() {
        System.out.println("Server running...");
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

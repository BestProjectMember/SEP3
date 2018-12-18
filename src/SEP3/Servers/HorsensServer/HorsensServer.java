package SEP3.Servers.HorsensServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class HorsensServer implements Runnable {

    private ServerSocket welcomeSocket;

    public HorsensServer(int port) throws IOException {
        this.welcomeSocket = new ServerSocket(port);
    }
    @Override
    public void run() {
        System.out.println("Waiting for clients...");
        while(true) {
            try {
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected at port " + socket.getPort());
                HorsensServerCommunicationHandler handler = new HorsensServerCommunicationHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
package SEP3.HorsensServer;

import SEP3.Domain.Mediator.SystemModel;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HorsensServer implements Runnable {

    private ServerSocket serverSocket;
    private SystemModel systemModel;

    public HorsensServer(int port, SystemModel systemModel) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.systemModel = systemModel;
    }

    @Override
    public void run() {
        System.out.println("Waiting for clients...");
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at port " + socket.getPort());
                HorsensServerCommunicationHandler handler = new HorsensServerCommunicationHandler(socket, systemModel);
                //handler.ReadFromCsharp(); //todo readFromCsharp
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

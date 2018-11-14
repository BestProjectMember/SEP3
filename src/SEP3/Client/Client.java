package SEP3.Client;

import SEP3.Domain.Model.Tenant;
import SEP3.Domain.Model.TenantList;
import com.google.gson.Gson;
import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(String host, int port) throws Exception {

        clientSocket = new Socket(host, port);
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());
    }

    public void execute() throws IOException {
        Gson gson = new Gson();

        String input;
        System.out.println("Client running...");
        out.writeUTF("1");

        System.out.println("Client running...");

        input = in.readUTF();

        TenantList list = gson.fromJson(input, TenantList.class);
        
        System.out.println("Client running...");

        System.out.println("end");

    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}

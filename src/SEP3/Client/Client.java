package SEP3.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket clientSocket;
    private Scanner input;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(String host, int port) throws Exception {

        clientSocket = new Socket(host, port);
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());
        input = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("client running");
        try {
            while (true) {

                String smth = input.nextLine();
                    out.writeUTF(smth);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}

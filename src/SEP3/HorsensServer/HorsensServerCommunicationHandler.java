package SEP3.HorsensServer;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HorsensServerCommunicationHandler implements Runnable {

    private DataInputStream inputStreamFromClient;
    private DataOutputStream outputStreamToClient;
    private Socket clientSocket;

    private Socket client_serverSocket;
    final int PORT = 6969;
    final String HOST = "localhost";
    private DataInputStream inputStreamFromDatabaseServer;
    private DataOutputStream outputStreamToDatabaseServer;


    public HorsensServerCommunicationHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            client_serverSocket = new Socket(HOST, PORT);
            inputStreamFromClient = new DataInputStream(clientSocket.getInputStream());
            outputStreamToClient = new DataOutputStream(clientSocket.getOutputStream());

            inputStreamFromDatabaseServer = new DataInputStream(client_serverSocket.getInputStream());
            outputStreamToDatabaseServer = new DataOutputStream(client_serverSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        boolean continueCommuticating = true;
        try {
            while (continueCommuticating) {
                Gson gson = new Gson();
                int selection = inputStreamFromClient.readInt();
                System.out.println("From client: " + selection);

                switch (selection) {
                    case 1 :
                        outputStreamToDatabaseServer.writeInt(selection);
                        String tenantListFromDatabase = inputStreamFromDatabaseServer.readUTF();
                        outputStreamToClient.writeUTF(tenantListFromDatabase);
                        break;

                    case 2 :
//                        String apartmentList = gson.toJson(horsensServerModel.getApartmentListFromDatabaseServer());
//                        outputStreamToClient.writeUTF(apartmentList);
//                        break;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

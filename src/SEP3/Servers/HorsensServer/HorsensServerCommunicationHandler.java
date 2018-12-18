package SEP3.Servers.HorsensServer;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class HorsensServerCommunicationHandler implements Runnable {

    private DataInputStream inputStreamFromClient;
    private DataOutputStream outputStreamToClient;
    private Socket clientSocket;
    private Socket horsens_database_socket;
    final int PORT = 6969;
    final String HOST = "localhost";
    private DataInputStream inputStreamFromDatabaseServer;
    private DataOutputStream outputStreamToDatabaseServer;

    public HorsensServerCommunicationHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            horsens_database_socket = new Socket(HOST, PORT);
            inputStreamFromClient = new DataInputStream(clientSocket.getInputStream());
            outputStreamToClient = new DataOutputStream(clientSocket.getOutputStream());
            inputStreamFromDatabaseServer = new DataInputStream(horsens_database_socket.getInputStream());
            outputStreamToDatabaseServer = new DataOutputStream(horsens_database_socket.getOutputStream());
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
                switch (selection) {
                    case 1: // get tenant list
                        outputStreamToDatabaseServer.writeInt(selection);
                        String tenantListFromDatabase = inputStreamFromDatabaseServer.readUTF();
                        outputStreamToClient.writeUTF(tenantListFromDatabase);
                        break;
                    case 2: // count tenants
                        outputStreamToDatabaseServer.writeInt(selection);
                        outputStreamToClient.writeInt(inputStreamFromDatabaseServer.readInt());
                        break;

                    case 3: // add tenant
                        outputStreamToDatabaseServer.writeInt(selection);
                        String addThisTenant = inputStreamFromClient.readUTF();
                        outputStreamToDatabaseServer.writeUTF(addThisTenant);
                        break;
                    case 4: //remove tenant
                        outputStreamToDatabaseServer.writeInt(selection);
                        String removeThisTenant = inputStreamFromClient.readUTF();
                        outputStreamToDatabaseServer.writeUTF(removeThisTenant);
                        break;
                    case 5: // get apartment list
                        outputStreamToDatabaseServer.writeInt(selection);
                        String apartmentListFromDatabase = inputStreamFromDatabaseServer.readUTF();
                        outputStreamToClient.writeUTF(apartmentListFromDatabase);
                        System.out.println(apartmentListFromDatabase);
                        break;

                        case 6: // add apartment
                        outputStreamToDatabaseServer.writeInt(selection);
                        String addThisApartment = inputStreamFromClient.readUTF();
                        outputStreamToDatabaseServer.writeUTF(addThisApartment);
                        break;
                    case 7: // remove apartment
                        outputStreamToDatabaseServer.writeInt(selection);
                        String removeThisApartment = inputStreamFromClient.readUTF();
                        outputStreamToDatabaseServer.writeUTF(removeThisApartment);
                        break;
                    case 8: // count apartments
                        outputStreamToDatabaseServer.writeInt(selection);
                        outputStreamToClient.writeInt(inputStreamFromDatabaseServer.readInt());
                        break;
                    case 9: // get admin list
                        outputStreamToDatabaseServer.writeInt(selection);
                        String adminListFromDatabase = inputStreamFromDatabaseServer.readUTF();
                        outputStreamToClient.writeUTF(adminListFromDatabase);
                        break;
                    case 10: // count admins
                        outputStreamToDatabaseServer.writeInt(selection);
                        outputStreamToClient.writeInt(inputStreamFromDatabaseServer.readInt());
                        break;
                    case 11: // get request list
                        outputStreamToDatabaseServer.writeInt(selection);
                        String requestListFromDatabase = inputStreamFromDatabaseServer.readUTF();
                        outputStreamToClient.writeUTF(requestListFromDatabase);
                        break;
                    case 12: // count requests
                        outputStreamToDatabaseServer.writeInt(selection);
                        outputStreamToClient.writeInt(inputStreamFromDatabaseServer.readInt());
                        break;
                    case 13: // remove request
                        outputStreamToDatabaseServer.writeInt(selection);
                        String removeThisRequest = inputStreamFromClient.readUTF();
                        outputStreamToDatabaseServer.writeUTF(removeThisRequest);
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
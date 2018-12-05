package SEP3.HorsensServer;

import SEP3.Domain.Mediator.SystemModel;
import SEP3.Domain.Model.ApartmentList;
import SEP3.Domain.Model.TenantList;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HorsensServerCommunicationHandler implements Runnable {

    private DataInputStream inputStreamFromClient;
    private DataOutputStream outputStreamToClient;
    private Socket clientSocket;
    private SystemModel systemModel;

    public HorsensServerCommunicationHandler(Socket socket, SystemModel systemModel) {
        this.systemModel = systemModel;
        this.clientSocket = socket;
        try {
            inputStreamFromClient = new DataInputStream(clientSocket.getInputStream());
            outputStreamToClient = new DataOutputStream(clientSocket.getOutputStream());
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

                switch (5) {
                    case 1 :
                        TenantList tenantListFromModel = systemModel.getTenantListFromDatabase();
                        String tenantListToClient = gson.toJson(tenantListFromModel);
                        outputStreamToClient.writeUTF(tenantListToClient);
                        break;

                    case 5 :
                        ApartmentList apartmentListFromModel = systemModel.getApartmentListFromDatabase();
                        String apartmentListToClient = gson.toJson(apartmentListFromModel);
                        outputStreamToClient.writeUTF(apartmentListToClient);
                        break;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

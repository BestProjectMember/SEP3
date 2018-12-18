package SEP3.Servers.DatabaseServer;

import SEP3.Servers.DatabaseServer.Model.Apartment;
import SEP3.Servers.DatabaseServer.Model.RqApartment;
import SEP3.Servers.DatabaseServer.Model.Tenant;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class DatabaseServerCommunicationHandler implements Runnable {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Socket socket;
    private DatabaseServerModel databaseServerModel;

    public DatabaseServerCommunicationHandler(Socket socket) {
        this.socket = socket;
        databaseServerModel = new DatabaseServerModelManager();
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

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
                int selection = inputStream.readInt();

                switch (selection) {
                    case 1: // get tenant list
                        String tenantList = gson.toJson(databaseServerModel.getTenantListFromDatabase());
                        outputStream.writeUTF(tenantList);
                        break;
                    case 2: // count tenants
                        outputStream.writeInt(databaseServerModel.countTenants());
                        break;

                    case 3: // add tenant
                        Tenant addThisTenant = gson.fromJson(inputStream.readUTF(), Tenant.class);
                        databaseServerModel.addTenant(addThisTenant);
                        break;
                    case 4: //remove tenant
                        Tenant removeThisTenant = gson.fromJson(inputStream.readUTF(), Tenant.class);
                        databaseServerModel.removeTenant(removeThisTenant);
                        break;

                    case 5: // get apartment list
                        String apartmentList = gson.toJson(databaseServerModel.getHorsensApartmentListFromDatabase());
                        outputStream.writeUTF(apartmentList);
                        break;

                        case 6: // add apartment
                        Apartment addThisApartment = gson.fromJson(inputStream.readUTF(), Apartment.class);
                        databaseServerModel.addApartment(addThisApartment);
                        break;

                    case 7: // remove apartment
                        Apartment removeThisApartment = gson.fromJson(inputStream.readUTF(), Apartment.class);
                        databaseServerModel.removeApartment(removeThisApartment);
                        break;
                    case 8: // count apartments
                        outputStream.writeInt(databaseServerModel.countApartments());
                        break;

                    case 9: // get admin list
                        String adminList = gson.toJson(databaseServerModel.getAdministratorListFromDatabase());
                        outputStream.writeUTF(adminList);
                        break;
                    case 10: // count admins
                        outputStream.writeInt(databaseServerModel.countAdmins());
                        break;
                    case 11: // get request list
                        String requestList = gson.toJson(databaseServerModel.getRequestListFromDatabase());
                        outputStream.writeUTF(requestList);
                        break;
                    case 12: // count requests
                        outputStream.writeInt(databaseServerModel.countRequests());
                        break;

                    case 13: // remove apartment
                        RqApartment removeThisRequest = gson.fromJson(inputStream.readUTF(), RqApartment.class);
                        databaseServerModel.removeRequest(removeThisRequest);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

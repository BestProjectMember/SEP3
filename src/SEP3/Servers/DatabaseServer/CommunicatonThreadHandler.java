package SEP3.Servers.DatabaseServer;

import SEP3.Servers.DatabaseServer.Model.Apartment;
import SEP3.Servers.DatabaseServer.Model.Tenant;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CommunicatonThreadHandler implements Runnable {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Socket socket;
    private DatabaseServerModel model;

    public CommunicatonThreadHandler(Socket socket) {
        this.socket = socket;
        model = new DatabaseServerModelManager();
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
                System.out.println("From Horsens server: " + selection);

                switch (selection) {
                    case 1: // get tenant list
                        String tenantList = gson.toJson(model.getTenantListFromDatabase());
                        outputStream.writeUTF(tenantList);
                        break;
                    case 2: // get tenant by ID
                    case 3: // add tenant
                        Tenant addThisTenant = gson.fromJson(inputStream.readUTF(), Tenant.class);
                        model.addTenant(addThisTenant);
                        break;
                    case 4: //remove tenant
                        Tenant removeThisTenant = gson.fromJson(inputStream.readUTF(), Tenant.class);
                        model.removeTenant(removeThisTenant);
                        break;

                    case 5: // get apartment list
                        String apartmentList = gson.toJson(model.getHorsensApartmentListFromDatabase());
                        outputStream.writeUTF(apartmentList);
                        break;
                    case 6: //  get apartment by ID
                    case 7: // change status of apartment
                    case 8: // get admin list
                        String adminList = gson.toJson(model.getAdministratorListFromDatabase());
                        outputStream.writeUTF(adminList);
                        break;
                    case 9: // get admin by ID
                    case 10: // add admin
                    case 11: // remove admin
                    case 12: // add apartment
                        Apartment addThisApartment = gson.fromJson(inputStream.readUTF(), Apartment.class);
                        model.addApartment(addThisApartment);
                        break;
                    case 13: // remove apartment
                        Apartment removeThisApartment = gson.fromJson(inputStream.readUTF(), Apartment.class);
                        model.removeApartment(removeThisApartment);
                        break;
                    case 14: // count tenants
                        outputStream.writeInt(model.countTenants());
                        break;
                    case 15: // count apartments
                        outputStream.writeInt(model.countApartments());
                        break;
                    case 16: // count admins
                        outputStream.writeInt(model.countAdmins());
                        break;
                    case 17: // get request list
                        String requestList = gson.toJson(model.getRequestListFromDatabase());
                        outputStream.writeUTF(requestList);
                        break;
                    case 18: // count requests
                        outputStream.writeInt(model.countRequests());
                        break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadFromCsharp() throws IOException {
        model.receiveApartmentRequestFromWeb(socket);
    }
}

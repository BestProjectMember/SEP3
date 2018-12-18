package SEP3.ClientSide.Domain.Mediator;

import SEP3.ClientSide.Domain.Model.*;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientModelManager implements ClientModel {

    private TenantList tenantList;
    private AdministratorList administratorList;
    private ApartmentList apartmentList;
    private RqApartmentList requestList;
    private DataInputStream in;
    private DataOutputStream out;
    private Client client;
    private Socket clientSocket;
    private Gson gson;
    private int tenantCount;
    private int apartmentCount;
    private int adminCount;
    private int requestCount;

    public ClientModelManager() throws IOException {
        tenantList = new TenantList();
        administratorList = new AdministratorList();
        apartmentList = new ApartmentList();
        requestList = new RqApartmentList();
        client = new Client();
        clientSocket = client.getClientSocket();
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
        gson = new Gson();
    }

    @Override
    public TenantList receiveTenantList() {
        try {
            int choice = 1;
            out.writeInt(choice);
            String input = in.readUTF();
            tenantList = gson.fromJson(input, TenantList.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenantList;
    }

    @Override
    public int countAllTenants() {
        try {
            int choice = 2;
            out.writeInt(choice);
            tenantCount = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tenantCount;
    }

    @Override
    public void addTenant(Tenant tenant) {
        try {
            int choice = 3;
            out.writeInt(choice);
            out.writeUTF(gson.toJson(tenant));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTenant(Tenant tenant) {
        try {
            int choice = 4;
            out.writeInt(choice);
            out.writeUTF(gson.toJson(tenant));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @Override
    public ApartmentList receiveApartmentList() {
        try {
            int choice = 5;
            out.writeInt(choice);
            String input = in.readUTF();
            apartmentList = gson.fromJson(input, ApartmentList.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apartmentList;
    }

    @Override
    public void addApartment(Apartment apartment) {
        try {
            int choice = 6;
            out.writeInt(choice);
            out.writeUTF(gson.toJson(apartment));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeApartment(Apartment apartment) {
        try {
            int choice = 7;
            out.writeInt(choice);
            out.writeUTF(gson.toJson(apartment));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int countAllApartments() {
        try {
            int choice = 8;
            out.writeInt(choice);
            apartmentCount = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apartmentCount;
    }

    @Override
    public AdministratorList receiveAdminList() {
        try {
            int choice = 9;
            out.writeInt(choice);
            String input = in.readUTF();
            administratorList = gson.fromJson(input, AdministratorList.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administratorList;
    }

    @Override
    public int countAllAdmins() {
        try {
            int choice = 10;
            out.writeInt(choice);
            adminCount = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminCount;
    }

    @Override
    public RqApartmentList receiveRequestList() {
        try {
            int choice = 11;
            out.writeInt(choice);
            String input = in.readUTF();
            requestList = gson.fromJson(input, RqApartmentList.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestList;
    }

    @Override
    public int countAllRequests() {
        try {
            int choice = 12;
            out.writeInt(choice);
            requestCount = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestCount;
    }

    @Override
    public void removeRequest(RqApartment request) {
        try {
            int choice = 13;
            out.writeInt(choice);
            out.writeUTF(gson.toJson(request));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

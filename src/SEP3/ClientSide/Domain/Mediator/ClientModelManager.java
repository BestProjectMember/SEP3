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
    private DataInputStream in;
    private DataOutputStream out;
    private Client client;
    private Socket clientSocket;
    private Gson gson;
    private int tenantCount;
    private int apartmentCount;
    private int adminCount;

    public ClientModelManager() throws IOException {
        tenantList = new TenantList();
        administratorList = new AdministratorList();
        apartmentList = new ApartmentList();
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
            System.out.println(choice);
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
            int choice = 14;
            out.writeInt(choice);
            System.out.println(choice);
            tenantCount = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tenantCount;
    }

        @Override
    public ApartmentList receiveApartmentList() {
        try {
            int choice = 5;
            out.writeInt(choice);
            System.out.println(choice);
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
    public int countAllApartments() {
        try {
            int choice = 15;
            out.writeInt(choice);
            System.out.println(choice);
            apartmentCount = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apartmentCount;
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
    public AdministratorList receiveAdminList() {
        try {
            int choice = 8;
            out.writeInt(choice);
            System.out.println(choice);
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
            int choice = 16;
            out.writeInt(choice);
            System.out.println(choice);
            adminCount = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminCount;
    }

    @Override
    public void addApartment(Apartment apartment) {
        try {
            int choice = 12;
            out.writeInt(choice);
            out.writeUTF(gson.toJson(apartment));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeApartment(Apartment apartment) {
        try {
            int choice = 13;
            out.writeInt(choice);
            out.writeUTF(gson.toJson(apartment));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

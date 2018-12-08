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

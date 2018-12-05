package SEP3.Domain.Mediator;

import SEP3.Domain.Model.*;
import SEP3.HorsensServer.HorsensServer;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SystemModelManager implements SystemModel {

    private AdministratorList adminList;
    private TenantList tenantList;
    private ApartmentList apartmentList;
    private DataInputStream in;
    private DataOutputStream out;
    private Client client;
    private HorsensServer horsensServer;
    private final int PORT = 6970;


    public SystemModelManager() throws IOException {
        adminList = new AdministratorList();
        tenantList = new TenantList();
        apartmentList = new ApartmentList();
        client = new Client();
        horsensServer = new HorsensServer(PORT, this);
        Thread startServer = new Thread(horsensServer);
        startServer.start();
    }

//-----------------------------Tenant--------------------------------------

    public void addTenant(Tenant tenant) throws Exception {
        tenantList.addTenant(tenant);
    }

    public void removeTenantByID(String ID){
        tenantList.removeTenantByID(ID);
    }

    public TenantList getTenantListFromDatabase() throws IOException {
        Socket clientSocket = client.getClientSocket();
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
        try {
            Gson gson = new Gson();
            int choice = 1;
            out.writeInt(choice);
            System.out.println(choice);
            String input = in.readUTF();
            tenantList = gson.fromJson(input, TenantList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tenantList;
    }

// -------------Apartment-----------------------------------------------

    public void addApartment(Apartment apartment) throws Exception {
        apartmentList.addApartment(apartment);
    }

    public void removeApartmentByNumber(int number){
        apartmentList.removeApartmentByNumber(number);
    }

    public void changeApartmentStatusByNumber(int number, boolean status){
        apartmentList.changeStatusOfApartmentByNumber(number, status);
    }



    public ApartmentList getApartmentListFromDatabase() throws IOException {
        Socket clientSocket = client.getClientSocket();
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
        try {
            Gson gson = new Gson();
            int choice = 5;
            out.writeInt(choice);
            System.out.println(choice);
            String input = in.readUTF();
            apartmentList = gson.fromJson(input, ApartmentList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apartmentList;
    }

//------------------Admin----------------------------------------

    public AdministratorList getAdministratorListFromDatabase() throws IOException {
        Socket clientSocket = client.getClientSocket();
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
        try {
            Gson gson = new Gson();
            int choice = 8;
            out.writeInt(choice);
            System.out.println(choice);
            String input = in.readUTF();
            adminList = gson.fromJson(input, AdministratorList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminList;
    }



}

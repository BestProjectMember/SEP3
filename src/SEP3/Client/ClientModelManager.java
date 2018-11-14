package SEP3.Client;

import SEP3.Domain.Model.TenantList;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientModelManager implements ClientModel {

    private TenantList tenantList;
    private DataInputStream in;
    private DataOutputStream out;
    private Client client;

    public ClientModelManager() {
        tenantList = new TenantList();
    }

    @Override
    public TenantList receiveTenantList() throws IOException {
        Client client = new Client();
        Socket clientSocket = client.getClientSocket();
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        try {
            Gson gson = new Gson();
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
}

package SEP3.Client;

import SEP3.Domain.Model.TenantList;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientModelManager implements ClientModel {

    private TenantList tenantList;
    private DataInputStream in;
    private DataOutputStream out;
    private Client client;

    @Override
    public TenantList receiveTenantList() {
        try {
            Gson gson = new Gson();
            in = new DataInputStream(client.getClientSocket().getInputStream());
            out = new DataOutputStream(client.getClientSocket().getOutputStream());

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

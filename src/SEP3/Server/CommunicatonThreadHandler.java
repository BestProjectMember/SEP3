package SEP3.Server;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CommunicatonThreadHandler implements Runnable {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Socket socket;
    private HorsensServerModel model;

    public CommunicatonThreadHandler(Socket socket) {
        this.socket = socket;
        model = new HorsensServerModelManager();
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

                int selection = inputStream.readInt();
                Gson gson = new Gson();
                System.out.println(selection);

                switch (selection) {
                    case 1 : String tenantList = gson.toJson(model.getTenantList());
                        outputStream.writeUTF(tenantList);
                        break;

                    case 2 : String apartmentList = gson.toJson(model.getApartmentList());
                        outputStream.writeUTF(apartmentList);
                        break;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadFromCsharp() throws IOException {
        model.receiveApartmentRequest(socket);
    }
}

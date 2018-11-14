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

    public CommunicatonThreadHandler(Socket socket) {
        this.socket = socket;
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {

            while (true) {
                String line = inputStream.readUTF();
                Gson gson = new Gson();
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

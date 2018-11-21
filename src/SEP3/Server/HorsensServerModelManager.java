package SEP3.Server;

import SEP3.Domain.Model.*;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HorsensServerModelManager implements HorsensServerModel {

    private DatabaseConnection databaseConnection;
    private Gson gson = new Gson();
    private Socket socket;


    public HorsensServerModelManager() {
        this.databaseConnection = new DatabaseConnection();
    }

    @Override
    public TenantList getTenantList() {
        Connection connection = databaseConnection.connect();
        TenantList tenantList = new TenantList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("select * from sep3db.tenants");
            while(rs.next()) {
                Tenant tenant = new Tenant(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4).toLocalDate(),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                tenantList.addTenant(tenant);
                System.out.println(tenantList.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenantList;
    }

    @Override
    public ApartmentList getApartmentList() {
        Connection connection = databaseConnection.connect();
        ApartmentList apartmentList = new ApartmentList();
        try {
            ResultSet rs = connection.createStatement().executeQuery(""); //todo query

            while(rs.next()) {
                Apartment apartment = new Apartment(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getBoolean(4),
                        rs.getDouble(5),
                        rs.getInt(6));
                apartmentList.addApartment(apartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apartmentList;
    }
    @Override
    public RqApartment receiveApartmentRequest(Socket socket) throws IOException {
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        byte[] jsonBytes=new byte[1024];
        inputStream.read(jsonBytes);
        RqApartment a = gson.fromJson(new String(jsonBytes).trim(), RqApartment.class);
        System.out.println(a);
        return a;
    }

    @Override
    public void addApartmentRequest() {
        try {
                RqApartment rqApartment = receiveApartmentRequest(socket);
                PreparedStatement preparedStatement;
                DatabaseConnection dc = new DatabaseConnection();
                Connection conn = dc.connect();
                // database statement
                String query = "insert into sep3db.rqapartments(firstName, lastName , id, email, campus, roomNumber) values(?,?,?,?,?,?)";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, rqApartment.getFirstName());
                preparedStatement.setString(2, rqApartment.getLastName());
                preparedStatement.setString(3, rqApartment.getId());
                preparedStatement.setString(4, rqApartment.getEmail());
                preparedStatement.setString(5, rqApartment.getCampus());
                preparedStatement.setString(6, rqApartment.getRoomNumber());
                preparedStatement.execute();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


}

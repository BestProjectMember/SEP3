package SEP3.Servers.DatabaseServer;

import SEP3.Servers.DatabaseServer.Model.*;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.*;

public class DatabaseServerModelManager implements DatabaseServerModel {

    private DatabaseConnection databaseConnection;
    private Gson gson = new Gson();
    private Socket socket;


    public DatabaseServerModelManager() {
        this.databaseConnection = new DatabaseConnection();
    }

    //-----------------------Tenant--------------------------
    @Override
    public TenantList getTenantListFromDatabase() {
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

            }
            //System.out.println(tenantList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenantList;
    }

    @Override
    public void addTenant(Tenant tenant) {
        try {
            PreparedStatement preparedStatement;
            Connection conn = databaseConnection.connect();

            // database statement
            String query = "insert into sep3db.tenants(firstName, lastName, tenantID, DOB, email, telephoneNumber, sex, username, password) values(?,?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, tenant.getFirstName());
            preparedStatement.setString(2, tenant.getLastName());
            preparedStatement.setString(3, tenant.getTenantID());
            preparedStatement.setDate(4,   Date.valueOf(tenant.getDOB()));
            preparedStatement.setString(5, tenant.getEmail());
            preparedStatement.setString(6, tenant.getTelephoneNumber());
            preparedStatement.setString(7, tenant.getSex());
            preparedStatement.setString(8, tenant.getUsername());
            preparedStatement.setString(9, tenant.getPassword());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTenant(Tenant tenant) {
        try {
            PreparedStatement preparedStatement;
            Connection conn = databaseConnection.connect();
            String query = "delete from sep3db.tenants where firstName = ? and lastName = ? and tenantID = ? and DOB = ? and email = ? and telephoneNumber = ? and sex = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,  tenant.getFirstName());
            preparedStatement.setString(2,  tenant.getLastName());
            preparedStatement.setString(3,  tenant.getTenantID());
            preparedStatement.setDate(4,  Date.valueOf(tenant.getDOB()));
            preparedStatement.setString(5,  tenant.getEmail());
            preparedStatement.setString(6, tenant.getTelephoneNumber());
            preparedStatement.setString(7, tenant.getSex());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-------------------Apartment---------------------------------------

    @Override
    public ApartmentList getHorsensApartmentListFromDatabase() {
        Connection connection = databaseConnection.connect();
        ApartmentList apartmentList = new ApartmentList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("select * from sep3db.apartmentshorsens");

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
            //System.out.println(apartmentList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apartmentList;
    }

    @Override
    public void addApartment(Apartment apartment) {
        try {
            PreparedStatement preparedStatement;
            Connection conn = databaseConnection.connect();

            // database statement
            String query = "insert into sep3db.apartmentshorsens(number, location, size, status, price, floor) values(?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,  apartment.getNumber());
            preparedStatement.setString(2,  apartment.getLocation());
            preparedStatement.setInt(3,  apartment.getSize());
            preparedStatement.setBoolean(4,  apartment.getStatus());
            preparedStatement.setDouble(5,  apartment.getPrice());
            preparedStatement.setInt(6, apartment.getFloor());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeApartment(Apartment apartment) {
        try {
            PreparedStatement preparedStatement;
            Connection conn = databaseConnection.connect();

            //database statement
            String query = "delete from sep3db.apartmentshorsens where number = ? and location = ? and size = ? and status = ? and price = ? and floor = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,  apartment.getNumber());
            preparedStatement.setString(2,  apartment.getLocation());
            preparedStatement.setInt(3,  apartment.getSize());
            preparedStatement.setBoolean(4,  apartment.getStatus());
            preparedStatement.setDouble(5,  apartment.getPrice());
            preparedStatement.setInt(6, apartment.getFloor());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////////////////// c#

    // C#
    @Override
    public RqApartment receiveApartmentRequestFromWeb(Socket socket) throws IOException {
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
                RqApartment rqApartment = receiveApartmentRequestFromWeb(socket);
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

    //--------------------Admin---------------------------
    @Override
    public AdministratorList getAdministratorListFromDatabase() {
        Connection connection = databaseConnection.connect();
        AdministratorList adminList = new AdministratorList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("select * from sep3db.administrators");
            while(rs.next()) {
                Administrator administrator = new Administrator(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                adminList.addAdministrator(administrator);

            }
            System.out.println(adminList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminList;
    }



}

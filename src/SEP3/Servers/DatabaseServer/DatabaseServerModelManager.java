package SEP3.Servers.DatabaseServer;

import SEP3.Servers.DatabaseServer.Model.*;
import com.google.gson.Gson;
import java.net.Socket;
import java.sql.*;

public class DatabaseServerModelManager implements DatabaseServerModel {

    private DatabaseConnection databaseConnection;
    private Gson gson;
    private Socket socket;

    public DatabaseServerModelManager() {
        this.databaseConnection = new DatabaseConnection();
        gson = new Gson();
        socket = new Socket();
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

    @Override
    public int countTenants() {
        int tenantCount = 0;
        Connection conn = databaseConnection.connect();

        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from sep3db.tenants");
            while(rs.next()) {
                tenantCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenantCount;
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



    @Override
    public int countApartments() {
        int apartmentCount = 0;
        Connection conn = databaseConnection.connect();

        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from sep3db.apartmentshorsens");
            while(rs.next()) {
                apartmentCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apartmentCount;
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

    @Override
    public int countAdmins() {
        int adminCount = 0;
        Connection conn = databaseConnection.connect();

        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from sep3db.administrators");
            while(rs.next()) {
                adminCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminCount;
    }


    //--------------------Requests---------------------------
    @Override
    public int countRequests() {
        int requestCount = 0;
        Connection conn = databaseConnection.connect();

        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from sep3db.rqapartments");
            while(rs.next()) {
                requestCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requestCount;
    }

    @Override
    public RqApartmentList getRequestListFromDatabase() {
        Connection connection = databaseConnection.connect();
        RqApartmentList requestList = new RqApartmentList();
        try {
            ResultSet rs = connection.createStatement().executeQuery("select * from sep3db.rqapartments");
            while(rs.next()) {
                RqApartment request = new RqApartment(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                requestList.add(request);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestList;
    }

    @Override
    public void removeRequest(RqApartment request) {
        try {
            PreparedStatement preparedStatement;
            Connection conn = databaseConnection.connect();

            //database statement
            String query = "delete from sep3db.rqapartments where firstName = ? and lastName = ? and id = ? and email = ? and campus = ? and roomNumber = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,  request.getFirstName());
            preparedStatement.setString(2,  request.getLastName());
            preparedStatement.setString(3,  request.getId());
            preparedStatement.setString(4,  request.getEmail());
            preparedStatement.setString(5,  request.getCampus());
            preparedStatement.setString(6, request.getRoomNumber());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

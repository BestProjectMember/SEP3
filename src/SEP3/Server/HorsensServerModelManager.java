package SEP3.Server;

import SEP3.Domain.Model.Apartment;
import SEP3.Domain.Model.ApartmentList;
import SEP3.Domain.Model.Tenant;
import SEP3.Domain.Model.TenantList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HorsensServerModelManager implements HorsensServerModel {

    private DatabaseConnection databaseConnection;


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

}

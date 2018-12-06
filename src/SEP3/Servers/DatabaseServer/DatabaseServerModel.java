package SEP3.Servers.DatabaseServer;

import SEP3.Servers.DatabaseServer.Model.*;

import java.io.IOException;
import java.net.Socket;

public interface DatabaseServerModel {

    TenantList getTenantListFromDatabase();
    ApartmentList getHorsensApartmentListFromDatabase();
    RqApartment receiveApartmentRequestFromWeb(Socket socket) throws IOException;
    void addApartmentRequest();
    AdministratorList getAdministratorListFromDatabase();
    void addTenant(Tenant tenant);
    void removeTenant(Tenant tenant);

}

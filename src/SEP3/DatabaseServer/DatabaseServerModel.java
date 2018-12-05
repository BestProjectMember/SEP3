package SEP3.DatabaseServer;

import SEP3.Domain.Model.AdministratorList;
import SEP3.Domain.Model.ApartmentList;
import SEP3.Domain.Model.RqApartment;
import SEP3.Domain.Model.TenantList;

import java.io.IOException;
import java.net.Socket;

public interface DatabaseServerModel {

    TenantList getTenantListFromDatabase();
    ApartmentList getHorsensApartmentListFromDatabase();
    RqApartment receiveApartmentRequestFromWeb(Socket socket) throws IOException;
    void addApartmentRequest();
    AdministratorList getAdministratorListFromDatabase();
}

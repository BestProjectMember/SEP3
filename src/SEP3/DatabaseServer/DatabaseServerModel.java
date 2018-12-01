package SEP3.DatabaseServer;

import SEP3.Domain.Model.ApartmentList;
import SEP3.Domain.Model.RqApartment;
import SEP3.Domain.Model.TenantList;

import java.io.IOException;
import java.net.Socket;

public interface DatabaseServerModel {

    TenantList getTenantListFromDatabase();
    ApartmentList getApartmentListFromDatabase();
    RqApartment receiveApartmentRequestFromWeb(Socket socket) throws IOException;
    void addApartmentRequest();
}

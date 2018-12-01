package SEP3.Server;

import SEP3.Domain.Model.ApartmentList;
import SEP3.Domain.Model.RqApartment;
import SEP3.Domain.Model.Tenant;
import SEP3.Domain.Model.TenantList;

import java.io.IOException;
import java.net.Socket;

public interface HorsensServerModel {

    TenantList getTenantList();
    ApartmentList getApartmentList();
    RqApartment receiveApartmentRequest(Socket socket) throws IOException;
    Tenant receiveTenantRegistration(Socket socket)throws IOException;
    void addApartmentRequest();
}

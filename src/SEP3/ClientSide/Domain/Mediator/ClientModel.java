package SEP3.ClientSide.Domain.Mediator;

import SEP3.ClientSide.Domain.Model.*;

import java.io.IOException;

public interface ClientModel {

    TenantList receiveTenantList() throws IOException;
    int countAllTenants();
    ApartmentList receiveApartmentList();
    int countAllApartments();
    void addTenant(Tenant tenant);
    void removeTenant(Tenant tenant);
    void addApartment(Apartment apartment);
    void removeApartment(Apartment apartment);
    AdministratorList receiveAdminList();
    int countAllAdmins();
    RqApartmentList receiveRequestList();
    int countAllRequests();
    void removeRequest(RqApartment request);
}

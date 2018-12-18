package SEP3.Servers.DatabaseServer;

import SEP3.Servers.DatabaseServer.Model.*;

public interface DatabaseServerModel {

    TenantList getTenantListFromDatabase();
    ApartmentList getHorsensApartmentListFromDatabase();
    AdministratorList getAdministratorListFromDatabase();
    void addTenant(Tenant tenant);
    void removeTenant(Tenant tenant);
    void addApartment(Apartment apartment);
    void removeApartment(Apartment apartment);
    int countTenants();
    int countApartments();
    int countAdmins();
    int countRequests();
    RqApartmentList getRequestListFromDatabase();
    void removeRequest(RqApartment request);

}

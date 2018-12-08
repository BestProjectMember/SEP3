package SEP3.ClientSide.Domain.Mediator;

import SEP3.ClientSide.Domain.Model.Apartment;
import SEP3.ClientSide.Domain.Model.ApartmentList;
import SEP3.ClientSide.Domain.Model.Tenant;
import SEP3.ClientSide.Domain.Model.TenantList;

import java.io.IOException;

public interface ClientModel {

    TenantList receiveTenantList() throws IOException;
    ApartmentList receiveApartmentList();
    void addTenant(Tenant tenant);
    void removeTenant(Tenant tenant);
    void addApartment(Apartment apartment);
    void removeApartment(Apartment apartment);

}

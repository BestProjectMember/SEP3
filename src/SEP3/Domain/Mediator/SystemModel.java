package SEP3.Domain.Mediator;

import SEP3.Domain.Model.Apartment;
import SEP3.Domain.Model.Tenant;
import SEP3.Domain.Model.TenantList;

import java.io.IOException;

public interface SystemModel {


    public void addTenant(Tenant tenant) throws Exception;


    public void removeTenantByID(String ID);

    public TenantList getTenantListFromDatabase() throws IOException;

    public void addApartment(Apartment apartment) throws Exception;

    public void removeApartmentByNumber(int number);

    public void changeApartmentStatusByNumber(int number, boolean status);

    public String getAllAparmtentsInformation();
}

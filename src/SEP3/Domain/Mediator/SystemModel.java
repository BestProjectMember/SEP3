package SEP3.Domain.Mediator;

import SEP3.Domain.Model.*;

import java.io.IOException;

public interface SystemModel {


    public void addTenant(Tenant tenant) throws Exception;


    public void removeTenantByID(String ID);

    public TenantList getTenantListFromDatabase() throws IOException;

    public void addApartment(Apartment apartment) throws Exception;

    public void removeApartmentByNumber(int number);

    public ApartmentList getApartmentListFromDatabase() throws IOException;

    public void changeApartmentStatusByNumber(int number, boolean status);

    public AdministratorList getAdministratorListFromDatabase() throws IOException;


}

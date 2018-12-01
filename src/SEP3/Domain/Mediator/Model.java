package SEP3.Domain.Mediator;

import SEP3.Domain.Model.Apartment;
import SEP3.Domain.Model.Tenant;

public interface Model {


    public void addTenant(Tenant tenant) throws Exception;


    public void removeTenantByID(String ID);

    public String getAllTentantsInformation();
    public void addApartment(Apartment apartment);

    public void removeApartmentByNumber(int number);

    public void changeApartmentStatusByNumber(int number, boolean status);

    public String getAllAparmtentsInformation();
}

package SEP3.BullshitClient;

import SEP3.Domain.Mediator.SystemModel;
import SEP3.Domain.Model.*;

import java.io.IOException;

public class BullshitClientModelManager implements SystemModel {

    @Override
    public void addTenant(Tenant tenant) throws Exception {

    }

    @Override
    public void removeTenantByID(String ID) {

    }

    @Override
    public TenantList getTenantListFromDatabase() throws IOException {
        return null;
    }

    @Override
    public void addApartment(Apartment apartment) throws Exception {

    }

    @Override
    public void removeApartmentByNumber(int number) {

    }

    @Override
    public ApartmentList getApartmentListFromDatabase() throws IOException {
        return null;
    }

    @Override
    public void changeApartmentStatusByNumber(int number, boolean status) {

    }

    @Override
    public AdministratorList getAdministratorListFromDatabase() throws IOException {
        return null;
    }


}

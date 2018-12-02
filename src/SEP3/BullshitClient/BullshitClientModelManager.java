package SEP3.BullshitClient;

import SEP3.Domain.Mediator.SystemModel;
import SEP3.Domain.Model.Apartment;
import SEP3.Domain.Model.Tenant;
import SEP3.Domain.Model.TenantList;

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
    public void changeApartmentStatusByNumber(int number, boolean status) {

    }

    @Override
    public String getAllAparmtentsInformation() {
        return null;
    }
}

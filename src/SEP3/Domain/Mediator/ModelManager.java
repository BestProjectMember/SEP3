package SEP3.Domain.Mediator;

import SEP3.Domain.Model.Administrator;
import SEP3.Domain.Model.Tenant;

public class ModelManager implements Model {

    private Administrator admin;

    public ModelManager() {
        admin = new Administrator("FName", "LName", "13", "1234");
    }


    @Override
    public void addTenant(Tenant tenant) throws Exception {
        admin.addTenant(tenant);
    }

}

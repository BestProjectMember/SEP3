package SEP3.Domain.Mediator;

import SEP3.Domain.Model.ApartmentList;
import SEP3.Domain.Model.TenantList;

public class ClientMain {

    public static void main(String[] args) throws Exception {

        SystemModel model = new SystemModelManager();
        TenantList tenantList = model.getTenantListFromDatabase();
        ApartmentList apartmentList = model.getApartmentListFromDatabase();
        System.out.println(tenantList.getAllTenats());
        System.out.println(apartmentList.getAllApartments());

    }

}

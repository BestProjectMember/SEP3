package SEP3.Domain.Mediator;

import SEP3.Domain.Model.TenantList;

public class ClientMain {

    public static void main(String[] args) throws Exception {

        SystemModel model = new SystemModelManager();
        TenantList list = model.getTenantListFromDatabase();
        System.out.println(list.getAllTenats());

    }

}

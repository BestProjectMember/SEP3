package SEP3.Client;

import SEP3.Domain.Model.TenantList;

public class ClientMain {

    public static void main(String[] args) throws Exception {

        ClientModel model = new ClientModelManager();
        TenantList list;
        list = model.receiveTenantList();
        System.out.println(list.getAllTenats());

    }

}

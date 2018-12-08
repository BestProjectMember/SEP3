package SEP3.Servers.DatabaseServer.Model;

import java.util.ArrayList;

public class TenantList {
    private ArrayList<Tenant> tenantList;


    public TenantList() {
        this.tenantList = new ArrayList<>();
    }

    public void addTenant(Tenant tenant) throws Exception
    {
        // checking if there is tenant with same id
        for(int i = 0; i < tenantList.size(); i++)
        {
            if(tenantList.get(i).getTenantID().equals(tenant.getTenantID()))
                throw new Exception("SEP3.ClientSide.Domain.SystemModel.Tenant with this ID is already in the system");
        }

        // checking if all fields are filled
        if(tenant.getFirstName().equals("") || tenant.getLastName().equals("") || tenant.getTenantID().equals("") || tenant.getDOB().equals(null) || tenant.getEmail().equals("") || tenant.getTelephoneNumber().equals("") || tenant.getSex().equals(""))
            throw new Exception("Make sure to enter all fields");

        tenantList.add(tenant);
    }

    public Tenant get(int index) {
        return tenantList.get(index);
    }

    public void removeTenantByID(String ID){
        for(int i = 0; i < tenantList.size(); i++){
            if (tenantList.get(i).getTenantID().equals(ID)){
                tenantList.remove(i);
            }
        }
    }

        public String getAllTenats() {
            String all = "";
            for (int i = 0; i<tenantList.size(); i++) {
                all+= tenantList.get(i).toString() + "\n";
            }
        return all;
    }

    public int size() {
        return tenantList.size();
    }

    @Override
    public String toString() {
        String all = " ";
        for(int i=0; i<tenantList.size();i++)
        {
            all += tenantList.get(i).toString() + ("\n");
        }
        return all;
    }
}
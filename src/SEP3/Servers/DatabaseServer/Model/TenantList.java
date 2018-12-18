package SEP3.Servers.DatabaseServer.Model;

import java.util.ArrayList;

public class TenantList {
    private ArrayList<Tenant> tenantList;


    public TenantList() {
        this.tenantList = new ArrayList<>();
    }

    public void addTenant(Tenant tenant) {
        tenantList.add(tenant);
    }
    public Tenant get(int index) {
        return tenantList.get(index);
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

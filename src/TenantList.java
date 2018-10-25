import java.util.ArrayList;

public class TenantList {
    private ArrayList<Tenant> tenantList;


    public TenantList() {
        this.tenantList = new ArrayList<>();
    }

    public void setTenantList(ArrayList<Tenant> tenantList) {
        this.tenantList = tenantList;
    }

    public void addTenant(Tenant tenant) throws Exception
    {
        // checking if there is tenat with same id
        for(int i = 0; i < tenantList.size(); i++)
        {
            if(tenantList.get(i).getTenantID().equals(tenant.getTenantID()))
                throw new Exception("Tenant with this ID is already in the system");
        }

        // checking if all fields are filled
        if(tenant.getFirstName().equals("") || tenant.getLastName().equals("") || tenant.getTenantID().equals("") || tenant.getDOB().equals(null) || tenant.getEmail().equals("") || tenant.getTelephoneNumber().equals("") || tenant.getSex().equals(""))
            throw new Exception("Make sure to enter all fields");

        tenantList.add(tenant);
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

}

package SEP3.Servers.DatabaseServer.Model;

import java.util.ArrayList;

public class AdministratorList {
    private ArrayList<Administrator> administratorList;

    public AdministratorList() {
        this.administratorList = new ArrayList<>();
    }

    public void addAdministrator(Administrator administrator) {
        administratorList.add(administrator);
    }

    public int size() {
        return administratorList.size();
    }

    @Override
    public String toString() {
        String all = "";
        for(int i=0; i<administratorList.size();i++)
        {
            all += administratorList.get(i).toString() + ("\n");
        }
        return all;
    }
}
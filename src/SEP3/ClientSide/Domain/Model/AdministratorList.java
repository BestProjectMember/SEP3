package SEP3.ClientSide.Domain.Model;

import java.util.ArrayList;

public class AdministratorList {
    private ArrayList<Administrator> administratorList;


    public AdministratorList() {
        this.administratorList = new ArrayList<>();
    }

    public Administrator getAdministrator(int index) {
        return administratorList.get(index);
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
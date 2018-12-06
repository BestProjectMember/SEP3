package SEP3.Servers.DatabaseServer.Model;

import java.util.ArrayList;

public class AdministratorList {
    private ArrayList<Administrator> administratorList;


    public AdministratorList() {
        this.administratorList = new ArrayList<>();
    }

    public void addAdministrator(Administrator administrator) throws Exception
    {
        // checking if there is administrator with same id
        for(int i = 0; i < administratorList.size(); i++)
        {
            if(administratorList.get(i).getAdministratorID().equals(administrator.getAdministratorID()))
                throw new Exception("SEP3.ClientSide.Domain.SystemModel.Administrator with this ID is already in the system");
        }

        // checking if all fields are filled
        if(administrator.getFirstName().equals("") || administrator.getLastName().equals("") || administrator.getAdministratorID().equals("") || administrator.getTelephoneNumber().equals(""))
            throw new Exception("Make sure to enter all fields");

        administratorList.add(administrator);
    }

    public Administrator getAdministrator(int index) {
        return administratorList.get(index);
    }

    public void removeAdministratorByID(String ID){
        for(int i = 0; i < administratorList.size(); i++){
            if (administratorList.get(i).getAdministratorID().equals(ID)){
                administratorList.remove(i);
            }
        }
    }

    public String getAllAdministrator() {
        String all = "";
        for (int i = 0; i<administratorList.size(); i++) {
            all+= administratorList.get(i).toString() + "\n";
        }
        return all;
    }

    public int size() {
        return administratorList.size();
    }

    @Override
    public String toString() {
        String all = " ";
        for(int i=0; i<administratorList.size();i++)
        {
            all += administratorList.get(i).toString() + ("\n");
        }
        return all;
    }
}
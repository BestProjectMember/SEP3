package SEP3.Domain.Mediator;

import SEP3.Domain.Model.Administrator;
import SEP3.Domain.Model.Apartment;
import SEP3.Domain.Model.Tenant;

public class ModelManager implements Model {

    private Administrator admin;

    public ModelManager() {
        admin = new Administrator("FName", "LName", "13", "1234");
    }


    public void addTenant(Tenant tenant) throws Exception {
        admin.addTenant(tenant);
    }

    public void removeTenantByID(String ID){
        admin.removeTenantByID(ID);
    }

    public String getAllTentantsInformation(){

        return admin.getAllTentantsInformation();
    }

    public void addApartment(Apartment apartment) throws Exception{
        admin.addApartment(apartment);
    }

    public void removeApartmentByNumber(int number){
        admin.removeApartmentByNumber(number);
    }

    public void changeApartmentStatusByNumber(int number, boolean status){
        admin.changeApartmentStatusByNumber(number,status);
    }

    public String getAllAparmtentsInformation(){
        return admin.getAllAparmtentsInformation();
    }



}

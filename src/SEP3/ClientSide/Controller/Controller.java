package SEP3.ClientSide.Controller;

import SEP3.ClientSide.Domain.Mediator.ClientModel;
import SEP3.ClientSide.Domain.Model.Apartment;
import SEP3.ClientSide.Domain.Model.ApartmentList;
import SEP3.ClientSide.Domain.Model.Tenant;
import SEP3.ClientSide.Domain.Model.TenantList;
import SEP3.ClientSide.View.GUI;
import SEP3.ClientSide.View.View;
import java.io.IOException;

public class Controller {

    private View view;
    private ClientModel clientModel;

    /**
     * Controller constructor initializes clientModel and View variables
     *
     * @param //clientModel clientModel interface
     * @param //GUI         View interface
     */
    public Controller(ClientModel clientModel) {
        this.clientModel = clientModel;
        this.view = new GUI();
        view.startView(this);
    }

    public TenantList executeGetAllTenants() throws IOException {
        return clientModel.receiveTenantList();
    }

    public ApartmentList executeGetAllApartments() {
        return clientModel.receiveApartmentList();
    }

    public void executeAddTenant(Tenant tenant) {
        clientModel.addTenant(tenant);
    }

    public void executeRemoveTenant(Tenant tenant){
        clientModel.removeTenant(tenant);
    }

    public void executeAddApartment(Apartment apartment) {
        clientModel.addApartment(apartment);
    }

    public void executeRemoveApartment(Apartment apartment) {
        clientModel.removeApartment(apartment);
    }
}
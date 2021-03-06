package SEP3.ClientSide.Controller;

import SEP3.ClientSide.Domain.Mediator.ClientModel;
import SEP3.ClientSide.Domain.Model.*;
import SEP3.ClientSide.View.GUI;
import SEP3.ClientSide.View.View;
import java.io.IOException;

public class Controller {

    private View view;
    private ClientModel clientModel;


    public Controller(ClientModel clientModel) {
        this.clientModel = clientModel;
        this.view = new GUI();
        view.startView(this);
    }

    public TenantList executeGetAllTenants() throws IOException {
        return clientModel.receiveTenantList();
    }
    public int executeCountAllTenants() {
        return clientModel.countAllTenants();
    }
    public ApartmentList executeGetAllApartments() {
        return clientModel.receiveApartmentList();
    }
    public int executeCountAllApartments() {
        return clientModel.countAllApartments();
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
    public AdministratorList executeGetAllAdmins() {
        return clientModel.receiveAdminList();
    }
    public int executeCountAllAdmins() {
        return clientModel.countAllAdmins();
    }
    public RqApartmentList executeGetAllRequests() {
        return clientModel.receiveRequestList();
    }
    public int executeCountAllRequests() {
        return clientModel.countAllRequests();
    }
    public void executeRemoveRequest(RqApartment request) {
        clientModel.removeRequest(request);
    }




}
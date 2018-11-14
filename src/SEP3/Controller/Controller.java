package SEP3.Controller;

import SEP3.Client.ClientModel;
import SEP3.Domain.Mediator.Model;
import SEP3.Domain.Model.Tenant;
import SEP3.Domain.Model.TenantList;
import SEP3.View.View;

public class Controller {

    private Model model;
    private View view;
    private ClientModel clientModel;

    /**
     * Controller constructor initializes clientModel and View variables
     * @param //clientModel clientModel interface
     * @param GUI View interface
     */
    public Controller(Model model, View GUI) {
        this.model = model;
        this.view = GUI;
    }

    // methods

    public TenantList executeGetAllTenants() {
        return clientModel.receiveTenantList();
    }
}

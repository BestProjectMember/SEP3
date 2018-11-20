package SEP3.Controller;

import SEP3.Client.ClientModel;
import SEP3.Domain.Model.TenantList;
import SEP3.View.View;
import java.io.IOException;

public class Controller {

    private View view;
    private ClientModel clientModel;

    /**
     * Controller constructor initializes clientModel and View variables
     * @param //clientModel clientModel interface
     * @param GUI View interface
     */
    public Controller(ClientModel clientModel, View GUI) {
        this.clientModel = clientModel;
        this.view = GUI;
    }

    // methods

    public TenantList executeGetAllTenants() throws IOException {
        return clientModel.receiveTenantList();
    }
}
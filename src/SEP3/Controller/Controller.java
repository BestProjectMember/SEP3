package SEP3.Controller;

import SEP3.Domain.Mediator.SystemModel;
import SEP3.Domain.Model.TenantList;
import SEP3.View.GUI;
import SEP3.View.View;
import java.io.IOException;

public class Controller {

    private View view;
    private SystemModel systemModel;

    /**
     * Controller constructor initializes clientModel and View variables
     * @param //clientModel clientModel interface
     * @param //GUI View interface
     */
    public Controller(SystemModel systemModel) {
        this.systemModel = systemModel;
        this.view = new GUI();
        view.startView(this);
    }

    // methods
    public TenantList executeGetAllTenants() throws IOException {
        return systemModel.getTenantListFromDatabase();
    }
}
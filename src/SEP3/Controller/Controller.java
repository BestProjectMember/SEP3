package SEP3.Controller;

import SEP3.Domain.Mediator.Model;
import SEP3.Domain.Model.Tenant;
import SEP3.View.View;

public class Controller {

    private Model model;
    private View view;

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

    public void executeAddTenant(Tenant tenant) throws Exception {
        model.addTenant(tenant);
    }
}

package SEP3.View;

import SEP3.Client.Client;
import SEP3.Controller.Controller;
import SEP3.Domain.Mediator.Model;
import SEP3.Domain.Mediator.ModelManager;

public class GuiStart {


    public static void main(String[] args) throws Exception {
        Model model = new ModelManager();
        View view = new GUI();
        Controller controller = new Controller(model, view);
        view.startView(controller);
    }
}

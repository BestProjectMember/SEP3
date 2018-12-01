package SEP3.View;

import SEP3.Client.ClientModel;
import SEP3.Client.ClientModelManager;
import SEP3.Controller.Controller;

public class GuiStart {


    public static void main(String[] args) throws Exception {

        ClientModel model = new ClientModelManager();
        View view = new GUI();
        Controller controller = new Controller(model, view);
        view.startView(controller);
    }
}

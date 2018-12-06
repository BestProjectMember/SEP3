package SEP3.ClientSide.View;


import SEP3.ClientSide.Controller.Controller;
import SEP3.ClientSide.Domain.Mediator.ClientModel;
import SEP3.ClientSide.Domain.Mediator.ClientModelManager;

public class GuiStart {


    public static void main(String[] args) throws Exception {

        ClientModel model = new ClientModelManager();
        Controller controller = new Controller(model);

    }
}

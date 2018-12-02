package SEP3.View;


import SEP3.Controller.Controller;
import SEP3.Domain.Mediator.SystemModel;
import SEP3.Domain.Mediator.SystemModelManager;

public class GuiStart {


    public static void main(String[] args) throws Exception {

        SystemModel model = new SystemModelManager();
        Controller controller = new Controller(model);

    }
}

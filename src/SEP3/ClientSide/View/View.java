package SEP3.ClientSide.View;

import SEP3.ClientSide.Controller.Controller;

public interface View {

    /**
     * startView method starts the GUI view
     * as well as sets the controller
     * @param controller Controller variable
     */
    void startView(Controller controller);
}

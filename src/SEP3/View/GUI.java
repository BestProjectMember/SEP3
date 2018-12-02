package SEP3.View;

import SEP3.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application implements View {

    private Controller controller;
    private MainSceneHandler mainSceneHandler;
    private static GUI gui;

    /**
     * GUI constructor which calls itself if
     * the value is null.
     * If the gui variable is not null
     * then instance variables controller and
     * welcomeSceneHandler are ???
     */

    public GUI() {
        if (gui==null)
        {
            gui = this;
        }
        else
        {
            controller = gui.controller;
            mainSceneHandler = gui.mainSceneHandler;
        }
    }

    /**
     * start method which loads an fxml file,
     * sets the controller for and shows the stage
     * @param primaryStage Stage to be shown
     * @throws Exception Failed to start the stage
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
        loader.setController(this.mainSceneHandler);
        Parent mainWindow = loader.load();
        Scene mainScene = new Scene(mainWindow, 600, 400);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * startView method starts the Graphical
     * user interface
     * @param controller Controller variable
     */
    @Override
    public void startView(Controller controller) {
        this.controller = controller;
        this.mainSceneHandler = new MainSceneHandler(controller);
        Thread t = new Thread(new ViewLauncher(this));
        t.start();
    }
}

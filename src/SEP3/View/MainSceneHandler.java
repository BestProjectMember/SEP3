package SEP3.View;

import SEP3.Controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneHandler implements Initializable {

    private Controller controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public MainSceneHandler(Controller controller) {
        this.controller = controller;
    }

    @FXML
    public void toTenants(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tenantsScene.fxml"));
            loader.setController(new TenantSceneHandler(controller));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 1000, 600);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


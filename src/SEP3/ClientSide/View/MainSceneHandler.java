package SEP3.ClientSide.View;

import SEP3.ClientSide.Controller.Controller;
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
            Scene mainScene = new Scene(mainWindow, 905, 552);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toApartments(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("apartmentScene.fxml"));
            loader.setController(new ApartmentsSceneHandler(controller));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 837, 493);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package SEP3.ClientSide.View;

import SEP3.ClientSide.Controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneHandler implements Initializable {

    private Controller controller;

    // Object count labels
    @FXML Label tenantCount;
    @FXML Label apartmentCount;
    @FXML Label adminCount;
    @FXML Label requestCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tenantCount.setText(String.valueOf(controller.executeCountAllTenants()));
        apartmentCount.setText(String.valueOf(controller.executeCountAllApartments()));
        adminCount.setText(String.valueOf(controller.executeCountAllAdmins()));
        requestCount.setText(String.valueOf(controller.executeCountAllRequests()));
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
            Scene mainScene = new Scene(mainWindow, 874, 550);
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
            Scene mainScene = new Scene(mainWindow, 1200, 493);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toAdmins(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminsScene.fxml"));
            loader.setController(new AdminSceneHandler(controller));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 909, 572);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toRequests(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("rqApartmentsScene.fxml"));
            loader.setController(new RqApartmentsSceneHandler(controller));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 909, 572);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exit() {
        System.exit(0);
    }
}


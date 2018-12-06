package SEP3.ClientSide.View;

import SEP3.ClientSide.Controller.Controller;
import SEP3.ClientSide.Domain.Model.Tenant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class AddTenantSceneHandler implements Initializable {

    private Controller controller;

    //-------------- Tenants fields -------------------
    @FXML TextField tenantFNameInput;
    @FXML TextField tenantLNameInput;
    @FXML TextField tenantIDInput;
    @FXML DatePicker tenantDOBInput;
    @FXML TextField tenantEmailInput;
    @FXML TextField tenantPhoneNumberInput;
    @FXML RadioButton maleButton;
    @FXML RadioButton femaleButton;
    private ToggleGroup radioGroup;


    public AddTenantSceneHandler(Controller controller) {
        this.controller = controller;
        radioGroup = new ToggleGroup();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maleButton.setToggleGroup(radioGroup);
        femaleButton.setToggleGroup(radioGroup);
        maleButton.setSelected(true);
    }

    private Tenant getTenantInput() {
        String gender = "";
        if (maleButton.isSelected()) {
            gender = "M";
        }
        else if (femaleButton.isSelected()) {
            gender = "F";
        }
        Tenant tenant = new Tenant(tenantFNameInput.getText(),
                tenantLNameInput.getText(),
                tenantIDInput.getText(),
                tenantDOBInput.getValue(),
                tenantEmailInput.getText(),
                tenantPhoneNumberInput.getText(),
                gender,
                "-",
                "-");
        return tenant;
    }

    private boolean checkTenantFields() {
        if (tenantFNameInput.getText().isEmpty() ||
                tenantLNameInput.getText().isEmpty() ||
                tenantIDInput.getText().isEmpty() ||
                tenantPhoneNumberInput.getText().isEmpty() ||
                tenantEmailInput.getText().isEmpty()) {

            Alert tenantAddAlert = new Alert(Alert.AlertType.ERROR);
            tenantAddAlert.setTitle("Missing tenant variables");
            tenantAddAlert.setContentText("Fill in all text fields");
            tenantAddAlert.setHeaderText("Empty row error");
            tenantAddAlert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    private void addTenant() throws Exception {

        if (checkTenantFields()) {
            Tenant tenant = getTenantInput();
            controller.executeAddTenant(tenant);
            //Alert
            Alert tenantAddedAlert = new Alert(Alert.AlertType.INFORMATION);
            tenantAddedAlert.setTitle("Tenant added");
            tenantAddedAlert.setHeaderText("Tenant " + tenant.getFirstName() + " " + tenant.getLastName() + " added");
            tenantAddedAlert.showAndWait();
            tenantFNameInput.clear();
            tenantLNameInput.clear();
            tenantIDInput.clear();
            tenantEmailInput.clear();
            tenantPhoneNumberInput.clear();
            tenantDOBInput.getEditor().clear();
        }
    }

    @FXML
    private void handleGoBack(ActionEvent event) {
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
}

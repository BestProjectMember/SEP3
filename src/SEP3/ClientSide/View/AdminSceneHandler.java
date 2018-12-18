package SEP3.ClientSide.View;

import SEP3.ClientSide.Controller.Controller;
import SEP3.ClientSide.Domain.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminSceneHandler implements Initializable {

    private Controller controller;
    private AdministratorList adminList;

    //------------- Admins Table ---------------------
    // Table view
    @FXML private TableView<Administrator> adminTable;
    // Table columns
    @FXML private TableColumn<Administrator, String> adminFNameColumn;
    @FXML private TableColumn<Administrator, String>  adminLNameColumn;
    @FXML private TableColumn<Administrator, String>  adminIdColumn;
    @FXML private TableColumn<Administrator, String> adminEmailColumn;
    // Apartments list
    private ObservableList<Administrator> adminData;

    // Apartment count label
    @FXML private Label adminCount;
    @FXML private TextField adminSearchField;

    public AdminSceneHandler(Controller controller) {
        this.controller = controller;
        adminList = new AdministratorList();
        adminData = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showAdminList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshAdminTable() {
        adminData.clear();
        adminList = controller.executeGetAllAdmins();
        try {
            for (int i = 0; i<adminList.size(); i++) {
                adminData.add(new Administrator(adminList.getAdministrator(i).getFirstName(),
                        adminList.getAdministrator(i).getLastName(),
                        adminList.getAdministrator(i).getAdministratorID(),
                        adminList.getAdministrator(i).getTelephoneNumber()));
            }
            //setting cell value factory to table view
            adminFNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            adminLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            adminIdColumn.setCellValueFactory(new PropertyValueFactory<>("administratorID"));
            adminEmailColumn.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
            adminTable.setItems(adminData);
            countAdmins();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int countAdmins() {
        int adminsCount = controller.executeCountAllAdmins();
        adminCount.setText(String.valueOf(adminsCount));
        return adminsCount;
    }

    @FXML
    private void showAdminList() {
        refreshAdminTable();
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    @FXML
    private void handleGoBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
            loader.setController(new MainSceneHandler(controller));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 800, 550);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

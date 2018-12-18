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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class RqApartmentsSceneHandler implements Initializable {

    private Controller controller;
    private RqApartmentList requestList;
    //------------- Requests Table ---------------------
    // Table view
    @FXML
    private TableView<RqApartment> rqApartmentTable;
    // Table columns
    @FXML private TableColumn<RqApartment, String> rqFNameColumn;
    @FXML private TableColumn<RqApartment, String>  rqLNameColumn;
    @FXML private TableColumn<RqApartment, String>  rqIdColumn;
    @FXML private TableColumn<RqApartment, String> rqEmailColumn;
    @FXML private TableColumn<RqApartment, String> rqCampusColumn;
    @FXML private TableColumn<RqApartment, String> rcRoomNumberColumn;
    //  Request list
    private ObservableList<RqApartment> requestData;

    // requests count label
    @FXML private Label requestCount;

    public RqApartmentsSceneHandler(Controller controller) {
        this.controller = controller;
        requestList = new RqApartmentList();
        requestData = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showRequestsList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Filling the table
    private void refreshRequestsTable() {
        requestData.clear();
        requestList = controller.executeGetAllRequests();
        try {
            for (int i = 0; i<requestList.size(); i++) {
                requestData.add(new RqApartment(requestList.get(i).getFirstName(),
                        requestList.get(i).getLastName(),
                        requestList.get(i).getId(),
                        requestList.get(i).getEmail(),
                        requestList.get(i).getCampus(),
                        requestList.get(i).getRoomNumber()));
            }
            //setting cell value factory to table view
            rqFNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            rqLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            rqIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            rqEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            rqCampusColumn.setCellValueFactory(new PropertyValueFactory<>("campus"));
            rcRoomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
            rqApartmentTable.setItems(requestData);
            countRequests();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showRequestsList() {
        refreshRequestsTable();
    }

    private int countRequests() {
        int rqCount = controller.executeCountAllRequests();
        requestCount.setText(String.valueOf(rqCount));
        return rqCount;
    }

    @FXML
    private void handleGoBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainScene.fxml"));
            loader.setController(new MainSceneHandler(controller));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 800, 550);
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

    @FXML
    public RqApartment getSelectedRequest() {
        RqApartment getRequest = rqApartmentTable.getSelectionModel().getSelectedItem();
        return getRequest;
    }

    @FXML
    private void removeRequest() {
         if (getSelectedRequest() == null) {
             Alert requestNotSelected  = new Alert(Alert.AlertType.ERROR);
             requestNotSelected.setTitle("Request not selected");
             requestNotSelected.setHeaderText("Select request before removing");
             requestNotSelected.showAndWait();
         }
         else {
             RqApartment removeThisRequest = getSelectedRequest();
             controller.executeRemoveRequest(removeThisRequest);
             refreshRequestsTable();
         }
    }
}

package SEP3.ClientSide.View;

import SEP3.ClientSide.Controller.Controller;
import SEP3.ClientSide.Domain.Model.Tenant;
import SEP3.ClientSide.Domain.Model.TenantList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class TenantSceneHandler implements Initializable {

    private Controller controller;
    private TenantList list;

    //------------- Tenants Table ---------------------
    // Table view
    @FXML private TableView<Tenant> tenantsTable;
    // Table columns
    @FXML private TableColumn<Tenant, String> tenantFNameColumn;
    @FXML private TableColumn<Tenant, String>  tenantLNameColumn;
    @FXML private TableColumn<Tenant, String>  tenantIDColumn;
    @FXML private TableColumn<Tenant, LocalDate> tenantDOBColumn;
    @FXML private TableColumn<Tenant, String>  tenantEmailColumn;
    @FXML private TableColumn<Tenant, String>  tenantPhoneNumberColumn;
    @FXML private TableColumn<Tenant, String>  tenantGenderColumn;
    // Tenant list
    private ObservableList<Tenant> tenantData;
    @FXML TextField tenantSearchTextField;

    //-----------------------------------------------------
    @FXML Label tenantsCountLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showTenantList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TenantSceneHandler(Controller controller) {
        this.controller = controller;
        list = new TenantList();
        tenantData = FXCollections.observableArrayList();
    }

    private void refreshTenantsTable() throws IOException {
        tenantData.clear();
        System.out.println(list.toString());
        list = controller.executeGetAllTenants();
        try {
            for (int i = 0; i<list.size(); i++) {
                tenantData.add(new Tenant(list.get(i).getFirstName(),
                        list.get(i).getLastName(),
                        list.get(i).getTenantID(),
                        list.get(i).getDOB(),
                        list.get(i).getEmail(),
                        list.get(i).getTelephoneNumber(),
                        list.get(i).getSex()));
            }
            //setting cell value factory to table view
            tenantFNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            tenantLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            tenantPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
            tenantIDColumn.setCellValueFactory(new PropertyValueFactory<>("tenantID"));
            tenantDOBColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));
            tenantEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            tenantGenderColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
            tenantsTable.setItems(tenantData);
            countTenants();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int countTenants() {
        int tenantsCount = controller.executeCountAllTenants();
        tenantsCountLabel.setText(String.valueOf(tenantsCount));
        return tenantsCount;
    }

    @FXML
    private void showTenantList() throws Exception {
        refreshTenantsTable();
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

    @FXML
    private void addTenantScene (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addTenantScene.fxml"));
            loader.setController(new AddTenantSceneHandler(controller));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 223, 520);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ediTenantScene (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editTenantScene.fxml"));
            loader.setController(new EditTenantSceneHandler(controller, this));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 223, 520);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Tenant getSelectedTenant() {
            Tenant getTenant = tenantsTable.getSelectionModel().getSelectedItem();
            System.out.println(getTenant.toString());
            return getTenant;
    }

    @FXML
    private void removeTenant() {
        try {
            Tenant removeThisTenant = getSelectedTenant();
            controller.executeRemoveTenant(removeThisTenant);
            refreshTenantsTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchTenant() {
        FilteredList<Tenant> filteredList = new FilteredList<>(tenantData, s -> true);
        tenantsTable.setItems(filteredList);
        tenantSearchTextField.setOnKeyTyped(e -> {
            tenantSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super Tenant>) user -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    if (user.getFirstName().toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    } else if (user.getLastName().toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    } else if (user.getTenantID().toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    } else if (user.getEmail().toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    } else if (user.getSex().toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    } else if (user.getTelephoneNumber().toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    }
                    return false;
                });
            });
        });
        SortedList<Tenant> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tenantsTable.comparatorProperty());
        tenantsTable.setItems(sortedList);
    }

    @FXML
    public void exit() {
        System.exit(0);
    }
}

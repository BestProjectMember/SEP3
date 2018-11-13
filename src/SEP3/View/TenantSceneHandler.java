package SEP3.View;

import SEP3.Controller.Controller;
import SEP3.Domain.Model.Tenant;
import SEP3.Domain.Model.TenantList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TenantSceneHandler implements Initializable {

    private Controller controller;
    private TenantList list;

    //------------- Items Table ---------------------
    // Table view
    @FXML private TableView<Tenant> tenantsTable;
    // Table columns
    @FXML private TableColumn<Tenant, String> tenantFNameColumn;
    @FXML private TableColumn<Tenant, String>  tenantLNameColumn;
    @FXML private TableColumn<Tenant, String>  tenantIDColumn;
    @FXML private TableColumn<Tenant, LocalDate>    tenantDOBColumn;
    @FXML private TableColumn<Tenant, String>  tenantEmailColumn;
    @FXML private TableColumn<Tenant, String>  tenantPhoneNumberColumn;
    @FXML private TableColumn<Tenant, String>  tenantGenderColumn;
    // Items list
    private ObservableList<Tenant> tenantData = FXCollections.observableArrayList();
    //-------------- Items fields -------------------
    @FXML TextField tenantFNameInput;
    @FXML TextField tenantLNameInput;
    @FXML TextField tenantIDInput;
    @FXML DatePicker tenantDOBInput;
    @FXML TextField tenantEmailInput;
    @FXML TextField tenantPhoneNumberInput;
    @FXML RadioButton maleButton;
    @FXML RadioButton femaleButton;
    private ToggleGroup radioGroup;
    //-----------------------------------------------------
    @FXML Label tenantsCountLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        radioGroup = new ToggleGroup();
        maleButton.setToggleGroup(radioGroup);
        femaleButton.setToggleGroup(radioGroup);
        maleButton.setSelected(true);
    }

    public TenantSceneHandler() {
        list = new TenantList();

    }

    private void refreshTenantsTable() {
        tenantData.clear();
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int countTenants() {
        int tenantsCount = list.size();
        tenantsCountLabel.setText(String.valueOf(tenantsCount));
        return tenantsCount;
    }

    private Tenant getTenantInput() throws Exception {
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
                gender);
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
    private void showTenantList() throws Exception {
        refreshTenantsTable();
    }

    @FXML
    private void addTenant() throws Exception {

        if (checkTenantFields()) {
            Tenant tenant = getTenantInput();
            list.addTenant(tenant);
            tenantFNameInput.clear();
            tenantLNameInput.clear();
            tenantIDInput.clear();
            tenantEmailInput.clear();
            tenantPhoneNumberInput.clear();
            refreshTenantsTable();

            //Alert
            Alert tenantAddedAlert = new Alert(Alert.AlertType.INFORMATION);
            tenantAddedAlert.setTitle("Tenant added");
            tenantAddedAlert.setHeaderText("Tenant added");
            tenantAddedAlert.showAndWait();
            countTenants();

            System.out.println("Added tenant: " + tenant.toString());

        }
    }
}

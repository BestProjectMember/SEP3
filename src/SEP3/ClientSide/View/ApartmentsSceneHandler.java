package SEP3.ClientSide.View;

import SEP3.ClientSide.Controller.Controller;
import SEP3.ClientSide.Domain.Model.Apartment;
import SEP3.ClientSide.Domain.Model.ApartmentList;
import SEP3.ClientSide.Domain.Model.Tenant;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ApartmentsSceneHandler implements Initializable {

    private Controller controller;
    private ApartmentList apartmentList;

    //------------- Items Table ---------------------
    // Table view
    @FXML
    private TableView<Apartment> apartmentTable;
    // Table columns
    @FXML private TableColumn<Apartment, Integer> apartmentNumberColumn;
    @FXML private TableColumn<Apartment, String>  apartmentLocationColumn;
    @FXML private TableColumn<Apartment, Integer>  apartmentSizeColumn;
    @FXML private TableColumn<Apartment, Boolean> apartmentStatusColumn;
    @FXML private TableColumn<Apartment, Double>  apartmentPriceColumn;
    @FXML private TableColumn<Apartment, Integer>  apartmentFloorColumn;
    // Apartments list
    private ObservableList<Apartment> apartmentData;

    // Apartment count label
    @FXML private Label apartmentCount;

    @FXML private TextField apartmentSearchField;

    public ApartmentsSceneHandler(Controller controller) {
        this.controller = controller;
        apartmentList = new ApartmentList();
        apartmentData = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showApartmentList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Filling the table
    private void refreshApartmentsTable() {
        apartmentData.clear();
        apartmentList = controller.executeGetAllApartments();
        try {
            for (int i = 0; i<apartmentList.size(); i++) {
                apartmentData.add(new Apartment(apartmentList.get(i).getNumber(),
                        apartmentList.get(i).getLocation(),
                        apartmentList.get(i).getSize(),
                        apartmentList.get(i).getStatus(),
                        apartmentList.get(i).getPrice(),
                        apartmentList.get(i).getFloor()));
            }
            //setting cell value factory to table view
            apartmentNumberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
            apartmentLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
            apartmentSizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
            apartmentStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
            apartmentPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            apartmentFloorColumn.setCellValueFactory(new PropertyValueFactory<>("floor"));
            apartmentTable.setItems(apartmentData);
            countApartments();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showApartmentList() {
            refreshApartmentsTable();
    }

    private int countApartments() {
        int appCount = apartmentList.size();
        apartmentCount.setText(String.valueOf(appCount));
        return appCount;
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
    private void editApartmentScene (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editApartmentScene.fxml"));
            loader.setController(new EditApartmentSceneHandler(controller, this));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 222, 537);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchApartment() {
        FilteredList<Apartment> filteredList = new FilteredList<>(apartmentData, s -> true);
        apartmentTable.setItems(filteredList);
        apartmentSearchField.setOnKeyTyped(e -> {
            apartmentSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super Apartment>) user -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    if (String.valueOf(user.getNumber()).toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    } else if (user.getLocation().toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    } else if (String.valueOf(user.getSize()).toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    } else if (String.valueOf(user.getPrice()).contains(newValue.toLowerCase())) {
                        return true;
                    } else if (String.valueOf(user.getFloor()).toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    }
                    return false;
                });
            });
        });
        SortedList<Apartment> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(apartmentTable.comparatorProperty());
        apartmentTable.setItems(sortedList);
    }

    @FXML
    public Apartment getSelectedApartment() {
        Apartment getApartment = apartmentTable.getSelectionModel().getSelectedItem();
        System.out.println(getApartment.toString());
        return getApartment;
    }
}

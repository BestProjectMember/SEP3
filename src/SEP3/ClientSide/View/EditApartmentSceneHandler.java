package SEP3.ClientSide.View;

import SEP3.ClientSide.Controller.Controller;
import SEP3.ClientSide.Domain.Model.Apartment;
import javafx.collections.FXCollections;
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

public class EditApartmentSceneHandler implements Initializable {

    private Controller controller;
    private ApartmentsSceneHandler apartmentsSceneHandler;

    //-------------- Apartment input fields -------------------
    @FXML TextField apartmentNumberInput;
    @FXML ChoiceBox apartmentLocationInput;
    @FXML ChoiceBox apartmentSizeInput;
    @FXML ChoiceBox apartmentFloorInput;
    @FXML TextField apartmentPriceInput;
    @FXML RadioButton takenButton;
    @FXML RadioButton notTakenButton;
    private ToggleGroup radioGroup;
    private String[] locationsArray = {"Horsens", "Aarhus"};
    private int[] sizeArray = {1, 2, 3};
    private int[] floorArray = {0, 1, 2, 3};

    public EditApartmentSceneHandler(Controller controller, ApartmentsSceneHandler handler) {
        this.controller = controller;
        radioGroup = new ToggleGroup();
        apartmentsSceneHandler = handler;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Apartment editThisApartment = apartmentsSceneHandler.getSelectedApartment();
        takenButton.setToggleGroup(radioGroup);
        notTakenButton.setToggleGroup(radioGroup);

        apartmentLocationInput.setItems(FXCollections.observableArrayList(locationsArray[0], locationsArray[1]));
        apartmentLocationInput.setValue(locationsArray[0]);
        apartmentSizeInput.setItems(FXCollections.observableArrayList(sizeArray[0], sizeArray[1], sizeArray[2]));
        apartmentSizeInput.setValue(sizeArray[0]);
        apartmentFloorInput.setItems(FXCollections.observableArrayList(floorArray[0], floorArray[1], floorArray[2], floorArray[3]));
        apartmentNumberInput.setText(String.valueOf(editThisApartment.getNumber()));
        apartmentLocationInput.setValue(editThisApartment.getLocation());
        apartmentSizeInput.setValue(editThisApartment.getSize());
        apartmentFloorInput.setValue(editThisApartment.getFloor());
        apartmentPriceInput.setText(String.valueOf(editThisApartment.getPrice()));
        takenButton.setToggleGroup(radioGroup);
        notTakenButton.setToggleGroup(radioGroup);

        if (editThisApartment.getStatus() == true) {
            takenButton.setSelected(true);
        }
        else  {
            notTakenButton.setSelected(true);
        }
    }

    private Apartment getApartmentInput() {
        boolean status = false;
        if (takenButton.isSelected()) {
            status = true;
        }
        else if (notTakenButton.isSelected()) {
            status = false;
        }

        Apartment apartment = new Apartment(Integer.parseInt(apartmentNumberInput.getText()),
                (String)apartmentLocationInput.getSelectionModel().getSelectedItem(),
                (Integer)apartmentSizeInput.getSelectionModel().getSelectedItem(),
                status,
                Double.parseDouble(apartmentPriceInput.getText()),
                (Integer)apartmentFloorInput.getSelectionModel().getSelectedItem());
        return apartment;
    }

    @FXML
    private void handleGoBack(ActionEvent event) {
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
    private void editApartment(ActionEvent event) {
        Apartment removeThisApartment = apartmentsSceneHandler.getSelectedApartment();
        controller.executeRemoveApartment(removeThisApartment);
        Apartment addThisApartment  = getApartmentInput();
        controller.executeAddApartment(addThisApartment);

        Alert apartmentEditAlert = new Alert(Alert.AlertType.CONFIRMATION);
        apartmentEditAlert.setTitle("Apartment edited");
        apartmentEditAlert.setContentText("edited");
        apartmentEditAlert.setHeaderText("edited");
        apartmentEditAlert.showAndWait();
        handleGoBack(event);
    }
}

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class mainSceneHandler implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public mainSceneHandler() {

    }

    @FXML
    public void toApartments(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("apartmentScene.fxml"));
            Parent mainWindow = loader.load();
            Scene mainScene = new Scene(mainWindow, 500, 500);
            Stage mainStage  = (Stage)((Node) event.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

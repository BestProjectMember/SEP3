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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public MainSceneHandler() {

    }

    public void toApartments(ActionEvent actionEvent) {
        try {
            Parent mainWindow = FXMLLoader.load(getClass().getResource("apartmentScene.fxml"));
            Scene mainScene = new Scene(mainWindow, 500, 500);
            Stage mainStage  = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            mainStage.setScene(mainScene);
            mainStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package SEP3.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiStart extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent mainWindow = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        primaryStage.setTitle("sep3");
        Scene scene = new Scene(mainWindow, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

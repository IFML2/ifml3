package ifml.player;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayerApp extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        if (primaryStage == null) { System.exit(-1); }
        Parent root = FXMLLoader.load(PlayerApp.class.getClassLoader().getResource("main.fxml"));
        primaryStage.setTitle("PIF");
        primaryStage.setScene(new Scene(root, 800.0, 600.0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(PlayerApp.class, args);
    }

}

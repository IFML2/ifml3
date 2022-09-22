package ifml3.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ifml3App extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 800.0, 600.0);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String... args) {
        launch(args);
    }
}

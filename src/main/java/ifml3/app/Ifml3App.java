package ifml3.app;

import ifml3.app.i18n.AppMessage;
import ifml3.app.i18n.AppTranslation;
import ifml3.app.i18n.Translation;
import ifml3.app.view.MainView;
import ifml3.app.view.View;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.stage.Stage;

public class Ifml3App extends Application {

    private Translation translation;
    private View view;

    @Override
    public void init() {
        this.translation = new AppTranslation(ResourceBundle.getBundle("lang/ifml3"));
        this.view = new MainView(translation);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setScene(view.scene());
        stage.setTitle(translation.message(AppMessage.APP_TITLE));
        stage.show();
    }

    public static void main(final String... args) {
        launch(args);
    }
}

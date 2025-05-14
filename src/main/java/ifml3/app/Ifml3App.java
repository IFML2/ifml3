package ifml3.app;

import ifml3.app.i18n.AppMessage;
import ifml3.app.view.MainView;
import ifml3.app.view.View;
import ifml3.app.view.ui.internal.PlayerComponent;
import ifml3.engine.Engine;
import ifml3.engine.internal.SimpleEngine;
import ifml3.lexer.Lexer;
import ifml3.lexer.internal.SimpleLexer;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ifml3.api.i18n.I18N;

public class Ifml3App extends Application {

    private static final Logger logger = LoggerFactory.getLogger(Ifml3App.class);

    private I18N translation;
    private View view;
    private PlayerComponent player;
    private Lexer lexer;
    private Engine engine;

    @Override
    public void init() {
        logger.info("Initialization...");
        this.translation = I18N.create(ResourceBundle.getBundle("lang/ifml3"));
        final var mainView = new MainView(translation);
        this.view = mainView;
        this.player = mainView.player();
        this.lexer = new SimpleLexer();
        this.engine = new SimpleEngine();
        connectComponents();
    }

    private void connectComponents() {
        logger.info("Connect components");
        final var playerConnector = player.uiConnector();
        final var uiConnector = lexer.uiConnector();
        final var engineConnector = lexer.engineConnector();
        final var lexerConnector = engine.lexerConnector();
        playerConnector.publisher().subscribe(uiConnector.subscriber());
        uiConnector.publisher().subscribe(playerConnector.subscriber());
        lexerConnector.publisher().subscribe(engineConnector.subscriber());
        engineConnector.publisher().subscribe(lexerConnector.subscriber());
    }

    @Override
    public void start(final Stage stage) throws Exception {
        logger.info("Start application");
        stage.setScene(view.scene());
        stage.setTitle(translation.message(AppMessage.APP_TITLE));
        stage.show();
    }

    public static void main(final String... args) {
        launch(args);
    }
}

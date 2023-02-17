package ifml3.app.view;

import ifml3.api.ComponentConnector;
import ifml3.app.i18n.AppMessage;
import ifml3.app.i18n.Translation;
import ifml3.app.view.ui.internal.PlayerComponent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

public class MainView implements View {

    private final Translation translation;
    private final Scene scene;
    private final PlayerComponent player;

    public MainView(final Translation translation) {
        this.translation = translation;
        this.player = new PlayerComponent();
        final var pane = new BorderPane(player.get(), menuBar(), label("right"), inputLine(), treeView());
        scene = new Scene(pane, 800.0, 600.0);
    }

    @Override
    public Scene scene() {
        return scene;
    }

    public PlayerComponent player() {
        return player;
    }

    private Label label(final String text) {
        return new Label(text);
    }

    private TreeView treeView() {
        return new TreeView();
    }

    private MenuBar menuBar() {
        return new MenuBar(new Menu(translation.message(AppMessage.APP_MENU_FILE)));
    }

    private ComboBox<String> inputLine() {
        final var comboBox = new ComboBox<String>();
        comboBox.setEditable(true);
        return comboBox;
    }
}

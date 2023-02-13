package ifml3.app.view;

import ifml3.app.i18n.AppMessage;
import ifml3.app.i18n.Translation;
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

    public MainView(final Translation translation) {
        this.translation = translation;
        final var pane = new BorderPane(label("center"), menuBar(), label("right"), inputLine(), treeView());
        scene = new Scene(pane, 800.0, 600.0);
    }

    @Override
    public Scene scene() {
        return scene;
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

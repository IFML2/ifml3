package ifml.player.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class MainView implements Initializable {

    @FXML
    private WebView webView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var webEngine = webView.getEngine();
        webEngine.loadContent("<html><head></head><body>BODY</body></html>");
    }

}

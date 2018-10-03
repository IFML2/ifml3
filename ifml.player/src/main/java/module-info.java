module ifml.player {
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    exports ifml.player;
    exports ifml.player.view;
    opens ifml.player.view to javafx.fxml;
}

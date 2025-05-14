package ifml3.app.view.ui.internal;

import ifml3.api.connector.ComponentConnector;
import ifml3.api.connector.internal.BaseSubscriber;
import ifml3.app.view.ui.UIComponent;
import ifml3.ui.TextSanitizer;
import ifml3.ui.UserCommand;
import ifml3.ui.UserInterface;
import ifml3.ui.UserMessage;
import ifml3.ui.internal.UserTextSanitizer;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerComponent implements UIComponent, UserInterface {

    private static final Logger logger = LoggerFactory.getLogger(PlayerComponent.class);

    private final SubmissionPublisher<UserCommand> publisher;
    private final Subscriber<UserMessage> subscriber;
    private final TextSanitizer sanitizer;
    private final ComponentConnector<UserMessage, UserCommand> connector;
    private final VBox vBox;
    private final TextArea textArea;
    private final TextField textField;

    public PlayerComponent() {
        // @todo at least sanitizer should be as dependency
        this.sanitizer = new UserTextSanitizer();
        this.publisher = new SubmissionPublisher<>();
        this.textArea = new TextArea();
        this.textArea.setEditable(false);
        this.textArea.setPrefRowCount(1_000);
        this.textField = new TextField();
        this.textField.setOnAction(this::processCommand);
        this.vBox = new VBox(textArea, textField);
        this.subscriber = new BaseSubscriber<>(this::processMessage);
        this.connector = ComponentConnector.create(subscriber, publisher);
    }

    @Override
    public Parent get() {
        return vBox;
    }

    @Override
    public ComponentConnector<UserMessage, UserCommand> uiConnector() {
        return connector;
    }

    private void processCommand(final ActionEvent event) {
        final var text = textField.getText();
        logger.info("Input from user: '{}'", text);
        textField.setText("");
        textArea.appendText("> " + text + "\n");
        final var input = sanitizer.sanitize(text);
        // @todo preprocessing needed
        publisher.submit(() -> input);
    }

    private void processMessage(final UserMessage message) {
        logger.info("Get message for user: {}", message);
        textArea.appendText("\n" + message.message() + "\n\n");
    }
}

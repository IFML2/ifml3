package ifml3.ui;

import ifml3.api.ComponentConnector;

public interface UserInterface {

    ComponentConnector<UserMessage, UserCommand> uiConnector();
}

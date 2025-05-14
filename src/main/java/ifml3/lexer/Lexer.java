package ifml3.lexer;

import ifml3.api.connector.ComponentConnector;
import ifml3.engine.EngineCommand;
import ifml3.engine.EngineMessage;
import ifml3.ui.UserCommand;
import ifml3.ui.UserMessage;

public interface Lexer {

    ComponentConnector<UserCommand, UserMessage> uiConnector();

    ComponentConnector<EngineMessage, EngineCommand> engineConnector();
}

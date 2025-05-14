package ifml3.engine;

import ifml3.api.connector.ComponentConnector;

public interface Engine {

    ComponentConnector<EngineCommand, EngineMessage> lexerConnector();
}

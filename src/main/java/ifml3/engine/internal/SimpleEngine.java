package ifml3.engine.internal;

import ifml3.api.ComponentConnector;
import ifml3.api.internal.BaseComponentConnector;
import ifml3.api.internal.BaseSubscriber;
import ifml3.engine.Engine;
import ifml3.engine.EngineCommand;
import ifml3.engine.EngineMessage;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;

public class SimpleEngine implements Engine {

    private final SubmissionPublisher publisher;
    private final Subscriber<EngineCommand> subscriber;
    private final ComponentConnector<EngineCommand, EngineMessage> connector;

    public SimpleEngine() {
        publisher = new SubmissionPublisher();
        subscriber = new BaseSubscriber<>(this::processCommand);
        connector = new BaseComponentConnector<>(subscriber, publisher);
    }

    @Override
    public ComponentConnector<EngineCommand, EngineMessage> lexerConnector() {
        return connector;
    }

    private void processCommand(final EngineCommand command) {
        publisher.submit("engine: непонятная команда.");
    }
}

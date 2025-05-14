package ifml3.api.engine.internal;

import ifml3.api.connector.ComponentConnector;
import ifml3.api.connector.engine.EngineMessage;
import ifml3.api.connector.internal.BaseSubscriber;
import ifml3.api.connector.ui.UIMessage;
import ifml3.api.engine.Engine;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class BaseEngine implements Engine, ComponentConnector<UIMessage, EngineMessage> {

    private final SubmissionPublisher<EngineMessage> publisher;
    private final Flow.Subscriber<UIMessage> subscriber;

    public BaseEngine() {
        this.publisher = new SubmissionPublisher<>();
        this.subscriber = new BaseSubscriber<>(this::process);
    }

    @Override
    public Flow.Subscriber<UIMessage> subscriber() {
        return subscriber;
    }

    @Override
    public Flow.Publisher<EngineMessage> publisher() {
        return publisher;
    }

    private void process(final UIMessage message) {
        //FIXME
    }
}

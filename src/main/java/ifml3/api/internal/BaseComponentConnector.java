package ifml3.api.internal;

import ifml3.api.ComponentConnector;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

public record BaseComponentConnector<IN, OUT>(
        Subscriber<IN> subscriber,
        Publisher<OUT> publisher
) implements ComponentConnector<IN, OUT> {
}

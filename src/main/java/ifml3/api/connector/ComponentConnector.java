package ifml3.api.connector;

import ifml3.api.connector.internal.BaseComponentConnector;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

public interface ComponentConnector<IN, OUT> {

    Subscriber<IN> subscriber();

    Publisher<OUT> publisher();

    static <IN, OUT> ComponentConnector<IN, OUT> create(final Subscriber<IN> in, final Publisher<OUT> out) {
        return new BaseComponentConnector<>(in, out);
    }
}

package ifml3.api;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

public interface ComponentConnector<IN, OUT> {

    Subscriber<IN> subscriber();

    Publisher<OUT> publisher();
}

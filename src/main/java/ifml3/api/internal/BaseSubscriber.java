package ifml3.api.internal;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.Consumer;

public class BaseSubscriber<T> implements Subscriber<T> {

    private final Consumer<T> consumer;

    private Subscription subscription;

    public BaseSubscriber(final Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void onSubscribe(final Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1L);
    }

    @Override
    public void onNext(final T item) {
        consumer.accept(item);
        subscription.request(1L);
    }

    @Override
    public void onError(final Throwable throwable) {
        throw new IllegalStateException(throwable);
    }

    @Override
    public void onComplete() {
    }
}

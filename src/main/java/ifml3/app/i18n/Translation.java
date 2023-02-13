package ifml3.app.i18n;

@FunctionalInterface
public interface Translation {

    String message(Message message);

    @FunctionalInterface
    interface Message {

        String key();
    }
}

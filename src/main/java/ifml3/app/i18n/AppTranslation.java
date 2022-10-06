package ifml3.app.i18n;

import java.util.Objects;
import java.util.ResourceBundle;

public class AppTranslation implements Translation {

    private final ResourceBundle bundle;

    public AppTranslation(final ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public String message(final Message message) {
        return bundle.getString(Objects.requireNonNull(message, "The message cannot be NULL").key());
    }
}

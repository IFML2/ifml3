package ifml3.api.i18n.internal;

import ifml3.api.i18n.I18N;
import java.util.Objects;
import java.util.ResourceBundle;

public class AppI18N implements I18N {

    private final ResourceBundle bundle;

    public AppI18N(final ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public String message(final Message message) {
        return bundle.getString(Objects.requireNonNull(message, "The message cannot be NULL").key());
    }
}

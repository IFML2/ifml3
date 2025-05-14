package ifml3.api.i18n;

import ifml3.api.i18n.internal.AppI18N;
import java.util.ResourceBundle;

@FunctionalInterface
public interface I18N {

    String message(Message message);

    @FunctionalInterface
    interface Message {

        String key();
    }

    static I18N create(final ResourceBundle bundle) {
        return new AppI18N(bundle);
    }
}

package ifml3.app.i18n;

import ifml3.app.i18n.Translation.Message;

public enum AppMessage implements Message {
    APP_TITLE("app.title"),
    APP_MENU_FILE("app.menu.file");

    private final String key;

    AppMessage(final String key) {
        this.key = key;
    }

    @Override
    public String key() {
        return key;
    }
}

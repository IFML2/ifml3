package ifml3.app.i18n;

import java.util.ResourceBundle;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Resource Bundle")
public class ResourceBundleTest {

    @Test
    @DisplayName("should contains all enum items from bundle")
    public void testAllPropertiesAreMapped() {
        final var bundle = ResourceBundle.getBundle("lang.ifml3");
        bundle.keySet().forEach(key -> {
            Assertions.assertTrue(Stream.of(AppMessage.values()).filter(value -> value.key().equals(key)).findFirst().isPresent(), "The key '" + key + "' present into bundle but not present into enum");
        });
    }

    @Test
    @DisplayName("should contains all properties from enum")
    public void testAllItemsHasProperty() {
        final var bundle = ResourceBundle.getBundle("lang.ifml3");
        for (AppMessage message : AppMessage.values()) {
            Assertions.assertNotNull(bundle.getString(message.key()), "The item '" + message.key() + "' present into enum but not present into bundle");
        }
    }
}

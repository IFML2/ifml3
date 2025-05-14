package ifml3.ui;

import ifml3.ui.internal.UserTextSanitizer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Text Sanitizer")
public class TextSanitizerTest {

    @Test
    @DisplayName("can process simple text")
    public void testSimpleText() {
        final var sanitizer = new UserTextSanitizer();
        Assertions.assertEquals("просто текст", sanitizer.sanitize("просто текст"));
    }

    @Test
    @DisplayName("can remove dots")
    public void testRemoveDots() {
        final var sanitizer = new UserTextSanitizer();
        Assertions.assertEquals("ну, не очень так", sanitizer.sanitize("ну, не очень... так."));
    }
}

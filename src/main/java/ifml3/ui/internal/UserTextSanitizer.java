package ifml3.ui.internal;

import ifml3.ui.TextSanitizer;

public class UserTextSanitizer implements TextSanitizer {

    @Override
    public String sanitize(final String text) {
        return text.replaceAll("\\.", "");
    }    
}

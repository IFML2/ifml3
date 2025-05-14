package ifml3.lexer.dictionary;

public interface Word {

    String text();

    Word initForm();

    default boolean isInitForm() {
        return this == initForm();
    }
}

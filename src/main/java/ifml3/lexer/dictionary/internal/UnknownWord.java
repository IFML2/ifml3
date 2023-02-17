package ifml3.lexer.dictionary.internal;

import ifml3.lexer.dictionary.Word;

public record UnknownWord(String text) implements Word {

    @Override
    public Word initForm() {
        return this;
    }
}

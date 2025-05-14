package ifml3.lexer;

import ifml3.lexer.dictionary.Word;
import java.util.Set;

public interface Dictionary {

    Set<Word> find(String text);

    Set<Word> findOrAdd(String text);
}

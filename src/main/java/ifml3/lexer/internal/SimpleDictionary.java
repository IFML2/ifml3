package ifml3.lexer.internal;

import ifml3.lexer.Dictionary;
import ifml3.lexer.dictionary.Word;
import ifml3.lexer.dictionary.internal.UnknownWord;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleDictionary implements Dictionary {

    private static final Logger logger = LoggerFactory.getLogger(SimpleDictionary.class);

    private Map<String, Set<Word>> words;

    public SimpleDictionary() {
        this(new ConcurrentHashMap<>());
    }

    public SimpleDictionary(Map<String, Set<Word>> words) {
        this.words = words;
    }

    @Override
    public Set<Word> find(final String text) {
        logger.info("Try to find word: {}", text);
        if (words.containsKey(text)) {
            return words.get(text);
        }
        logger.info("not found");
        return Collections.emptySet();
    }

    @Override
    public Set<Word> findOrAdd(final String text) {
        logger.info("Try to find word: {}", text);
        if (words.containsKey(text)) {
            return words.get(text);
        }
        logger.info("now found will be added as unkown word: {}", text);
        final var set = new HashSet();
        final var word = new UnknownWord(text);
        set.add(word);
        words.put(text, set);
        return set;
    }
}

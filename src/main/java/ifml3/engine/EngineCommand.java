package ifml3.engine;

import ifml3.lexer.Phrase;
import java.util.Collection;

@FunctionalInterface
public interface EngineCommand {

    Collection<Phrase> phrases();
}

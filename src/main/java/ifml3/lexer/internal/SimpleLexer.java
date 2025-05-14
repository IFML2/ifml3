package ifml3.lexer.internal;

import ifml3.api.connector.ComponentConnector;
import ifml3.api.connector.internal.BaseComponentConnector;
import ifml3.api.connector.internal.BaseSubscriber;
import ifml3.engine.EngineCommand;
import ifml3.engine.EngineMessage;
import ifml3.lexer.Dictionary;
import ifml3.lexer.Lexer;
import ifml3.lexer.Phrase;
import ifml3.lexer.dictionary.Word;
import ifml3.ui.UserCommand;
import ifml3.ui.UserMessage;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLexer implements Lexer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleLexer.class);

    private final Dictionary dictionary;
    private final SubmissionPublisher<UserMessage> uiPublisher;
    private final Subscriber<UserCommand> uiSubscriber;
    private final ComponentConnector<UserCommand, UserMessage> uiConnector;
    private final SubmissionPublisher<EngineCommand> enginePublisher;
    private final Subscriber<EngineMessage> engineSubscriber;
    private final ComponentConnector<EngineMessage, EngineCommand> engineConnector;

    public SimpleLexer() {
        this.dictionary = new SimpleDictionary();
        this.uiPublisher = new SubmissionPublisher<>();
        this.uiSubscriber = new BaseSubscriber<>(this::processUserCommand);
        this.uiConnector = new BaseComponentConnector<>(uiSubscriber, uiPublisher);
        this.enginePublisher = new SubmissionPublisher<>();
        this.engineSubscriber = new BaseSubscriber<>(this::processEngineMessage);
        this.engineConnector = new BaseComponentConnector<>(engineSubscriber, enginePublisher);
    }

    @Override
    public ComponentConnector<UserCommand, UserMessage> uiConnector() {
        return uiConnector;
    }

    @Override
    public ComponentConnector<EngineMessage, EngineCommand> engineConnector() {
        return engineConnector;
    }

    private void processUserCommand(final UserCommand command) {
        logger.info("Got command from user: {}", command);
        final var text = command.command();
        final var wordSets = Stream.of(text.split(" "))
                .map(dictionary::find)
                .collect(Collectors.toList());
        final var phrases = toPhrases(wordSets);
        if (null == phrases || phrases.isEmpty()) {
            uiPublisher.submit(() -> "мне не понятно: " + text);
        } else {
            enginePublisher.submit(() -> phrases);
        }
    }

    private void processEngineMessage(final EngineMessage message) {
        logger.info("Got message from engine: {}", message);
        // @todo: process possible templates
        uiPublisher.submit(() -> message.message());
    }

    private Collection<Phrase> toPhrases(final Collection<Set<Word>> wordSets) {
        // @todo: logic to build phrases
        return Collections.emptyList();
    }
}

package necrojan.games.hangman.model.processor;

import necrojan.games.hangman.model.Badge;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MadMaxProcessor implements Processor {
    @Override
    public Optional<Badge> getOptionalBadgeType(int totalScore, int maxAttempts) {
        return (totalScore >= 3 && maxAttempts >= 15)
                ? Optional.of(Badge.MAD_MAX) :  Optional.empty();
    }

    @Override
    public Badge getBadgeType() {
        return null;
    }
}

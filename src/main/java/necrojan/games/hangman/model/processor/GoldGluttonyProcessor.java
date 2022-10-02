package necrojan.games.hangman.model.processor;

import necrojan.games.hangman.model.Badge;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GoldGluttonyProcessor implements Processor {
    @Override
    public Optional<Badge> getOptionalBadgeType(int totalScore, int maxAttempts) {
        return totalScore >= 10 ? Optional.of(Badge.GOLD_GLUTTONY) : Optional.empty();
    }

    @Override
    public Badge getBadgeType() {
        return Badge.GOLD_GLUTTONY;
    }
}

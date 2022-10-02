package necrojan.games.hangman.model.processor;

import necrojan.games.hangman.model.Badge;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UnstoppableProcessor implements Processor {
    @Override
    public Optional<Badge> getOptionalBadgeType(int totalScore, int maxAttempts) {
        return totalScore >= 3 ? Optional.of(Badge.UNSTOPPABLE) : Optional.empty();
    }

    @Override
    public Badge getBadgeType() {
        return Badge.UNSTOPPABLE;
    }
}

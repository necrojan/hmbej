package necrojan.games.hangman.model.processor;

import necrojan.games.hangman.model.Badge;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SilverStreakProcessor implements Processor{
    @Override
    public Optional<Badge> getOptionalBadgeType(int totalScore, int maxAttempts) {
        return totalScore >= 8 ? Optional.of(Badge.SILVER_STREAK) : Optional.empty();
    }

    @Override
    public Badge getBadgeType() {
        return Badge.SILVER_STREAK;
    }
}

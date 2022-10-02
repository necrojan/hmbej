package necrojan.games.hangman.model.processor;

import necrojan.games.hangman.model.Badge;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BronzeBarrageProcessor implements Processor {
    @Override
    public Optional<Badge> getOptionalBadgeType(int totalScore, int maxAttempts) {
        return totalScore >= 5 ? Optional.of(Badge.BRONZE_BARRAGE) : Optional.empty();
    }

    @Override
    public Badge getBadgeType() {
        return Badge.BRONZE_BARRAGE;
    }
}

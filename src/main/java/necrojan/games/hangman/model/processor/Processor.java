package necrojan.games.hangman.model.processor;

import necrojan.games.hangman.model.Badge;

import java.util.Optional;

public interface Processor {
    Optional<Badge> getOptionalBadgeType(
            int totalScore,
            int maxAttempts
            );

    Badge getBadgeType();
}

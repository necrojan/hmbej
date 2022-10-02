package necrojan.games.hangman.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Badge {
    MAD_MAX("Mad Max"),
    GOLD_GLUTTONY("Gold Gluttony"),
    SILVER_STREAK("Silver Streak"),
    BRONZE_BARRAGE("Bronze Barrage"),
    UNSTOPPABLE("Unstoppable");

    private final String description;
}

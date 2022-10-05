package necrojan.games.hangman.model;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@AllArgsConstructor
public class Board {
    Long userId;
    Long total;

    @With
    List<String> badges;

    public Board(Long userId, Long total) {
        this.userId = userId;
        this.total = total;
        this.badges = List.of();
    }
}

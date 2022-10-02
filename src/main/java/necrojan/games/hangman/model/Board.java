package necrojan.games.hangman.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Value
@AllArgsConstructor
public class Board {
    Long userId;
    int total;

    @With
    List<String> badges;

    public Board(Long userId, int total) {
        this.userId = userId;
        this.total = total;
        this.badges = List.of();
    }
}

package necrojan.games.hangman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "badge_id")
    private Badge badgeType;

    @EqualsAndHashCode.Exclude
    @Column(name = "timestamp")
    private long timeStamp;

    public Card(Long userId, final Badge badge) {
        this(null, userId, badge, System.currentTimeMillis());
    }
}

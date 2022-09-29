package necrojan.games.hangman.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "challenge_attempt")
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "word")
    private String word;

    @Column(name = "max_attempt")
    private int maxAttempt;

    @Column(name = "success")
    private boolean success;
}

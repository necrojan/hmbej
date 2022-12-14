package necrojan.games.hangman.repositories;

import necrojan.games.hangman.model.Board;
import necrojan.games.hangman.model.ChallengeAttempt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChallengeAttemptRepository extends CrudRepository<ChallengeAttempt, Long> {
    List<ChallengeAttempt> findTop10ByUserNameOrderByIdDesc(String name);

    @Query(value = "SELECT COUNT(*) FROM challenge_attempt WHERE user_id = :userId AND success = true", nativeQuery = true)
    Optional<Integer> getTotalSuccessForUser(Long userId);

    @Query(value = "SELECT SUM(max_attempt) FROM challenge_attempt WHERE user_id = :userId and success = true", nativeQuery = true)
    Optional<Integer> totalMaxAttemptsViaUser(Long userId);

    @Query("SELECT NEW necrojan.games.hangman.model.Board(c.user.id, SUM(c.maxAttempt)) " +
            " FROM ChallengeAttempt as c GROUP BY c.user.id ORDER BY SUM(c.maxAttempt) DESC")
    List<Board> findFirst10();
}

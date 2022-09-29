package necrojan.games.hangman.repositories;

import necrojan.games.hangman.model.ChallengeAttempt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeAttemptRepository extends CrudRepository<ChallengeAttempt, Long> {
    List<ChallengeAttempt> findTop10ByUserNameOrderByIdDesc(String name);
}

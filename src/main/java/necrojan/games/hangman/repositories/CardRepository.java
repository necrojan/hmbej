package necrojan.games.hangman.repositories;

import necrojan.games.hangman.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {
    List<Card> findByUserIdOrderByTimeStampDesc(Long userId);
}

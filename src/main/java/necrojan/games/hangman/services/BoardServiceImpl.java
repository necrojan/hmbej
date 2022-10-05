package necrojan.games.hangman.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import necrojan.games.hangman.model.Board;
import necrojan.games.hangman.model.Card;
import necrojan.games.hangman.repositories.CardRepository;
import necrojan.games.hangman.repositories.ChallengeAttemptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final ChallengeAttemptRepository challengeAttemptRepository;

    private final CardRepository cardRepository;

    @Override
    public List<Board> getBoardMembers() {
        return challengeAttemptRepository.findFirst10()
                .stream()
                .map(row -> {
                    List<String> cardList = cardRepository.findByUserIdOrderByTimeStampDesc(row.getUserId())
                            .stream().map(card -> card.getBadgeType().getDescription())
                            .collect(Collectors.toList());
                    return row.withBadges(cardList);
                }).collect(Collectors.toList());
    }
}

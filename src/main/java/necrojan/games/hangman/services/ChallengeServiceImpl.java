package necrojan.games.hangman.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import necrojan.games.hangman.model.*;
import necrojan.games.hangman.model.processor.Processor;
import necrojan.games.hangman.repositories.CardRepository;
import necrojan.games.hangman.repositories.ChallengeAttemptRepository;
import necrojan.games.hangman.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChallengeServiceImpl implements ChallengeService {

    private final UserRepository userRepository;

    private final ChallengeAttemptRepository challengeAttemptRepository;

    private final CardRepository cardRepository;

    private final List<Processor> processors;

    @Override
    public List<ChallengeAttempt> getChallengeList(final String name) {
        return challengeAttemptRepository.findTop10ByUserNameOrderByIdDesc(name);
    }

    @Override
    public ChallengeAttempt storeChallenge(ChallengeAttemptDto challengeAttemptDto) {
        String userName = challengeAttemptDto.getName().toLowerCase();
        User user = userRepository.findByName(userName)
                .orElseGet(() -> userRepository.save(
                        new User(userName)
                ));
        ChallengeAttempt challengeAttempt = new ChallengeAttempt(
                null,
                user,
                challengeAttemptDto.getWord(),
                challengeAttemptDto.getMaxAttempt(),
                challengeAttemptDto.isSuccess()
        );

        // get the success attempts from user
        List<Card> cardList = processCard(user);


        challengeAttemptRepository.save(challengeAttempt);

        return challengeAttempt;
    }

    private List<Card> processCard(User user) {
        Long userId = user.getId();
        Optional<Integer> totalSuccessOpt = challengeAttemptRepository.getTotalSuccessForUser(userId);
        int total = totalSuccessOpt.get();

        Optional<Integer> maxAttemptsOpt = challengeAttemptRepository
                .totalMaxAttemptsViaUser(userId);
        int maxAttempts = maxAttemptsOpt.get();


        Set<Badge> existingBadges = cardRepository.findByUserIdOrderByTimeStampDesc(userId)
                .stream()
                .map(Card::getBadgeType)
                .collect(Collectors.toSet());
        log.info("Existing badges {}", existingBadges);

        List<Card> cards = processors.stream()
                .filter(processor -> !existingBadges.contains(processor.getBadgeType()))
                .map(processor -> processor.getOptionalBadgeType(total, maxAttempts))
                .flatMap(Optional::stream)
                .map(badge -> new Card(user.getId(), badge))
                .collect(Collectors.toList());

        cardRepository.saveAll(cards);

        return cards;
    }
}

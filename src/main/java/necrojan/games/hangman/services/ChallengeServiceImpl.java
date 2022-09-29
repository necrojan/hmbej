package necrojan.games.hangman.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import necrojan.games.hangman.model.ChallengeAttempt;
import necrojan.games.hangman.model.ChallengeAttemptDto;
import necrojan.games.hangman.model.User;
import necrojan.games.hangman.repositories.ChallengeAttemptRepository;
import necrojan.games.hangman.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChallengeServiceImpl implements ChallengeService {

    private final UserRepository userRepository;

    private final ChallengeAttemptRepository challengeAttemptRepository;

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
        log.info("Creating user with name: {}", userName);
        ChallengeAttempt challengeAttempt = new ChallengeAttempt(
                null,
                user,
                challengeAttemptDto.getWord(),
                challengeAttemptDto.getMaxAttempt(),
                challengeAttemptDto.isSuccess()
        );

        challengeAttemptRepository.save(challengeAttempt);

        return challengeAttempt;
    }
}

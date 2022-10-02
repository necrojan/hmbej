package necrojan.games.hangman.services;

import necrojan.games.hangman.model.ChallengeAttempt;
import necrojan.games.hangman.model.ChallengeAttemptDto;
import necrojan.games.hangman.model.User;
import necrojan.games.hangman.model.processor.Processor;
import necrojan.games.hangman.repositories.CardRepository;
import necrojan.games.hangman.repositories.ChallengeAttemptRepository;
import necrojan.games.hangman.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ChallengeServiceTest {

    private ChallengeService challengeService;

    @Mock
    private ChallengeAttemptRepository challengeAttemptRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CardRepository cardRepository;

    @Mock
    private List<Processor> processor;

    @BeforeEach
    public void setUp() {
        challengeService = new ChallengeServiceImpl(
                userRepository,
                challengeAttemptRepository,
                cardRepository,
                processor
                );
    }

    @Test
    public void checkExistingUser() {
        User existingUser = new User(1L, "jon snow");
        given(userRepository.findByName("jon snow")).willReturn(Optional.of(existingUser));

        ChallengeAttemptDto dto = new ChallengeAttemptDto(
                "jon snow",
                "snow",
                5, true
        );

        ChallengeAttempt resultAttempt = challengeService.storeChallenge(dto);

        then(resultAttempt.isSuccess()).isTrue();
        then(resultAttempt.getUser()).isEqualTo(existingUser);
        verify(userRepository, never()).save(any());
    }
}

package necrojan.games.hangman.services;

import necrojan.games.hangman.model.Challenge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.BDDAssertions.then;

public class WordGeneratorServiceTest {

    private final static int MAX_WORD = 5;

    private WordGeneratorService wordGeneratorService;

    @BeforeEach
    public void setUp() {
        wordGeneratorService = new WordGeneratorServiceImpl();
    }

    @Test
    public void generateRandomWordsBetweenFiveAndTwelve() throws IOException {
        Challenge challenge = wordGeneratorService.getRandomWord();

        then(challenge.getWord().length()).isGreaterThanOrEqualTo(MAX_WORD);
    }
}

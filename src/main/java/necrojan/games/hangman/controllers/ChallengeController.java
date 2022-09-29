package necrojan.games.hangman.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import necrojan.games.hangman.model.Challenge;
import necrojan.games.hangman.services.WordGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    private final WordGeneratorService wordGeneratorService;

    @GetMapping("/word")
    Challenge getRandomWord() throws IOException {
        Challenge word = wordGeneratorService.getRandomWord();
        log.info("Random word: {}", word);
        return word;
    }
}

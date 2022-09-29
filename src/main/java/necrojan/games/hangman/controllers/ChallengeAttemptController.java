package necrojan.games.hangman.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import necrojan.games.hangman.model.ChallengeAttempt;
import necrojan.games.hangman.model.ChallengeAttemptDto;
import necrojan.games.hangman.services.ChallengeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/challenge-attempt")
public class ChallengeAttemptController {

    private final ChallengeService challengeService;

    @GetMapping
    public List<ChallengeAttempt> getResult(@RequestParam("name") String name) {
        return challengeService.getChallengeList(name);
    }

    @PostMapping
    public ChallengeAttempt storeResult(@RequestBody @Valid ChallengeAttemptDto challengeAttemptDto) {
        return challengeService.storeChallenge(challengeAttemptDto);
    }
}

package necrojan.games.hangman.services;

import necrojan.games.hangman.model.ChallengeAttempt;
import necrojan.games.hangman.model.ChallengeAttemptDto;

import java.util.List;

public interface ChallengeService {
    ChallengeAttempt storeChallenge(ChallengeAttemptDto challengeAttemptDto);

    List<ChallengeAttempt> getChallengeList(String name);
}

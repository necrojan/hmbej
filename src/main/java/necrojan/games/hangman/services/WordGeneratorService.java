package necrojan.games.hangman.services;

import necrojan.games.hangman.model.Challenge;

import java.io.IOException;

public interface WordGeneratorService {
    Challenge getRandomWord() throws IOException;
}

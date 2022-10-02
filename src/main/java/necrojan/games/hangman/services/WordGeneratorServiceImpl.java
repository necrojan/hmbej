package necrojan.games.hangman.services;

import necrojan.games.hangman.model.Challenge;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Service
public class WordGeneratorServiceImpl implements WordGeneratorService {
    private final static String FILE_NAME = "words.txt";

    private final static int MIN = 5;

    private final static int MAX = 12;

    @Override
    public Challenge getRandomWord() throws IOException {
        return new Challenge(getDataFromFile());
    }

    private String getDataFromFile() throws IOException {
        Resource resourcePath = new ClassPathResource(FILE_NAME);
        List<String> allLines = Files.readAllLines(Paths.get(resourcePath.getURI()));

        Random rand = new Random();
        Predicate<String> betWeenFiveAndTwelve = word -> word.length() >= MIN && word.length() <= MAX;
        List<String> selectedWords = allLines.stream()
                .filter(betWeenFiveAndTwelve).toList();

        int wordSize = selectedWords.size();

        return selectedWords.get(rand.nextInt(wordSize));
    }
}

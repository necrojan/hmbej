package necrojan.games.hangman.model;

import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class ChallengeAttemptDto {
    @NotBlank
    String name;

    @NotBlank
    String word;

    @Min(0)
    int maxAttempt;

    @NotNull
    boolean success;
}

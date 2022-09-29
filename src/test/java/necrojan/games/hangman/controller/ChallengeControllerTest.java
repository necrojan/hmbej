package necrojan.games.hangman.controller;

import necrojan.games.hangman.controllers.ChallengeController;
import necrojan.games.hangman.model.Challenge;
import necrojan.games.hangman.services.WordGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(ChallengeController.class)
public class ChallengeControllerTest {

    @MockBean
    private WordGeneratorService wordGeneratorService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<Challenge> challenge;

    @Test
    void getRandomWord() throws Exception {
        Challenge wordChallenge = wordGeneratorService.getRandomWord();
        given(wordGeneratorService.getRandomWord()).willReturn(wordChallenge);

        MockHttpServletResponse response = mockMvc.perform(
                        get("/challenge/word")
                ).andExpect(status().isOk())
                .andReturn().getResponse();

        then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}

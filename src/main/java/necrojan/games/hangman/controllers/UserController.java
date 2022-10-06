package necrojan.games.hangman.controllers;

import lombok.RequiredArgsConstructor;
import necrojan.games.hangman.model.User;
import necrojan.games.hangman.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}

package necrojan.games.hangman.controllers;

import lombok.RequiredArgsConstructor;
import necrojan.games.hangman.model.Board;
import necrojan.games.hangman.services.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> getBoardList() {
        return boardService.getBoardMembers();
    }
}

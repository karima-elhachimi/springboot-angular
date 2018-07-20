package be.karima.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;


@RestController
class GameController {
    private GameRepository repository;

    public GameController(GameRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/games")
    public Collection<Game> games() {
        return repository.findAll().stream()
                .filter(this::isFun)
                .collect(Collectors.toList());
    }

    private boolean isFun(Game game) {
        return !game.getName().equals("Last of Us") &&
                !game.getName().equals("Kingdom Hearts");
    }


}

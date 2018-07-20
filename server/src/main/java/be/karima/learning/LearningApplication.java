package be.karima.learning;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class LearningApplication {

    public static void main(String[] args) {

        SpringApplication.run(LearningApplication.class, args);
    }

    @Bean
    ApplicationRunner init(GameRepository repository) {
        return args -> {
            Stream.of("Last of Us", "Earth Defender Force", "Mario Kart", "Kingdom Hearts").forEach(name -> {
                Game game = new Game();
                game.setName(name);
                repository.save(game);
            });
        };
    }



}

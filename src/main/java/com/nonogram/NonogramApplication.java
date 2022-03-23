package com.nonogram;

import com.nonogram.Model.Game.MapPanel;
import com.nonogram.Model.Game.ReferenceMap;
import com.nonogram.Model.User.User;
import com.nonogram.Repositories.MapPanelRepository;
import com.nonogram.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class NonogramApplication {
    public static void main(String[] args) {
        SpringApplication.run(NonogramApplication.class, args);

        ReferenceMap map = new ReferenceMap(0);
        map.readMapPanelFromFile();
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    CommandLineRunner initGame(MapPanelRepository mapPanelRepository) {
        return args -> {
            Stream.of(4, 8, 8).forEach(size -> {
                MapPanel panel = new MapPanel(size);
                mapPanelRepository.save(panel);
            });
            mapPanelRepository.findAll().forEach(System.out::println);
        };
    }
}
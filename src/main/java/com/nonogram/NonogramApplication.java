package com.nonogram;

import com.nonogram.Model.Game.ReferenceMap;
import com.nonogram.Model.User.User;
import com.nonogram.Repositories.MapPanelRepository;
import com.nonogram.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.stream.Stream;

@EnableWebMvc
@SpringBootApplication
public class NonogramApplication {
    public static void main(String[] args) {
        SpringApplication.run(NonogramApplication.class, args);
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
            int fileCount = 4;
            ReferenceMap[] referenceMap = new ReferenceMap[10];

            for (int i = 0; i < fileCount; i++) {
                referenceMap[i] = new ReferenceMap(i);
                mapPanelRepository.save(referenceMap[i].readMapPanelFromFile());
            }
            mapPanelRepository.findAll().forEach(System.out::println);
        };
    }
}
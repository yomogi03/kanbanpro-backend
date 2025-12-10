package com.example.kanbanpro.config;

import com.example.kanbanpro.domain.Board;
import com.example.kanbanpro.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initBoard(BoardRepository boardRepository) {
        return args -> {
            if (boardRepository.count() == 0) {
                Board board = new Board();
                board.setName("Sample Board");
                boardRepository.save(board);
                System.out.println("Sample Board inserted");
            }
        };
    }
}


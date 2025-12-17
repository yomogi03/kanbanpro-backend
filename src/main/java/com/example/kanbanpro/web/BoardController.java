package com.example.kanbanpro.web;

import com.example.kanbanpro.domain.Board;
import com.example.kanbanpro.repository.BoardRepository;
import com.example.kanbanpro.web.dto.BoardResponse;
import com.example.kanbanpro.web.dto.CreateBoardRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping
    public List<BoardResponse> getBoards() {
        return boardRepository.findAll().stream()
                .map(b -> new BoardResponse(b.getId(), b.getName(), b.getRegistDate(), b.getUpdateDate()))
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardResponse createBoard(@Valid @RequestBody CreateBoardRequest request) {
        Board board = new Board();
        board.setName(request.name());

        Board saved = boardRepository.save(board);
        return new BoardResponse(saved.getId(), saved.getName(), saved.getRegistDate(), saved.getUpdateDate());
    }
}
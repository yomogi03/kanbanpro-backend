package com.example.kanbanpro.web;

import com.example.kanbanpro.service.BoardService;
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

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public List<BoardResponse> getBoards() {
        return boardService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardResponse createBoard(@Valid @RequestBody CreateBoardRequest request) {
        return boardService.create(request.name());
    }
}
package com.example.kanbanpro.service;

import com.example.kanbanpro.domain.Board;
import com.example.kanbanpro.repository.BoardRepository;
import com.example.kanbanpro.web.dto.BoardResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional(readOnly = true)
    public List<BoardResponse> findAll() {
        return boardRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public BoardResponse create(String name) {
        Board board = new Board();
        board.setName(name);
        Board saved = boardRepository.save(board);
        return toResponse(saved);
    }

    private BoardResponse toResponse(Board b) {
        return new BoardResponse(b.getId(), b.getName(), b.getRegistDate(), b.getUpdateDate());
    }
}

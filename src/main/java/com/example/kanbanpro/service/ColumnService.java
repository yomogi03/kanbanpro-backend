package com.example.kanbanpro.service;

import com.example.kanbanpro.domain.Board;
import com.example.kanbanpro.domain.Column;
import com.example.kanbanpro.repository.BoardRepository;
import com.example.kanbanpro.repository.ColumnRepository;
import com.example.kanbanpro.web.error.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ColumnService {

    private final ColumnRepository columnRepository;
    private final BoardRepository boardRepository;

    public ColumnService(ColumnRepository columnRepository, BoardRepository boardRepository) {
        this.columnRepository = columnRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional(readOnly = true)
    public List<Column> findAll() {
        return columnRepository.findAll();
    }

    public Column create(Long boardId, String name, Integer sortNo) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new ResourceNotFoundException("Board not found with id: " + boardId));
        
        Column column = new Column();
        column.setBoard(board);
        column.setName(name);
        column.setSortNo(sortNo);
        
        return columnRepository.save(column);
    }
}

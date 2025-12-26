package com.example.kanbanpro.web;

import com.example.kanbanpro.domain.Column;
import com.example.kanbanpro.service.ColumnService;
import com.example.kanbanpro.web.dto.CreateColumnRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/columns")
public class ColumnController {

    private final ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @GetMapping
    public List<Column> getColumns() {
        return columnService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Column createColumn(@Valid @RequestBody CreateColumnRequest request) {
        return columnService.create(request.boardId(), request.name(), request.sortNo());
    }
}

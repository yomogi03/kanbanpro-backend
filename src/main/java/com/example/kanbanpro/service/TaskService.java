package com.example.kanbanpro.service;

import com.example.kanbanpro.domain.Column;
import com.example.kanbanpro.domain.Task;
import com.example.kanbanpro.repository.ColumnRepository;
import com.example.kanbanpro.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    private final ColumnRepository columnRepository;

    public TaskService(TaskRepository taskRepository, ColumnRepository columnRepository) {
        this.taskRepository = taskRepository;
        this.columnRepository = columnRepository;
    }

    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task create(Long columnId, String name, Integer sortNo, String comment) {
        Column column = columnRepository.findById(columnId)
                .orElseThrow(() -> new ResourceNotFoundException("Column not found with id: " + columnId));
        
        Task task = new Task();
        task.setColumn(column);
        task.setName(name);
        task.setSortNo(sortNo);
        task.setComment(comment);
        
        return taskRepository.save(task);
    }
}

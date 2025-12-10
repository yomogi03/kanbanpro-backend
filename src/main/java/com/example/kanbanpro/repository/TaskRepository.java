package com.example.kanbanpro.repository;

import com.example.kanbanpro.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

